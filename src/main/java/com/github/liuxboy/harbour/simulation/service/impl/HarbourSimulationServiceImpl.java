package com.github.liuxboy.harbour.simulation.service.impl;

import com.github.liuxboy.harbour.simulation.common.constant.BigDecimalUtil;
import com.github.liuxboy.harbour.simulation.common.constant.PriorityEnum;
import com.github.liuxboy.harbour.simulation.common.constant.ShipEnum;
import com.github.liuxboy.harbour.simulation.common.constant.TimeEnum;
import com.github.liuxboy.harbour.simulation.common.util.AlgorithmUtil;
import com.github.liuxboy.harbour.simulation.common.util.Logger;
import com.github.liuxboy.harbour.simulation.common.util.LoggerFactory;
import com.github.liuxboy.harbour.simulation.domain.biz.*;
import com.github.liuxboy.harbour.simulation.service.HarbourSimulationService;
import com.sun.jndi.ldap.Ber;
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
                                   List<Ship> shipTypeList, List<Traffic> trafficList, List<SimulationTime> timeList) throws ServiceException {
        List<Result> resultList = new ArrayList<Result>();
        Map<Integer, Ship> inShipMap = new HashMap<Integer, Ship>(); //进泊船舶，就是正式进入航道与到达泊位之间，所有的船舶
        Map<Integer, Ship> outShipMap = new HashMap<Integer, Ship>();//出泊船舶，就是正式驶离泊位与驶出航道之间，所有的船舶
        SimulationTime simulationTime = new SimulationTime();
        if (!CollectionUtils.isEmpty(timeList))
            simulationTime = timeList.get(0);
        int simulationSteps = (simulationTime.getTimeOut() * simulationTime.getTimeOutUnit().getTime())
                / (simulationTime.getTimeStep() * simulationTime.getTimeStepUnit().getTime());
        int simulationDays = simulationTime.getTimeOut() * simulationTime.getTimeOutUnit().getTime()
                / TimeEnum.DAY.getTime();
        //存放当前仿真过程中的船只
        Map<String, Result> resultMap = new HashMap<String, Result>();
        //存放结果
        Result totalResult = new Result(),          //总的结果
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
            HashMap<Integer, Ship> simulationShipMap = genShips(simulationDays);
            for (int step = 1; step < simulationSteps + 1; step++) {
                Ship ship = simulationShipMap.get(step);
                // NO.1进港过程
                // 运行到有新产生的船
                if (null != ship) {
                    //如果有空闲锚位
                    if (hasIdleAnchorage(anchorageList, ship.getShipEnum().getTypeCode())) {
                        addShipInAnchorage(anchorageList, ship);
                        addResult(resultMap, ship.getShipEnum().getTypeCode());
                    }
                    //如果没有空闲锚位,将该船移动下一步中
                    else {
                        simulationShipMap.remove(ship.getId());
                        simulationShipMap.put(step + 1, ship);
                    }
                }

                //锚地前进一步
                advanceAnchorage(resultMap, anchorageList, trafficList, simulationShipMap);
                //泊位前进一步
                advanceBerth(resultMap, berthList, trafficList, simulationShipMap);
                //航道前进一步
                advanceChannel(resultMap, channelList, trafficList, simulationShipMap);
                //累计结果
                accumulateResult(resultMap, ship);
            }
        } catch (Exception e) {
            logger.error(e);
        }
        //仿真结束---------------------------------------------------------
        //总的
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
        resultList.add(compResult(resultMap.get("breakBulkShipResult"), simulationTime));


        return resultList;
    }

    //锚地单步推进
    private void advanceAnchorage(Map<String, Result> resultMap, List<Anchorage> anchorageList, List<Traffic> trafficList,
                                  HashMap<Integer, Ship> simulationShipMap) {
        //判断是否有空余泊位，且航道允许进入
        /*if (hasIdleBerth(ship, berthList) && canIntoChannel(ship, channelList, step)) {

        }
        //是否有交通管制
        if (hasTrafficCtrl(trafficList), s){

        }*/
    }

    //泊位单步推进
    private void advanceBerth(Map<String, Result> resultMap, List<Berth> berthList, List<Traffic> trafficList,
                              HashMap<Integer, Ship> simulationShipMap) {

    }

    //航道单步推进
    private void advanceChannel(Map<String, Result> resultMap, List<Channel> channelList, List<Traffic> trafficList,
                                HashMap<Integer, Ship> simulationShipMap) {

    }

    //船进港，新增结果计数
    private void addResult(Map<String, Result> resultMap, int shipType) {
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

    private void calculateResult(Result result, Ship ship) {
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

    //判断是否有空闲锚位
    private boolean hasIdleAnchorage(List<Anchorage> anchorageList, int shipType) {
        switch (shipType) {
            //铁矿石锚地锚位是否已满
            case 1:
                Anchorage oreAnchorage = anchorageList.get(2);
                return oreAnchorage.getShipList().size() < oreAnchorage.getSize();
            //原油锚地锚位时候已满
            case 3:
                Anchorage oilAnchorage = anchorageList.get(3);
                return oilAnchorage.getShipList().size() < oilAnchorage.getSize();
            //如果是其他类型的船，看是南北锚是否都满了
            case 0:
            case 2:
            case 4:
            case 5:
                Anchorage northAnchorage = anchorageList.get(0);
                Anchorage southAnchorage = anchorageList.get(1);
                return northAnchorage.getShipList().size() < northAnchorage.getSize()
                        || southAnchorage.getShipList().size() >= southAnchorage.getSize();
            default:
                return false;
        }
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
    private boolean hasTrafficCtrl(List<Traffic> trafficList, int step) {
        int startStep = 0;
        double duration = 0;
        for (Traffic traffic : trafficList) {
            startStep = (traffic.getStartMon() - 1) * getMonthDays(traffic.getStartMon()) + traffic.getStartDay() * 24 * 60
                    + traffic.getStartHor() * 60 + traffic.getStartMin();
            duration = traffic.getTrafficDuration() * traffic.getTimeEnum().getTime() * 60;
            if (startStep < step && step < startStep + duration) {
                return true;
            }
        }
        return false;
    }

    //获取月天数
    private int getMonthDays(int month) {
        switch (month) {
            case 2:
                return 29;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
        }
        return 30;
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
    private void addShipInAnchorage(List<Anchorage> anchorageList, Ship ship) {
        int shipType = ship.getShipEnum().getTypeCode();
        switch (shipType) {
            //铁矿石船，放到矿石锚地
            case 1:
                Anchorage oreAnchorage = anchorageList.get(2);
                LinkedList<Ship> oreShipLinkedList = oreAnchorage.getShipList();
                oreShipLinkedList.addLast(ship);
                break;
            //原油船，放到油轮锚地
            case 3:
                Anchorage oilAnchorage = anchorageList.get(3);
                LinkedList<Ship> oilShipLinkedList = oilAnchorage.getShipList();
                oilShipLinkedList.addLast(ship);
                break;
            //如果是其他类型的船，先放北锚地，再放南锚地
            case 0:
            case 2:
            case 4:
            case 5:
                Anchorage northAnchorage = anchorageList.get(0);
                LinkedList<Ship> northShipLinkedList = northAnchorage.getShipList();
                Anchorage southAnchorage = anchorageList.get(1);
                LinkedList<Ship> southShipLinkedList = southAnchorage.getShipList();
                if (northShipLinkedList.size() < northAnchorage.getSize()) {
                    if (4 == shipType) {//如果是碰到煤炭、天然气船，是优先进入，排到头结点
                        northShipLinkedList.addFirst(ship);
                    } else {
                        northShipLinkedList.addLast(ship);
                    }
                } else if (southShipLinkedList.size() < southAnchorage.getSize()) {
                    if (4 == shipType) {//如果是碰到煤炭、天然气船，是优先进入，排到头结点
                        southShipLinkedList.addFirst(ship);
                    } else {
                        southShipLinkedList.addLast(ship);
                    }
                }
                break;
            default:
                break;
        }
    }

    //船泊总数量
    private HashMap<Integer, Ship> genShips(int simulationDays) {
        int[] simulationShipArray = AlgorithmUtil.poissonSamples(36.0193 / (24.0 * 60.0), 24 * 60 * simulationDays);
        HashMap<Integer, Ship> shipHashMap = new HashMap<Integer, Ship>(simulationShipArray.length);
        for (int i = 0; i < simulationShipArray.length; i++) {
            //产生一条船
            if (simulationShipArray[i] == 1) {
                shipHashMap.put(i, getShip(i));
            }
            //产生两条船，
            else if (simulationShipArray[i] == 2) {
                shipHashMap.put(i, getShip(i));
                shipHashMap.put(i + 1, getShip(i + 1));
            }
        }
        return shipHashMap;
    }

    //获取单个船只属性
    private Ship getShip(int id) {
        int typeCode = getShipType();                   //先根据概论产生船的类型
        Ship ship = new Ship();
        ship.setId(id);
        ship.setShipEnum(ShipEnum.values()[typeCode]);
        double length = genLength(typeCode);
        ship.setLength(length);
        double tonner = getTonner(length, typeCode);    //根据船长算载重吨位
        ship.setTonner(tonner);
        ship.setSafeDistance(6 * length);
        ship.setDepth(getDepth(tonner));                //根据载重吨位算吃水深度
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

    //根据概论产生船的类型
    private int getShipType() {
        double random = 0.0001 + RandomUtils.nextDouble();
        if (random <= ShipEnum.Container_Ship.getSection()) {
            return 0;
        } else if (random <= ShipEnum.Iron_Ore.getSection()) {
            return 1;
        } else if (random <= ShipEnum.Chemical_Oil.getSection()) {
            return 2;
        } else if (random <= ShipEnum.Crude_Oil.getSection()) {
            return 3;
        } else if (random <= ShipEnum.Coal.getSection()) {
            return 4;
        } else if (random <= ShipEnum.Break_Bulk_Ship.getSection()) {
            return 5;
        }
        return 0;
    }

    //动态产生船长
    private double genLength(int typeCode) {
        switch (typeCode) {
            case 0:
                return AlgorithmUtil.normalSample(259.4, 100.0);    //TODO 方差需要严格计算
            case 1:
                return AlgorithmUtil.normalSample(279.4, 70.0);
            case 2:
                return AlgorithmUtil.normalSample(176.2, 30.0);
            case 3:
                return AlgorithmUtil.normalSample(311.8, 60.0);
            case 4:
                return AlgorithmUtil.normalSample(216.3, 50.0);
            case 5:
                return AlgorithmUtil.normalSample(208.1, 40.0);
            default:
                return 0;
        }
    }

    //动态产生船吨位
    private double getTonner(double length, int typeCode) {
        switch (typeCode) {
            case 0:
                return AlgorithmUtil.power(length / 3.6221, 1.0 / 0.3898);
            case 1:
                return AlgorithmUtil.power(length / 5.5706, 1.0 / 0.327);
            case 2:
                return AlgorithmUtil.power(length / 4.8624, 1.0 / 0.3441);
            case 3:
                return AlgorithmUtil.power(length / 8.7269, 1.0 / 0.2879);
            case 4:
                return AlgorithmUtil.power(length / 8.1572, 1.0 / 0.2960);
            case 5:
                return AlgorithmUtil.power(length / 8.3339, 1.0 / 0.2928);
            default:
                return 0.0;
        }
    }

    //动态产生船吃水深度
    private double getDepth(double tonner) {
        //非货运船，小于万吨
        if (tonner < 10000) {
            return AlgorithmUtil.normalSample(9.0, 2);
        } else if (tonner < 50000) {
            return AlgorithmUtil.normalSample(11.0, 1);
        } else if (tonner < 100000) {
            return AlgorithmUtil.normalSample(14.0, 2);
        } else if (tonner < 150000) {
            return AlgorithmUtil.normalSample(17, 1);
        } else {
            return AlgorithmUtil.normalSample(20, 2);
        }
    }
}
