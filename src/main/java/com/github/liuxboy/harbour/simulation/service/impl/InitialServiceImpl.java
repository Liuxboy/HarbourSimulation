package com.github.liuxboy.harbour.simulation.service.impl;

import com.github.liuxboy.harbour.simulation.common.constant.*;
import com.github.liuxboy.harbour.simulation.domain.biz.*;
import com.github.liuxboy.harbour.simulation.service.InitialService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: InitialService</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/26 11:57</p>
 * <p>Description: 港口初始参数 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
@Service
public class InitialServiceImpl implements InitialService {

    public List<Anchorage> getAnchorageList() {
        List<Anchorage> anchorageList = new ArrayList<Anchorage>(4);
        Anchorage anchorage;
        {
            anchorage = new Anchorage();
            anchorage.setId(0);
            anchorage.setAnchorageEnum(AnchorageEnum.North);
            anchorage.setPoint1X(122.3417);     //122°20′30″E
            anchorage.setPoint1Y(29.7750);      //29°46′30″N
            anchorage.setPoint2X(122.3833);     //122°23′00″E
            anchorage.setPoint2Y(29.7750);      //29°46′30″N
            anchorage.setPoint3X(122.3833);     //122°23′00″E
            anchorage.setPoint3Y(29.7417);      //29°44′30″N
            anchorage.setPoint4X(122.3417);     //122°20′30″E
            anchorage.setPoint4Y(29.7417);      //29°44′30″N
            anchorageList.add(anchorage);
        }
        {
            anchorage = new Anchorage();
            anchorage.setId(1);
            anchorage.setAnchorageEnum(AnchorageEnum.South);
            anchorage.setPoint1X(122.3333);     //122°20′00″E
            anchorage.setPoint1Y(29.7250);      //29°43′30″N
            anchorage.setPoint2X(122.3833);     //122°23′00″E
            anchorage.setPoint2Y(29.7033);      //29°42′12″N
            anchorage.setPoint3X(122.3833);     //122°23′00″E
            anchorage.setPoint3Y(29.6933);      //29°41′36″N
            anchorage.setPoint4X(122.3333);     //122°20′00″E
            anchorage.setPoint4Y(29.6933);      //29°41′36″N
            anchorageList.add(anchorage);
        }
        {
            anchorage = new Anchorage();
            anchorage.setId(2);
            anchorage.setAnchorageEnum(AnchorageEnum.Ore);
            anchorage.setPoint1X(122.5600);     //122°33′36″E
            anchorage.setPoint1Y(29.7550);      //29°45′18″N
            anchorage.setPoint2X(122.5808);     //122°34′51″E
            anchorage.setPoint2Y(29.7500);      //29°45′18″N
            anchorage.setPoint3X(122.5808);     //122°34′51″E
            anchorage.setPoint3Y(29.7533);      //29°45′12″N
            anchorage.setPoint4X(122.5600);     //122°33′36″E
            anchorage.setPoint4Y(29.7533);      //29°45′12″N
            anchorageList.add(anchorage);
        }
        {
            anchorage = new Anchorage();
            anchorage.setId(3);
            anchorage.setAnchorageEnum(AnchorageEnum.Oil);
            anchorage.setPoint1X(122.5600);     //122°33′36″E
            anchorage.setPoint1Y(29.7317);      //29°43′54″N
            anchorage.setPoint2X(122.5808);     //122°34′51″E
            anchorage.setPoint2Y(29.7317);      //29°43′54″N
            anchorage.setPoint3X(122.5808);     //122°34′51″E
            anchorage.setPoint3Y(29.6958);      //29°41′45″N
            anchorage.setPoint4X(122.5600);     //122°33′36″E
            anchorage.setPoint4Y(29.6958);      //29°41′45″N
            anchorageList.add(anchorage);
        }
        return anchorageList;
    }

    public List<Channel> getChannelList() {
        List<Channel> channelList = new ArrayList<Channel>();
        Channel channel;
        {
            channel = new Channel();
            channel.setId(0);
            channel.setName("深水航道");
            channel.setDepth(25.7);     //m
            channel.setLength(14.85);   //km
            channel.setWidth(0.39);     //km
            channel.setPassEnum(PassDirectEnum.OneWay);
            channel.setLimitedSpeed(19.65); //km/h
            channelList.add(channel);
        }
        {
            channel = new Channel();
            channel.setId(1);
            channel.setName("虾峙门水道");
            channel.setDepth(22.5); //m
            channel.setLength(53);  //km
            channel.setWidth(0.70); //km
            channel.setPassEnum(PassDirectEnum.BothWay);
            channel.setLimitedSpeed(22.11); //km/h
            channelList.add(channel);
        }
        return channelList;
    }

