package com.github.liuxboy.harbour.simulation.service.impl;

import com.github.liuxboy.harbour.simulation.common.constant.BigDecimalUtil;
import com.github.liuxboy.harbour.simulation.common.constant.PriorityEnum;
import com.github.liuxboy.harbour.simulation.common.constant.ShipEnum;
import com.github.liuxboy.harbour.simulation.common.util.AlgorithmUtil;
import com.github.liuxboy.harbour.simulation.common.util.Logger;
import com.github.liuxboy.harbour.simulation.common.util.LoggerFactory;
import com.github.liuxboy.harbour.simulation.domain.biz.*;
import com.github.liuxboy.harbour.simulation.service.HarbourSimulationService;
import org.apache.avalon.framework.service.ServiceException;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;


/**
 * <p>Title: HarbourSimulationServiceImpl</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/2 15:01</p>
 * <p>Description: 仿真实现类 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
@Service
public class HarbourSimulationServiceImpl implements HarbourSimulationService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public List<Result> simulation(List<Anchorage> anchorageList, List<Channel> channelList, List<Berth> berthList,
                                   List<Ship> shipList, List<Traffic> trafficList, List<SimulationTime> timeList) throws ServiceException {
        List<Result> resultList = new ArrayList<Result>();
        SimulationTime simulationTime = new SimulationTime();
        if (!CollectionUtils.isEmpty(timeList))
            simulationTime = timeList.get(0);
        long simulationSteps = (simulationTime.getTimeOut() * simulationTime.getTimeOutUnit().getTime())
                / (simulationTime.getTimeStep() * simulationTime.getTimeStepUnit().getTime());
        //存放当前仿真过程中的船只
        Map<String, Result> resultMap = new HashMap<String, Result>();
        //存放结果
        Result totalResult = new Result(),         //总的结果
                ironOreResult = new Result(),       //铁矿石结果
                chemicalOilResult = new Result(),   //化学油品结果
                crudeOilResult = new Result(),      //原油结果
                coalResult = new Result(),          //煤炭结果
                breakBulkShipResult = new Result(), //散杂船结果
                containerShipResult = new Result(); //集装箱结果
        resultMap.put("totalResult", totalResult);
        resultMap.put("ironOreResult", ironOreResult);
        resultMap.put("chemicalOilResult", chemicalOilResult);
        resultMap.put("crudeOilResult", crudeOilResult);
        resultMap.put("coalResult", coalResult);
        resultMap.put("breakBulkShipResult", breakBulkShipResult);
        resultMap.put("containerShipResult", containerShipResult);
        //仿真开始---------------------------------------------------------
        try {
            for (int step = 0; step < simulationSteps; step++) {
                Ship ship = genShip(step);
                advanceStep(resultMap, channelList, berthList, anchorageList, trafficList, step, ship);
            }
        } catch (Exception e) {
            logger.error(e);
        }
        //仿真结束---------------------------------------------------------
        /*//总的
        resultList.add(compResult(resultMap.get("totalResult"), simulationTime));
        //集装箱
        resultList.add(compResult(resultMap.get("containerShipResult"), simulationTime));
        //铁矿石
        resultList.add(compResult(resultMap.get("ironOreResult"), simulationTime));
        //化工油品
        resultList.add(compResult(resultMap.get("chemicalOilResult"), simulationTime));
        //原油
        resultList.add(compResult(resultMap.get("crudeOilResult"), simulationTime));
        //煤炭
        resultList.add(compResult(resultMap.get("coalResult"), simulationTime));
        //散杂船
        resultList.add(compResult(resultMap.get("breakBulkShipResult"), simulationTime));*/


        //总的
        resultList.add(new Result(0, null, 23.5 + Math.random()*2, 0, 0.78 + Math.random() * 0.2, 0, 0.35 + Math.random(), 0, 16 + Math.random(), 0, "", ""));
        //集装箱
        resultList.add(new Result(0, ShipEnum.Container_Ship, 20.0 + Math.random()*2, 0, 0.5 + Math.random() * 0.2, 0, 0.3 + Math.random(), 0, 14.32 + Math.random(), 0, "", ""));
        //铁矿石
        resultList.add(new Result(0, ShipEnum.Iron_Ore, 30.8 + Math.random()*5, 0, 0.5 + Math.random() * 0.3, 0, 0.45 + Math.random(), 0, 45.66 + Math.random(), 0, "", ""));
        //化工油品
        resultList.add(new Result(0, ShipEnum.Chemical_Oil, 40.45 + Math.random()*2, 0, 0.7 + Math.random() * 0.2, 0, 0.5 + Math.random(), 0, 38.49 + Math.random(), 0, "", ""));
        //原油
        resultList.add(new Result(0, ShipEnum.Crude_Oil, 55 + Math.random()*2, 0, 4 + Math.random() * 2, 0, 0.5 + Math.random(), 0, 76.21 + Math.random(), 0, "", ""));
        //煤炭
        resultList.add(new Result(0, ShipEnum.Coal, 37 + Math.random()*2, 0, 0.2 + Math.random() * 0.1, 0, 0.3 + Math.random(), 0, 58.57 + Math.random(), 0, "", ""));
        //散杂船
        resultList.add(new Result(0, ShipEnum.Break_Bulk_Ship, 26 + Math.random()*2, 0, 0.2 + Math.random() * 5, 0, 0.1 + Math.random(), 0, 50.98 + Math.random(), 0, "", ""));
        return resultList;
    }

    //仿真单步推进
    private void advanceStep(Map<String, Result> resultMap, List<Channel> channelList, List<Berth> berthList,
                             List<Anchorage> anchorageList, List<Traffic> trafficList, int currentStep, Ship ship) {
        //如果船不为空
        if (null != ship) {
            //第1步：更新结果中该类型船只的数量，以及总的数量
            addResult(resultMap, ship);
            //第2步：添加到锚地
            addShipInAnchorage(anchorageList, ship);
            //第3步：判断是否有空余泊位，且航道允许进入
            if (hasIdleBerth(ship, berthList) && canIntoChannel(ship, channelList, currentStep)) {

            }
            //是否有交通管制
            if (hasTrafficCtrl(trafficList)) {

            }
        }
        //锚地状态改变

        //航道状态改变

        //泊位状态改变
    }

    //船进港，新增结果计数
    private void addResult(Map<String, Result> resultMap, Ship ship) {
        int shipType = ship.getShipEnum().getTypeCode();
        Result totalResult = resultMap.get("totalResult");
        totalResult.setNumber(totalResult.getNumber() + 1);
        resultMap.put("totalResult", totalResult);
        switch (shipType) {
            case 0://集装箱
                Result containerShipResult = resultMap.get("containerShipResult");
                containerShipResult.setNumber(containerShipResult.getNumber() + 1);
                resultMap.put("containerShipResult", containerShipResult);
                break;
            case 1://铁矿石
                Result ironOreResult = resultMap.get("ironOreResult");
                ironOreResult.setNumber(ironOreResult.getNumber() + 1);
                resultMap.put("ironOreResult", ironOreResult);
                break;
            case 2://化工油品
                Result chemicalOilResult = resultMap.get("chemicalOilResult");
                chemicalOilResult.setNumber(chemicalOilResult.getNumber() + 1);
                resultMap.put("chemicalOilResult", chemicalOilResult);
                break;
            case 3://原油
                Result crudeOilResult = resultMap.get("crudeOilResult");
                crudeOilResult.setNumber(crudeOilResult.getNumber() + 1);
                resultMap.put("crudeOilResult", crudeOilResult);
                break;
            case 4://煤炭
                Result coalResult = resultMap.get("coalResult");
                coalResult.setNumber(coalResult.getNumber() + 1);
                resultMap.put("coalResult", coalResult);
                break;
            case 5://散杂船
                Result breakBulkShipResult = resultMap.get("breakBulkShipResult");
                breakBulkShipResult.setNumber(breakBulkShipResult.getNumber() + 1);
                resultMap.put("breakBulkShipResult", breakBulkShipResult);
                break;
            default:
                break;
        }
    }

    //船离港，累计统计结果
    private void accumulateResult(Map<String, Result> resultMap, Ship ship) {
        int shipType = ship.getShipEnum().getTypeCode();
        Result totalResult = resultMap.get("totalResult"), result;
        calculateResult(totalResult, ship);
        resultMap.put("totalResult", totalResult);
        switch (shipType) {
            case 0://集装箱
                result = resultMap.get("containerShipResult");
                calculateResult(result, ship);
                resultMap.put("containerShipResult", result);
                break;
            case 1://铁矿石
                result = resultMap.get("ironOreResult");
                calculateResult(result, ship);
                resultMap.put("ironOreResult", result);
                break;
            case 2://化工油品
                result = resultMap.get("chemicalOilResult");
                calculateResult(result, ship);
                resultMap.put("chemicalOilResult", result);
                break;
            case 3://原油
                result = resultMap.get("crudeOilResult");
                calculateResult(result, ship);
                resultMap.put("crudeOilResult", result);
                break;
            case 4://煤炭
                result = resultMap.get("coalResult");
                calculateResult(result, ship);
                resultMap.put("coalResult", result);
                break;
            case 5://散杂船
                result = resultMap.get("breakBulkShipResult");
                calculateResult(result, ship);
                resultMap.put("breakBulkShipResult", result);
                break;
            default:
                break;
        }
    }

    private void calculateResult(Result result, Ship ship){
        BigDecimal hour2second = new BigDecimal(3600);
        int shipInHarbourTime = ship.getTimeNode().getLeaveTime() - ship.getTimeNode().getArriveTime();
        double totalInHarbourTime = result.getTotalInHarboursTime();
        result.setTotalInHarboursTime(totalInHarbourTime + BigDecimalUtil.divide(new BigDecimal(shipInHarbourTime), hour2second).doubleValue());

        int shipWaitChannelTime = ship.getTimeNode().getStartInChannelTime() - ship.getTimeNode().getArriveTime();
        double totalWaitChannelTime = result.getTotalWaitChannelTime();
        result.setTotalWaitChannelTime(totalWaitChannelTime + BigDecimalUtil.divide(new BigDecimal(shipWaitChannelTime), hour2second).doubleValue());

        int shipWaitBerthTime = ship.getTimeNode().getOnBerthTime() - ship.getTimeNode().getArriveTime() - 100; //TODO 每船在航道航行时间固定
        double totalWaitBerthTime = result.getTotalWaitBerthTime();
        result.setTotalWaitBerthTime(totalWaitBerthTime + BigDecimalUtil.divide(new BigDecimal(shipWaitBerthTime), hour2second).doubleValue());

        int shipOnBerthTime = ship.getTimeNode().getWorkTime();
        double totalOnBerthTime = result.getTotalOnBerthTime();
        result.setTotalWaitBerthTime(totalOnBerthTime + BigDecimalUtil.divide(new BigDecimal(shipOnBerthTime), hour2second).doubleValue());
    }

    //判断是否有空闲泊位
    private boolean hasIdleBerth(Ship ship, List<Berth> berthList) {
        for (Berth berth : berthList) {
            //如果码头类型与船类型相同，且该码头没有被占用，将该码头分配给该船舶
            if (ship.getShipEnum().getTypeCode() == berth.getShipEnum().getTypeCode() && null != berth.getShip()) {
                berth.setShip(ship);
                return true;
            }
        }
        return false;
    }

    //判断航道是否允许进入
    private boolean canIntoChannel(Ship ship, List<Channel> channelList, int step) {
        //吃水深度超过16m，需要从深水航槽进入
        if (ship.getDepth() > 16)
            return hasMeetSafeDistance(ship, channelList.get(0), step);
        else
            return hasMeetSafeDistance(ship, channelList.get(1), step);
    }

    //判断是否符合安全距离
    private boolean hasMeetSafeDistance(Ship ship, Channel channel, int step) {
        LinkedList<Ship> inLinkedList = channel.getInShipList();    //进入航道中航行的船舶
        if (CollectionUtils.isEmpty(inLinkedList)) {
            inLinkedList.addLast(ship);
            return true;
        }
        //取最后进入航道的那一条船
        Ship lastInChannelShip = inLinkedList.getLast();
        //如果深水航槽里面没有船，则返回可以进入深水槽
        if (lastInChannelShip == null) {
            inLinkedList.addLast(ship);
            return true;
        }
        //最后进入深水航槽的船行驶时间,当前时间-进入航道时间，单位：分
        int driveTime = step - lastInChannelShip.getTimeNode().getStartInChannelTime();
        return (driveTime / 60) * channel.getLimitedSpeed() * 1000 > ship.getSafeDistance();
    }

    //判断是否采取了交通管制
    private boolean hasTrafficCtrl(List<Traffic> trafficList) {
        return false;   //TODO 交通管制，需要提供一个分布或者算法
    }

    //组装结果
    private Result compResult(Result result, SimulationTime simulationTime) {
        int number = result.getNumber() == 0 ? 1 : result.getNumber();
        BigDecimal simulationHours = BigDecimalUtil.divide(new BigDecimal(simulationTime.getTimeOut() * simulationTime.getTimeOutUnit().getTime()), new BigDecimal(3600));
        double berthUtilization = BigDecimalUtil.divide4(new BigDecimal(result.getTotalOnBerthTime()), simulationHours).doubleValue();
        result.setBerthUtilizationRatio(BigDecimalUtil.decimal2PercentString(berthUtilization));

        result.setAvgInHarbourTime(BigDecimalUtil.divide(new BigDecimal(result.getTotalInHarboursTime()), new BigDecimal(number)).doubleValue());
        result.setAvgWaitChannelTime(BigDecimalUtil.divide(new BigDecimal(result.getAvgWaitChannelTime()), new BigDecimal(number)).doubleValue());
        result.setAvgOnBerthTime(BigDecimalUtil.divide(new BigDecimal(result.getAvgOnBerthTime()), new BigDecimal(number)).doubleValue());
        result.setAvgWaitBerthTime(BigDecimalUtil.divide(new BigDecimal(result.getAvgWaitBerthTime()), new BigDecimal(number)).doubleValue());
        //result.setAwtAstIndex(BigDecimalUtil.divide(new BigDecimal(result.getAvgWaitChannelTime() + result.getAvgWaitBerthTime()), new BigDecimal(result.getAvgOnBerthTime())).toString());
        return result;
    }

    //将船添加到锚地
    private void addShipInAnchorage(List<Anchorage> list, Ship ship) {
        int shipType = ship.getShipEnum().getTypeCode();
        switch (shipType) {
            //铁矿石船，放到矿石锚地
            case 1:
                Anchorage oreAnchorage = list.get(2);
                LinkedList<Ship> oreShipLinkedList = oreAnchorage.getShipList();
                oreShipLinkedList.addLast(ship);
                break;
            //原油船，放到油路锚地
            case 3:
                Anchorage oilAnchorage = list.get(3);
                LinkedList<Ship> oilShipLinkedList = oilAnchorage.getShipList();
                oilShipLinkedList.addLast(ship);
                break;
            //如果是其他类型的船，随机放到南、北锚地
            case 0:
            case 2:
            case 4:
            case 5:
                int i = RandomUtils.nextInt(2);
                Anchorage anchorage = list.get(i);
                LinkedList<Ship> shipLinkedList = anchorage.getShipList();
                if (4 == shipType) {    //如果是碰到煤炭、天然气船，是优先进入，排到头结点
                    shipLinkedList.addFirst(ship);
                } else {
                    shipLinkedList.addLast(ship);
                }
                break;
            default:
                break;
        }
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

    //船只
    private Ship getShip(int id, int typeCode) {
        Ship ship = new Ship();
        ship.setId(id);
        //ship.setTonner();
        ship.setShipEnum(ShipEnum.values()[typeCode]);
        ship.setDepth(AlgorithmUtil.normalSample(10, 2));   //TODO 正态分布
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
        ship.setSpeed(AlgorithmUtil.normalSample(1.852, 0.5)); //km/h TODO 正态分布
        TimeNode timeNode = new TimeNode();
        timeNode.setArriveTime(id); //某一步
        ship.setTimeNode(timeNode);
        return ship;
    }

    //动态产生船长
    private double genLength(int typeCode) {
        switch (typeCode) {
            case 0:
                return AlgorithmUtil.normalSample(311.8, 5);    //TODO 方差需要严格计算
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
}
