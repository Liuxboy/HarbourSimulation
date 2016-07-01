package com.github.liuxboy.harbour.simulation.service.impl;

import com.github.liuxboy.harbour.simulation.common.constant.BigDecimalUtil;
import com.github.liuxboy.harbour.simulation.common.util.AlgorithmUtil;
import com.github.liuxboy.harbour.simulation.domain.biz.*;
import com.github.liuxboy.harbour.simulation.service.HarbourSimulationService;
import org.apache.avalon.framework.service.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

import static com.github.liuxboy.harbour.simulation.common.util.AlgorithmUtil.possionSamples;


/**
 * <p>Title: PossionServiceImpl</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/2 15:01</p>
 * <p>Description: 描述 </p>
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
            for (; ;) {
                String task = "产品" + (++i);
                try {
                    queue.put(task);
                    System.out.println(Thread.currentThread()+"生产了:"+task);
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
                    System.out.println(Thread.currentThread()+"消费了:" + task);
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
        for (long i = 0; i <  simulationSteps; i++) {

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
    //船泊总数量
    private int[] genShips(){
        //每天產生船的數組
        int[]  simulationShips = AlgorithmUtil.possionSamples(36, 365);
        return simulationShips;
    }

    //船泊长度分布
    private double[] getWidth(int num){
        num *
        return AlgorithmUtil.normalSamples();
    }


    public static void main(String[] args) {
        BlockingQueue<String> queue = new SynchronousQueue<String>();
        new ProducerThread(queue).start();  //启动生产者线程
        new ConsumerThread(queue).start();  //启动消费者线程
    }
}