    public List<Berth> getBerthList() {
        List<Berth> berthList = new ArrayList<Berth>();
        Berth berth;
        {
            berth = new Berth();
            berth.setId(0);
            berth.setLength(200);   //m
            berth.setDepth(-9.5);   //m
            berth.setName("镇海2#泊位");
            berth.setShipEnum(ShipEnum.Break_Bulk_Ship);
            berth.setTonner(20000); //吨
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(1);
            berth.setLength(180);   //m
            berth.setDepth(-9.5);   //m
            berth.setName("镇海3#泊位");
            berth.setShipEnum(ShipEnum.Break_Bulk_Ship);
            berth.setTonner(20000); //吨
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(2);
            berth.setLength(160);   //m
            berth.setDepth(-9.5);   //m
            berth.setName("镇海4#泊位");
            berth.setShipEnum(ShipEnum.Break_Bulk_Ship);
            berth.setTonner(20000); //吨
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(3);
            berth.setLength(180);   //m
            berth.setDepth(-9.5);   //m
            berth.setName("镇海5#泊位");
            berth.setShipEnum(ShipEnum.Break_Bulk_Ship);
            berth.setTonner(10000); //吨
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(4);
            berth.setLength(180);   //m
            berth.setDepth(-9.5);   //m
            berth.setName("镇海6#泊位");
            berth.setShipEnum(ShipEnum.Break_Bulk_Ship);
            berth.setTonner(10000); //吨
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(5);
            berth.setLength(280);   //m
            berth.setDepth(-7);     //m
            berth.setName("镇海7#泊位");
            berth.setShipEnum(ShipEnum.Container_Ship);
            berth.setTonner(10000); //吨
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(6);
            berth.setLength(280);   //m
            berth.setDepth(-7);     //m
            berth.setName("镇海8#泊位");
            berth.setShipEnum(ShipEnum.Container_Ship);
            berth.setTonner(10000); //吨
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(7);
            berth.setLength(180);   //m
            berth.setDepth(-9.5);   //m
            berth.setName("镇海9#泊位");
            berth.setShipEnum(ShipEnum.Container_Ship);
            berth.setTonner(20000); //吨
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(8);
            berth.setLength(280);   //m
            berth.setDepth(-9.5);   //m
            berth.setName("镇海10#泊位");
            berth.setShipEnum(ShipEnum.Container_Ship);
            berth.setTonner(10000); //吨
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(9);
            berth.setLength(280);   //m
            berth.setDepth(-9.5);   //m
            berth.setName("镇海21#泊位");
            berth.setShipEnum(ShipEnum.Break_Bulk_Ship);
            berth.setTonner(50000); //吨
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(10);
            berth.setLength(230);   //m
            berth.setDepth(-13.5);   //m
            berth.setName("镇海22#泊位");
            berth.setShipEnum(ShipEnum.Break_Bulk_Ship);
            berth.setTonner(50000); //吨
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(11);
            berth.setLength(144);   //m
            berth.setDepth(-9);     //m
            berth.setName("镇海16#泊位");
            berth.setShipEnum(ShipEnum.Chemical_Oil);
            berth.setTonner(10000); //吨
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(12);
            berth.setLength(349);   //m
            berth.setDepth(-14.5);  //m
            berth.setName("镇海17#泊位");
            berth.setShipEnum(ShipEnum.Chemical_Oil);
            berth.setTonner(50000); //吨
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(13);
            berth.setLength(340);   //m
            berth.setDepth(-14.5);  //m
            berth.setName("镇海18#泊位");
            berth.setShipEnum(ShipEnum.Chemical_Oil);
            berth.setTonner(50000); //吨
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(14);
            berth.setLength(345);   //m
            berth.setDepth(-14.5);  //m
            berth.setName("镇海19#泊位");
            berth.setShipEnum(ShipEnum.Chemical_Oil);
            berth.setTonner(50000); //吨
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(15);
            berth.setLength(345);   //m
            berth.setDepth(-14.5);  //m
            berth.setName("镇海19#泊位");
            berth.setShipEnum(ShipEnum.Chemical_Oil);
            berth.setTonner(50000); //吨
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(16);
            berth.setLength(200);   //m
            berth.setDepth(-12.5);  //m
            berth.setName("镇海20#泊位");
            berth.setShipEnum(ShipEnum.Chemical_Oil);
            berth.setTonner(20000); //吨
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(17);
            berth.setLength(340);   //m
            berth.setDepth(-12.5);  //m
            berth.setName("青峙1#泊位");
            berth.setShipEnum(ShipEnum.Chemical_Oil);
            berth.setTonner(40000); //吨
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(18);
            berth.setLength(325);   //m
            berth.setDepth(-13.5);  //m
            berth.setName("青峙2#泊位");
            berth.setShipEnum(ShipEnum.Chemical_Oil);
            berth.setTonner(50000); //吨
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(19);
            berth.setLength(260);   //m
            berth.setDepth(-13.5);  //m
            berth.setName("杨公山石化码头");
            berth.setShipEnum(ShipEnum.Chemical_Oil);
            berth.setTonner(50000); //吨
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(20);
            berth.setLength(510);   //m
            berth.setDepth(-23.8);   //m
            berth.setName("原油1#泊位");
            berth.setShipEnum(ShipEnum.Crude_Oil);
            berth.setTonner(300000); //吨
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(21);
            berth.setLength(608);   //m
            berth.setDepth(-23.8);   //m
            berth.setName("原油2#泊位");
            berth.setShipEnum(ShipEnum.Crude_Oil);
            berth.setTonner(300000); //吨
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(22);
            berth.setLength(229);   //m
            berth.setDepth(-9.5);    //m
            berth.setName("原油6#泊位");
            berth.setShipEnum(ShipEnum.Crude_Oil);
            berth.setTonner(10000); //吨
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(23);
            berth.setLength(274);     //m
            berth.setDepth(-13.5);    //m
            berth.setName("北仑电厂1#泊位");
            berth.setShipEnum(ShipEnum.Coal);
            berth.setTonner(50000); //吨
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(24);
            berth.setLength(256);     //m
            berth.setDepth(-13.5);    //m
            berth.setName("北仑电厂2#泊位");
            berth.setShipEnum(ShipEnum.Coal);
            berth.setTonner(50000); //吨
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(25);
            berth.setLength(260);     //m
            berth.setDepth(-13.5);    //m
            berth.setName("北仑电厂3#泊位");
            berth.setShipEnum(ShipEnum.Coal);
            berth.setTonner(100000); //吨
            berthList.add(berth);
        }
        return berthList;
    }

