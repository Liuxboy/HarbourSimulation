package com.github.liuxboy.harbour.simulation.service.impl;

import com.github.liuxboy.harbour.simulation.common.constant.BigDecimalUtil;
import com.github.liuxboy.harbour.simulation.common.constant.PriorityEnum;
import com.github.liuxboy.harbour.simulation.common.constant.ShipEnum;
import com.github.liuxboy.harbour.simulation.common.util.AlgorithmUtil;
import com.github.liuxboy.harbour.simulation.domain.biz.*;
import com.github.liuxboy.harbour.simulation.service.HarbourSimulationService;
import org.apache.avalon.framework.service.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.BlockingQueue;


/**
 * <p>Title: HarbourSimulationServiceImpl</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/2 15:01</p>
 * <p>Description: 仿真實現類 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
@Service
public class HarbourSimulationServiceImpl implements HarbourSimulationService {
    /**
     * 生产线程
     */
    public static class ProducerThread extends Thread {
        //阻塞队列
        private BlockingQueue<String> queue;
        //产品编号
        int i = 0;

        public ProducerThread(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            //生产产品，推向队列
            for (; ; ) {
                String task = "产品" + (++i);
                try {
                    queue.put(task);
                    System.out.println(Thread.currentThread() + "生产了:" + task);
                    sleep(3000);
                } catch (InterruptedException e) {
                    //TODO
                }
            }
        }
    }

    /**
     * 消费线程
     */
    public static class ConsumerThread extends Thread {
        private BlockingQueue<String> queue;

        public ConsumerThread(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            String task = null;
            //消费产品
            try {
                while ((task = queue.take()) != null) {
                    System.out.println(Thread.currentThread() + "消费了:" + task);
                }
            } catch (InterruptedException e) {
                //TODO
            }
        }
    }

    @Override
    public List<Result> simulation(List<Anchorage> anchorageList, List<Channel> channelList, List<Berth> berthList,
                                   List<Ship> shipList, List<Traffic> trafficList, List<SimulationTime> timeList) throws ServiceException {
        List<Result> resultList = new ArrayList<Result>();
        SimulationTime simulationTime = new SimulationTime();
        if (!CollectionUtils.isEmpty(timeList))
            simulationTime = timeList.get(0);
        long simulationSteps = simulationTime.getTimeOut() * simulationTime.getTimeOutUnit().getTime()
                / simulationTime.getTimeStep() * simulationTime.getTimeStepUnit().getTime();
        HashMap<String, Ship> shipHashMap = new HashMap<String, Ship>();
        Ship ship;
        //仿真开始
        for (int id = 0; id < simulationSteps; id++) {
            ship = genShip(id);
            if (null == ship) {
                //TODO 说明这一步里没有产生船只,那就看船只運行情況
            } else {

                shipHashMap.put(Integer.toString(id), ship);
                shipHashMap.remove(Integer.toString(id));    //出港后，该船只从此HashMap中移除
            }
        }
        //总的
        long totalInHarbourHours = 0;
        long totalShip = 0;
        Result result = new Result();
        result.setAvgInHarbourTime(BigDecimalUtil.divide(new BigDecimal(totalInHarbourHours), new BigDecimal(totalShip)).toString());  //是指船舶从进港时起到出港时止的平均每艘船在港的停泊时间

        result.setAvgWaitChannelTime("");   //表示船舶在锚地等待进入航道的时间

        result.setAvgOnBerthTime("");       //船舶平均在泊时间，单位：小时
        result.setAvgWaitBerthTime("");     //船舶平均等泊时间，单位：小时
        result.setAwtAstIndex("");
        result.setBerthUtilizationRatio("");//泊位利用率，百分数%

        resultList.add(result);
        return resultList;
    }

    //根据单步产生一条船
    private Ship genShip(int id) {
        //每40分钟产生一条船，根本比例，确定其船舶类型
        if (id % 40 == 0) {
            double proportion = 0.0001 + Math.random(); //产生一个随机数[0, 1)
            if (proportion <= ShipEnum.Container_Ship.getSection()) {
                return getShip(id, ShipEnum.Container_Ship.getTypeCode());
            } else if (ShipEnum.Container_Ship.getSection() < proportion && proportion <= ShipEnum.Iron_Ore.getSection()) {
                return getShip(id, ShipEnum.Iron_Ore.getTypeCode());
            } else if (ShipEnum.Iron_Ore.getSection() < proportion && proportion <= ShipEnum.Chemical_Oil.getProportion()) {
                return getShip(id, ShipEnum.Chemical_Oil.getTypeCode());
            } else if (ShipEnum.Chemical_Oil.getSection() < proportion && proportion <= ShipEnum.Crude_Oil.getSection()) {
                return getShip(id, ShipEnum.Crude_Oil.getTypeCode());
            } else if (ShipEnum.Crude_Oil.getSection() < proportion && proportion <= ShipEnum.Coal.getProportion()) {
                return getShip(id, ShipEnum.Coal.getTypeCode());
            } else {
                return getShip(id, ShipEnum.Break_Bulk_Ship.getTypeCode());
            }
        }
        return null;
    }

    //船泊总数量
    private List<Ship> genShips() {
        int id = 0;
        List<Ship> shipList = new ArrayList<Ship>();
        //每天产生船的数组
        int[] simulationShips = AlgorithmUtil.poissonSamples(36, 365);
        //365天，每天按泊松分布产生这么多条船
        for (int i = 0; i < simulationShips.length; i++) {
            int dayShips = simulationShips[i];
            int cs = getShipNum(dayShips * ShipEnum.Container_Ship.getProportion(), dayShips);
            int io = getShipNum(dayShips * ShipEnum.Iron_Ore.getProportion(), dayShips);
            int co = getShipNum(dayShips * ShipEnum.Chemical_Oil.getProportion(), dayShips);
            int coi = getShipNum(dayShips * ShipEnum.Crude_Oil.getProportion(), dayShips);
            int cl = getShipNum(dayShips * ShipEnum.Coal.getProportion(), dayShips);
            int bbs = getShipNum(dayShips * ShipEnum.Break_Bulk_Ship.getProportion(), dayShips);
            //每天船只属性赋值
            for (int j = 0; j < dayShips; j++) {

                if (j < cs) {                                                               //集装箱
                    shipList.add(getShip(id, ShipEnum.Container_Ship.getTypeCode()));
                } else if (cs <= j && j < cs + io) {                                        //铁矿石
                    shipList.add(getShip(id, ShipEnum.Iron_Ore.getTypeCode()));
                } else if (cs + io <= j && j < cs + io + co) {                              //化工油品
                    shipList.add(getShip(id, ShipEnum.Chemical_Oil.getTypeCode()));
                } else if (cs + io + co <= j && j < cs + io + co + coi) {                    //原油
                    shipList.add(getShip(id, ShipEnum.Crude_Oil.getTypeCode()));
                } else if (cs + io + co + coi <= j && j < cs + io + co + coi + cl) {         //煤炭
                    shipList.add(getShip(id, ShipEnum.Coal.getTypeCode()));
                } else if (cs + io + co + coi + cl <= j && j < cs + io + co + coi + cl + bbs) {  //散船
                    shipList.add(getShip(id, ShipEnum.Break_Bulk_Ship.getTypeCode()));
                }
                id++;
            }
        }
        return shipList;
    }

    //船数量
    private int getShipNum(double proportion, int dayShips) {
        return new BigDecimal(dayShips * proportion).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
    }

    //船只
    private Ship getShip(int id, int typeCode) {
        Ship ship = new Ship();
        ship.setId(id);
        //ship.setTonner();
        ship.setShipEnum(ShipEnum.values()[typeCode]);
        //ship.setDepth();
        //ship.setLambda();
        double length = genLength(ship.getShipEnum().getTypeCode());
        ship.setLength(length);
        ship.setSafeDistance(6 * length);
        //ship.setNumbers();
        if (ship.getShipEnum().getTypeCode() == 2) {
            ship.setPriorityEnum(PriorityEnum.HIGH);
        } else if (ship.getShipEnum().getTypeCode() == 0 || ship.getShipEnum().getTypeCode() == 1) {
            ship.setPriorityEnum(PriorityEnum.LOW);
        } else {
            ship.setPriorityEnum(PriorityEnum.NORMAL);
        }
        ship.setSpeed(AlgorithmUtil.normalSample(1.852, 0.5)); //km/h TODO 正太分佈
        TimeNode timeNode = new TimeNode();
        timeNode.setArriveTime(id); //某一步
        ship.setTimeNode(timeNode);
        return ship;
    }

    //船长
    private double genLength(int typeCode) {
        switch (typeCode) {
            case 0:
                return AlgorithmUtil.normalSample(311.8, 5);    //TODO 方差需要嚴格計算
            case 1:
                return AlgorithmUtil.normalSample(279.4, 5);
            case 2:
                return AlgorithmUtil.normalSample(216.3, 5);
            case 3:
                return AlgorithmUtil.normalSample(259.4, 5);
            case 4:
                return AlgorithmUtil.normalSample(176.2, 5);
            case 5:
                return AlgorithmUtil.normalSample(208.1, 5);
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        /*BlockingQueue<String> queue = new SynchronousQueue<String>();
        new ProducerThread(queue).start();  //启动生产者线程
        new ConsumerThread(queue).start();  //启动消费者线程*/
        HarbourSimulationServiceImpl harbourSimulationService = new HarbourSimulationServiceImpl();
        System.out.printf("船舶列表：", harbourSimulationService.getShip(1, 0));
    }
}