    @Override
    public List<Traffic> getTrafficList() {
        List<Traffic> trafficList = new ArrayList<Traffic>();
        Traffic traffic = new Traffic();
        {
            traffic.setId(0);
            traffic.setStatus(0);
            traffic.setTrafficEnum(TrafficEnum.CS_PROHIBIT_ANCHOR);
            traffic.setTrafficDuration(1);
            traffic.setTrafficTimes(1);
            traffic.setTimeEnum(TimeEnum.DAY);
            trafficList.add(traffic);
        }
        {
            traffic = new Traffic();
            traffic.setId(1);
            traffic.setStatus(0);
            traffic.setTrafficEnum(TrafficEnum.BBS_PROHIBIT_ANCHOR);
            traffic.setTrafficDuration(1);
            traffic.setTrafficTimes(1);
            traffic.setTimeEnum(TimeEnum.DAY);
            trafficList.add(traffic);
        }
        {
            traffic = new Traffic();
            traffic.setId(2);
            traffic.setStatus(0);
            traffic.setTrafficEnum(TrafficEnum.DANGER_PROHIBIT_ANCHOR);
            traffic.setTrafficDuration(1);
            traffic.setTrafficTimes(1);
            traffic.setTimeEnum(TimeEnum.DAY);
            trafficList.add(traffic);
        }
        {
            traffic = new Traffic();
            traffic.setId(3);
            traffic.setStatus(0);
            traffic.setTrafficEnum(TrafficEnum.PROHIBIT_BOTH_TRAVEL);
            traffic.setTrafficDuration(1);
            traffic.setTrafficTimes(1);
            traffic.setTimeEnum(TimeEnum.DAY);
            trafficList.add(traffic);
        }
        {
            traffic = new Traffic();
            traffic.setId(4);
            traffic.setStatus(0);
            traffic.setTrafficEnum(TrafficEnum.PROHIBIT_CONTRARY_TRAVEL);
            traffic.setTrafficDuration(1);
            traffic.setTrafficTimes(1);
            traffic.setTimeEnum(TimeEnum.DAY);
            trafficList.add(traffic);
        }
        return trafficList;
    }

    @Override
    public List<SimulationTime> getTimeList() {
        List<SimulationTime> timeList = new ArrayList<SimulationTime>();
        SimulationTime simulationTime = new SimulationTime();
        simulationTime.setId(0);
        simulationTime.setTimeOut(1);
        simulationTime.setTimeOutUnit(TimeEnum.YER);
        simulationTime.setTimeStep(1);
        simulationTime.setTimeStepUnit(TimeEnum.MIN);
        timeList.add(simulationTime);
        return timeList;
    }

    @Override
    public List<Ship> getShipList() {
        List<Ship> shipList = new ArrayList<Ship>();
        Ship ship;
        {
            ship = new Ship();
            ship.setId(0);
            ship.setShipEnum(ShipEnum.Crude_Oil);  //原油
            ship.setDepth(10);
            ship.setLength(311.8);
            ship.setNumbers(618);
            //默认仿真是长是1年，仿真步骤是1秒
            ship.setLambda(1.69);
            ship.setMu(4.18);
            ship.setSigma(0.58);
            ship.setPriorityEnum(PriorityEnum.LOW);
            ship.setTonner(26.6);
            ship.setSpeed(1.852);       //km/h
            ship.setSafeDistance(BigDecimalUtil.decimal2Double(311.8 * 6)); //m
            shipList.add(ship);
        }
        {
            ship = new Ship();
            ship.setId(1);
            ship.setShipEnum(ShipEnum.Iron_Ore);  //铁矿石
            ship.setDepth(10);
            ship.setLength(279.4);
            ship.setNumbers(1002);
            //默认仿真是长是1年，仿真步骤是1秒
            ship.setLambda(2.76);
            ship.setMu(3.55);
            ship.setSigma(0.82);
            ship.setPriorityEnum(PriorityEnum.NORMAL);
            ship.setTonner(1.67);
            ship.setSpeed(1.852);       //km/h
            ship.setSafeDistance(BigDecimalUtil.decimal2Double(279.4 * 6)); //m
            shipList.add(ship);
        }
        {
            ship = new Ship();
            ship.setId(2);
            ship.setShipEnum(ShipEnum.Coal);  //煤炭
            ship.setDepth(10);
            ship.setLength(216.3);
            ship.setNumbers(380);
            //默认仿真是长是1年，仿真步骤是1秒
            ship.setLambda(1.05);
            ship.setMu(3.89);
            ship.setSigma(0.67);
            ship.setPriorityEnum(PriorityEnum.NORMAL);
            ship.setTonner(6.78);
            ship.setSpeed(1.852);       //km/h
            ship.setSafeDistance(BigDecimalUtil.decimal2Double(216.3 * 5)); //m
            shipList.add(ship);
        }
        {
            ship = new Ship();
            ship.setId(3);
            ship.setShipEnum(ShipEnum.Container_Ship);  //集装箱
            ship.setDepth(10);
            ship.setLength(259.4);
            ship.setNumbers(9840);
            //默认仿真是长是1年，仿真步骤是1秒
            ship.setLambda(27.09);
            ship.setMu(2.45);
            ship.setSigma(0.49);
            ship.setPriorityEnum(PriorityEnum.LOW);
            ship.setTonner(6.62);
            ship.setSpeed(1.852);       //km/h
            ship.setSafeDistance(BigDecimalUtil.decimal2Double(259.4 * 6)); //m
            shipList.add(ship);
        }
        {
            ship = new Ship();
            ship.setId(0);
            ship.setShipEnum(ShipEnum.Chemical_Oil);  //化工油品
            ship.setDepth(10);
            ship.setLength(176.2);
            ship.setNumbers(974);
            //默认仿真是长是1年，仿真步骤是1秒
            ship.setLambda(2.68);
            ship.setMu(3.48);
            ship.setSigma(0.57);
            ship.setPriorityEnum(PriorityEnum.LOW);
            ship.setTonner(3.74);
            ship.setSpeed(1.852);       //km/h
            ship.setSafeDistance(BigDecimalUtil.decimal2Double(176.2 * 6)); //m
            shipList.add(ship);
        }
        {
            ship = new Ship();
            ship.setId(5);
            ship.setShipEnum(ShipEnum.Break_Bulk_Ship);  //散杂货
            ship.setDepth(10);
            ship.setLength(208.1);
            ship.setNumbers(266);
            //默认仿真是长是1年，仿真步骤是1秒
            ship.setLambda(0.73);
            ship.setMu(3.65);
            ship.setSigma(0.76);
            ship.setPriorityEnum(PriorityEnum.LOW);
            ship.setTonner(6.71);
            ship.setSpeed(1.852);       //km/h
            ship.setSafeDistance(BigDecimalUtil.decimal2Double(208.1 * 6)); //m
            shipList.add(ship);
        }
        return shipList;
    }

    @Override
    public List<PassRule> passRuleList() {
        List<PassRule> passList = new ArrayList<PassRule>();
        PassRule passRule;
        {
            passRule = new PassRule();
            passRule.setId(0);
            passRule.setPassRuleEnum(PassRuleEnum.First_Main_Second_Branch);
            passList.add(passRule);
        }
        {
            passRule = new PassRule();
            passRule.setId(1);
            passRule.setPassRuleEnum(PassRuleEnum.Normal);
            passList.add(passRule);
        }
        {
            passRule = new PassRule();
            passRule.setId(2);
            passRule.setPassRuleEnum(PassRuleEnum.VLCC);
            passList.add(passRule);
        }
        {
            passRule = new PassRule();
            passRule.setId(3);
            passRule.setPassRuleEnum(PassRuleEnum.Coal_Gas);
            passList.add(passRule);
        }
        return passList;
    }
}