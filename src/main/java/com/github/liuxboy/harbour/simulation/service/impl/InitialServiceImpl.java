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
            anchorage.setSize(19);              //锚位数
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
            anchorage.setSize(15);              //锚位数
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
            anchorage.setSize(5);              //锚位数
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
            anchorage.setSize(14);              //锚位数
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
            channel.setName("深水航槽");
            channel.setDepth(25.7);     //m
            channel.setLength(14.85);   //km
            channel.setWidth(0.39);     //km
            channel.setPassEnum(PassDirectEnum.BothWay);
            channel.setLimitedSpeed(19.65); //km/h
            channel.setDynamicPassRatio(4.8);   //艘/h
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
            channel.setDynamicPassRatio(9.5);   //艘/h
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
            berth.setToAnchorageTime(4.47);
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
            berth.setToAnchorageTime(4.45);
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
            berth.setToAnchorageTime(4.43);
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
            berth.setToAnchorageTime(4.42);
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
            berth.setToAnchorageTime(4.40);
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
            berth.setToAnchorageTime(4.38);
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
            berth.setToAnchorageTime(4.37);
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
            berth.setToAnchorageTime(4.35);
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
            berth.setToAnchorageTime(4.33);
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
            berth.setToAnchorageTime(4.32);
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
            berth.setToAnchorageTime(4.30);
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
            berth.setToAnchorageTime(4.28);
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
            berth.setToAnchorageTime(4.27);
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
            berth.setToAnchorageTime(4.25);
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
            berth.setToAnchorageTime(4.23);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(15);
            berth.setLength(200);   //m
            berth.setDepth(-12.5);  //m
            berth.setName("镇海20#泊位");
            berth.setShipEnum(ShipEnum.Chemical_Oil);
            berth.setTonner(20000); //吨
            berth.setToAnchorageTime(4.22);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(16);
            berth.setLength(340);   //m
            berth.setDepth(-12.5);  //m
            berth.setName("青峙1#泊位");
            berth.setShipEnum(ShipEnum.Chemical_Oil);
            berth.setTonner(40000); //吨
            berth.setToAnchorageTime(3.83);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(17);
            berth.setLength(325);   //m
            berth.setDepth(-13.5);  //m
            berth.setName("青峙2#泊位");
            berth.setShipEnum(ShipEnum.Chemical_Oil);
            berth.setTonner(50000); //吨
            berth.setToAnchorageTime(3.83);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(18);
            berth.setLength(260);   //m
            berth.setDepth(-13.5);  //m
            berth.setName("杨公山石化码头");
            berth.setShipEnum(ShipEnum.Chemical_Oil);
            berth.setTonner(50000); //吨
            berth.setToAnchorageTime(3.67);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(19);
            berth.setLength(229);   //m
            berth.setDepth(-9.5);   //m
            berth.setName("算山7#泊位");
            berth.setShipEnum(ShipEnum.Crude_Oil);
            berth.setTonner(10000); //吨
            berth.setToAnchorageTime(3.58);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(20);
            berth.setLength(400);   //m
            berth.setDepth(-14);    //m
            berth.setName("算山6#泊位");
            berth.setShipEnum(ShipEnum.Crude_Oil);
            berth.setTonner(300000); //吨
            berth.setToAnchorageTime(3.58);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(21);
            berth.setLength(510);     //m
            berth.setDepth(-23.8);    //m
            berth.setName("算山2#泊位");
            berth.setShipEnum(ShipEnum.Crude_Oil);
            berth.setTonner(300000); //吨
            berth.setToAnchorageTime(4.00);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(22);
            berth.setLength(608);     //m
            berth.setDepth(-23.8);    //m
            berth.setName("算山1#泊位");
            berth.setShipEnum(ShipEnum.Crude_Oil);
            berth.setTonner(300000); //吨
            berth.setToAnchorageTime(4.00);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(23);
            berth.setLength(274);     //m
            berth.setDepth(-13.5);    //m
            berth.setName("北电3#泊位");
            berth.setShipEnum(ShipEnum.Coal);
            berth.setTonner(50000); //吨
            berth.setToAnchorageTime(3.50);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(24);
            berth.setLength(256);     //m
            berth.setDepth(-13.5);    //m
            berth.setName("北电2#泊位");
            berth.setShipEnum(ShipEnum.Coal);
            berth.setTonner(50000); //吨
            berth.setToAnchorageTime(3.50);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(25);
            berth.setLength(260);     //m
            berth.setDepth(-15);    //m
            berth.setName("北电1#泊位");
            berth.setShipEnum(ShipEnum.Coal);
            berth.setTonner(100000); //吨
            berth.setToAnchorageTime(3.50);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(26);
            berth.setLength(300);     //m
            berth.setDepth(-15);    //m
            berth.setName("北二集司1#泊位");
            berth.setShipEnum(ShipEnum.Container_Ship);
            berth.setTonner(100000); //吨
            berth.setToAnchorageTime(3.08);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(27);
            berth.setLength(275);     //m
            berth.setDepth(-15);      //m
            berth.setName("北二集司2#泊位");
            berth.setShipEnum(ShipEnum.Container_Ship);
            berth.setTonner(100000); //吨
            berth.setToAnchorageTime(3.08);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(28);
            berth.setLength(345);     //m
            berth.setDepth(-15);      //m
            berth.setName("北二集司3#泊位");
            berth.setShipEnum(ShipEnum.Container_Ship);
            berth.setTonner(100000); //吨
            berth.setToAnchorageTime(3.08);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(29);
            berth.setLength(250);     //m
            berth.setDepth(-13.5);      //m
            berth.setName("金光#泊位");
            berth.setShipEnum(ShipEnum.Break_Bulk_Ship);
            berth.setTonner(50000); //吨
            berth.setToAnchorageTime(3.00);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(30);
            berth.setLength(250);     //m
            berth.setDepth(-13.5);      //m
            berth.setName("正大码头#泊位");
            berth.setShipEnum(ShipEnum.Container_Ship);
            berth.setTonner(50000); //吨
            berth.setToAnchorageTime(2.96);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(31);
            berth.setLength(204);     //m
            berth.setDepth(-13.5);      //m
            berth.setName("北仑国际集装箱3#泊位");
            berth.setShipEnum(ShipEnum.Container_Ship);
            berth.setTonner(100000); //吨
            berth.setToAnchorageTime(2.58);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(32);
            berth.setLength(232);     //m
            berth.setDepth(-13.5);      //m
            berth.setName("北仑国际集装箱4#泊位");
            berth.setShipEnum(ShipEnum.Container_Ship);
            berth.setTonner(100000); //吨
            berth.setToAnchorageTime(2.58);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(33);
            berth.setLength(232);     //m
            berth.setDepth(-13.5);    //m
            berth.setName("北仑国际集装箱5#泊位");
            berth.setShipEnum(ShipEnum.Container_Ship);
            berth.setTonner(100000); //吨
            berth.setToAnchorageTime(2.58);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(34);
            berth.setLength(232);     //m
            berth.setDepth(-13.5);    //m
            berth.setName("北仑国际集装箱6#泊位");
            berth.setShipEnum(ShipEnum.Container_Ship);
            berth.setTonner(100000); //吨
            berth.setToAnchorageTime(2.58);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(35);
            berth.setLength(250);     //m
            berth.setDepth(-14);      //m
            berth.setName("北二司1#泊位");
            berth.setShipEnum(ShipEnum.Iron_Ore);
            berth.setTonner(50000); //吨
            berth.setToAnchorageTime(2.67);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(36);
            berth.setLength(264);     //m
            berth.setDepth(-14);      //m
            berth.setName("北二司2#泊位");
            berth.setShipEnum(ShipEnum.Iron_Ore);
            berth.setTonner(50000); //吨
            berth.setToAnchorageTime(2.67);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(37);
            berth.setLength(168);     //m
            berth.setDepth(-13.5);    //m
            berth.setName("北二司3#泊位");
            berth.setShipEnum(ShipEnum.Iron_Ore);
            berth.setTonner(7000); //吨
            berth.setToAnchorageTime(3.08);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(38);
            berth.setLength(262);     //m
            berth.setDepth(-13.5);    //m
            berth.setName("北二司4#泊位");
            berth.setShipEnum(ShipEnum.Iron_Ore);
            berth.setTonner(30000);   //吨
            berth.setToAnchorageTime(3.08);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(39);
            berth.setLength(344);     //m
            berth.setDepth(-13.5);    //m
            berth.setName("北二司6#泊位");
            berth.setShipEnum(ShipEnum.Iron_Ore);
            berth.setTonner(50000);   //吨
            berth.setToAnchorageTime(2.50);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(40);
            berth.setLength(351);     //m
            berth.setDepth(-20);    //m
            berth.setName("北司1#泊位");
            berth.setShipEnum(ShipEnum.Iron_Ore);
            berth.setTonner(150000);   //吨
            berth.setToAnchorageTime(3.25);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(41);
            berth.setLength(422);     //m
            berth.setDepth(-22);    //m
            berth.setName("北司2#泊位");
            berth.setShipEnum(ShipEnum.Iron_Ore);
            berth.setTonner(200000);   //吨
            berth.setToAnchorageTime(3.25);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(42);
            berth.setLength(250);     //m
            berth.setDepth(-13.5);    //m
            berth.setName("北司3#泊位");
            berth.setShipEnum(ShipEnum.Iron_Ore);
            berth.setTonner(50000);   //吨
            berth.setToAnchorageTime(3.17);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(43);
            berth.setLength(250);     //m
            berth.setDepth(-13.5);    //m
            berth.setName("北司4#泊位");
            berth.setShipEnum(ShipEnum.Iron_Ore);
            berth.setTonner(50000);   //吨
            berth.setToAnchorageTime(3.17);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(44);
            berth.setLength(150);     //m
            berth.setDepth(-11);     //m
            berth.setName("北司5#泊位");
            berth.setShipEnum(ShipEnum.Iron_Ore);
            berth.setTonner(25000);   //吨
            berth.setToAnchorageTime(3.17);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(45);
            berth.setLength(260);     //m
            berth.setDepth(-13.5);    //m
            berth.setName("北司6#泊位");
            berth.setShipEnum(ShipEnum.Iron_Ore);
            berth.setTonner(50000);   //吨
            berth.setToAnchorageTime(3.17);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(46);
            berth.setLength(310);     //m
            berth.setDepth(-15.8);    //m
            berth.setName("台塑1-1#泊位");
            berth.setShipEnum(ShipEnum.Chemical_Oil);
            berth.setTonner(50000);   //吨
            berth.setToAnchorageTime(2.83);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(47);
            berth.setLength(310);     //m
            berth.setDepth(-14);    //m
            berth.setName("台塑1-2#泊位");
            berth.setShipEnum(ShipEnum.Chemical_Oil);
            berth.setTonner(30000);   //吨
            berth.setToAnchorageTime(2.83);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(48);
            berth.setLength(300);     //m
            berth.setDepth(-15.8);    //m
            berth.setName("台塑2-1#泊位");
            berth.setShipEnum(ShipEnum.Chemical_Oil);
            berth.setTonner(50000);   //吨
            berth.setToAnchorageTime(2.92);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(49);
            berth.setLength(300);     //m
            berth.setDepth(-14);      //m
            berth.setName("台塑2-2#泊位");
            berth.setShipEnum(ShipEnum.Chemical_Oil);
            berth.setTonner(30000);   //吨
            berth.setToAnchorageTime(2.92);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(50);
            berth.setLength(240);     //m
            berth.setDepth(-14);      //m
            berth.setName("台塑多用途1#泊位");
            berth.setShipEnum(ShipEnum.Chemical_Oil);
            berth.setTonner(20000);   //吨
            berth.setToAnchorageTime(3.0);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(51);
            berth.setLength(240);     //m
            berth.setDepth(-14);      //m
            berth.setName("台塑多用途2#泊位");
            berth.setShipEnum(ShipEnum.Chemical_Oil);
            berth.setTonner(20000);   //吨
            berth.setToAnchorageTime(3.0);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(52);
            berth.setLength(270);     //m
            berth.setDepth(-14);      //m
            berth.setName("台塑多用途3#泊位");
            berth.setShipEnum(ShipEnum.Chemical_Oil);
            berth.setTonner(35000);   //吨
            berth.setToAnchorageTime(3.0);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(53);
            berth.setLength(240);     //m
            berth.setDepth(-12.5);      //m
            berth.setName("信业码头1#泊位");
            berth.setShipEnum(ShipEnum.Container_Ship);
            berth.setTonner(20000);   //吨
            berth.setToAnchorageTime(2.50);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(54);
            berth.setLength(240);     //m
            berth.setDepth(-12.5);      //m
            berth.setName("信业码头2#泊位");
            berth.setShipEnum(ShipEnum.Container_Ship);
            berth.setTonner(20000);   //吨
            berth.setToAnchorageTime(2.50);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(55);
            berth.setLength(0);     //m
            berth.setDepth(0);      //m
            berth.setName("大榭兴发#泊位");
            berth.setShipEnum(ShipEnum.Chemical_Oil);
            berth.setTonner(0);   //吨
            berth.setToAnchorageTime(2.50);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(56);
            berth.setLength(0);     //m
            berth.setDepth(0);      //m
            berth.setName("大榭永信#泊位");
            berth.setShipEnum(ShipEnum.Chemical_Oil);
            berth.setTonner(0);   //吨
            berth.setToAnchorageTime(2.50);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(57);
            berth.setLength(330);     //m
            berth.setDepth(-17);      //m
            berth.setName("招商国际1#泊位");
            berth.setShipEnum(ShipEnum.Container_Ship);
            berth.setTonner(100000);   //吨
            berth.setToAnchorageTime(2.50);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(58);
            berth.setLength(360);     //m
            berth.setDepth(-17);      //m
            berth.setName("招商国际2#泊位");
            berth.setShipEnum(ShipEnum.Container_Ship);
            berth.setTonner(150000);   //吨
            berth.setToAnchorageTime(2.50);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(59);
            berth.setLength(450);     //m
            berth.setDepth(-17);      //m
            berth.setName("招商国际3#泊位");
            berth.setShipEnum(ShipEnum.Container_Ship);
            berth.setTonner(150000);   //吨
            berth.setToAnchorageTime(2.50);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(60);
            berth.setLength(360);     //m
            berth.setDepth(-17);      //m
            berth.setName("招商国际4#泊位");
            berth.setShipEnum(ShipEnum.Container_Ship);
            berth.setTonner(70000);   //吨
            berth.setToAnchorageTime(2.50);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(61);
            berth.setLength(340);     //m
            berth.setDepth(-17);      //m
            berth.setName("烟台万华煤盐#泊位");
            berth.setShipEnum(ShipEnum.Container_Ship);
            berth.setTonner(50000);   //吨
            berth.setToAnchorageTime(2.42);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(62);
            berth.setLength(330);     //m
            berth.setDepth(-17);      //m
            berth.setName("烟台万华化工5万吨#泊位");
            berth.setShipEnum(ShipEnum.Chemical_Oil);
            berth.setTonner(50000);   //吨
            berth.setToAnchorageTime(2.33);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(63);
            berth.setLength(263);     //m
            berth.setDepth(-15);      //m
            berth.setName("烟台万华化工2万吨#泊位");
            berth.setShipEnum(ShipEnum.Chemical_Oil);
            berth.setTonner(20000);   //吨
            berth.setToAnchorageTime(2.33);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(64);
            berth.setLength(515);     //m
            berth.setDepth(-25);      //m
            berth.setName("大榭中油燃料油#泊位");
            berth.setShipEnum(ShipEnum.Crude_Oil);
            berth.setTonner(300000);   //吨
            berth.setToAnchorageTime(4.0);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(65);
            berth.setLength(330);     //m
            berth.setDepth(-15);      //m
            berth.setName("大榭百地年#泊位");
            berth.setShipEnum(ShipEnum.Chemical_Oil);
            berth.setTonner(50000);   //吨
            berth.setToAnchorageTime(4.0);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(66);
            berth.setLength(360);     //m
            berth.setDepth(-16);      //m
            berth.setName("大榭关外#泊位");
            berth.setShipEnum(ShipEnum.Chemical_Oil);
            berth.setTonner(50000);   //吨
            berth.setToAnchorageTime(2.17);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(67);
            berth.setLength(480);     //m
            berth.setDepth(-16);      //m
            berth.setName("大榭利万1-3码头#泊位");
            berth.setShipEnum(ShipEnum.Crude_Oil);
            berth.setTonner(50000);   //吨
            berth.setToAnchorageTime(2.5);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(68);
            berth.setLength(330);     //m
            berth.setDepth(-12);      //m
            berth.setName("大榭利万5-7码头#泊位");
            berth.setShipEnum(ShipEnum.Chemical_Oil);
            berth.setTonner(30000);   //吨
            berth.setToAnchorageTime(2.47);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(69);
            berth.setLength(490);     //m
            berth.setDepth(-27.5);      //m
            berth.setName("大榭实华3#泊位");
            berth.setShipEnum(ShipEnum.Chemical_Oil);
            berth.setTonner(450000);   //吨
            berth.setToAnchorageTime(3.0);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(70);
            berth.setLength(0);     //m
            berth.setDepth(0);      //m
            berth.setName("港发码头#泊位");
            berth.setShipEnum(ShipEnum.Chemical_Oil);
            berth.setTonner(0);   //吨
            berth.setToAnchorageTime(3.0);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(71);
            berth.setLength(485);     //m
            berth.setDepth(-24.5);    //m
            berth.setName("大榭实华1#泊位");
            berth.setShipEnum(ShipEnum.Chemical_Oil);
            berth.setTonner(300000);   //吨
            berth.setToAnchorageTime(3.0);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(72);
            berth.setLength(269.5);     //m
            berth.setDepth(-16.9);      //m
            berth.setName("大榭实华2#泊位");
            berth.setShipEnum(ShipEnum.Chemical_Oil);
            berth.setTonner(69793);   //吨
            berth.setToAnchorageTime(3.0);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(73);
            berth.setLength(300);     //m
            berth.setDepth(-17);      //m
            berth.setName("港吉2#泊位");
            berth.setShipEnum(ShipEnum.Container_Ship);
            berth.setTonner(100000);   //吨
            berth.setToAnchorageTime(2.0);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(74);
            berth.setLength(400);     //m
            berth.setDepth(-17);      //m
            berth.setName("港吉3#泊位");
            berth.setShipEnum(ShipEnum.Container_Ship);
            berth.setTonner(150000);   //吨
            berth.setToAnchorageTime(2.0);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(75);
            berth.setLength(325);     //m
            berth.setDepth(-17);      //m
            berth.setName("港吉4泊位");
            berth.setShipEnum(ShipEnum.Container_Ship);
            berth.setTonner(150000);   //吨
            berth.setToAnchorageTime(2.0);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(76);
            berth.setLength(325);     //m
            berth.setDepth(-17);      //m
            berth.setName("港吉5#泊位");
            berth.setShipEnum(ShipEnum.Container_Ship);
            berth.setTonner(150000);   //吨
            berth.setToAnchorageTime(2.0);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(77);
            berth.setLength(350);     //m
            berth.setDepth(-17);      //m
            berth.setName("港吉6#泊位");
            berth.setShipEnum(ShipEnum.Container_Ship);
            berth.setTonner(150000);   //吨
            berth.setToAnchorageTime(2.0);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(78);
            berth.setLength(385);     //m
            berth.setDepth(-17);      //m
            berth.setName("远东7#泊位");
            berth.setShipEnum(ShipEnum.Container_Ship);
            berth.setTonner(150000);   //吨
            berth.setToAnchorageTime(1.92);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(79);
            berth.setLength(340);     //m
            berth.setDepth(-17);      //m
            berth.setName("远东8#泊位");
            berth.setShipEnum(ShipEnum.Container_Ship);
            berth.setTonner(150000);   //吨
            berth.setToAnchorageTime(1.92);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(80);
            berth.setLength(285);     //m
            berth.setDepth(-17);      //m
            berth.setName("远东9#泊位");
            berth.setShipEnum(ShipEnum.Container_Ship);
            berth.setTonner(100000);   //吨
            berth.setToAnchorageTime(1.92);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(81);
            berth.setLength(350);     //m
            berth.setDepth(-17);      //m
            berth.setName("远东10#泊位");
            berth.setShipEnum(ShipEnum.Container_Ship);
            berth.setTonner(150000);   //吨
            berth.setToAnchorageTime(1.92);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(82);
            berth.setLength(350);     //m
            berth.setDepth(-17);      //m
            berth.setName("远东11#泊位");
            berth.setShipEnum(ShipEnum.Container_Ship);
            berth.setTonner(150000);   //吨
            berth.setToAnchorageTime(1.92);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(83);
            berth.setLength(520);     //m
            berth.setDepth(-21.5);      //m
            berth.setName("中宅码头1#泊位");
            berth.setShipEnum(ShipEnum.Iron_Ore);
            berth.setTonner(250000);   //吨
            berth.setToAnchorageTime(1.83);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(84);
            berth.setLength(352);     //m
            berth.setDepth(-13.8);      //m
            berth.setName("中宅码头2#泊位");
            berth.setShipEnum(ShipEnum.Iron_Ore);
            berth.setTonner(50000);   //吨
            berth.setToAnchorageTime(1.83);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(85);
            berth.setLength(440);     //m
            berth.setDepth(-16);      //m
            berth.setName("LNG码头卸船#泊位");
            berth.setShipEnum(ShipEnum.Chemical_Oil);
            berth.setTonner(266000);   //吨
            berth.setToAnchorageTime(2.5);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(86);
            berth.setLength(240);     //m
            berth.setDepth(-13.7);      //m
            berth.setName("光明码头1#泊位");
            berth.setShipEnum(ShipEnum.Coal);
            berth.setTonner(35000);   //吨
            berth.setToAnchorageTime(2.0);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(87);
            berth.setLength(189);     //m
            berth.setDepth(-16.9);      //m
            berth.setName("光明码头2#泊位");
            berth.setShipEnum(ShipEnum.Coal);
            berth.setTonner(20000);   //吨
            berth.setToAnchorageTime(2.0);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(88);
            berth.setLength(310);     //m
            berth.setDepth(-17.3);      //m
            berth.setName("光明码头3#泊位");
            berth.setShipEnum(ShipEnum.Coal);
            berth.setTonner(10000);   //吨
            berth.setToAnchorageTime(2.0);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(89);
            berth.setLength(225);     //m
            berth.setDepth(-16);      //m
            berth.setName("港鑫东方#泊位");
            berth.setShipEnum(ShipEnum.Chemical_Oil);
            berth.setTonner(50000);   //吨
            berth.setToAnchorageTime(1.75);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(90);
            berth.setLength(366);     //m
            berth.setDepth(-17);      //m
            berth.setName("梅山国际1#泊位");
            berth.setShipEnum(ShipEnum.Container_Ship);
            berth.setTonner(70000);   //吨
            berth.setToAnchorageTime(2.0);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(91);
            berth.setLength(439);     //m
            berth.setDepth(-17);      //m
            berth.setName("梅山国际2#泊位");
            berth.setShipEnum(ShipEnum.Container_Ship);
            berth.setTonner(70000);   //吨
            berth.setToAnchorageTime(2.0);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(92);
            berth.setLength(303);     //m
            berth.setDepth(-17.5);      //m
            berth.setName("梅山国际3#泊位");
            berth.setShipEnum(ShipEnum.Container_Ship);
            berth.setTonner(150000);   //吨
            berth.setToAnchorageTime(2.0);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(93);
            berth.setLength(301);     //m
            berth.setDepth(-19.5);      //m
            berth.setName("梅山国际4#泊位");
            berth.setShipEnum(ShipEnum.Container_Ship);
            berth.setTonner(150000);   //吨
            berth.setToAnchorageTime(2.0);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(94);
            berth.setLength(379);     //m
            berth.setDepth(-19.5);      //m
            berth.setName("梅山国际5#泊位");
            berth.setShipEnum(ShipEnum.Container_Ship);
            berth.setTonner(150000);   //吨
            berth.setToAnchorageTime(2.0);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(95);
            berth.setLength(450);     //m
            berth.setDepth(-15.7);      //m
            berth.setName("梅西滚装船#泊位");
            berth.setShipEnum(ShipEnum.Break_Bulk_Ship);
            berth.setTonner(70000);   //吨
            berth.setToAnchorageTime(2.25);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(96);
            berth.setLength(335);     //m
            berth.setDepth(-18);      //m
            berth.setName("甬舟码头1#泊位");
            berth.setShipEnum(ShipEnum.Container_Ship);
            berth.setTonner(100000);   //吨
            berth.setToAnchorageTime(3.25);
            berthList.add(berth);
        }
        {
            berth = new Berth();
            berth.setId(97);
            berth.setLength(350);     //m
            berth.setDepth(-18);      //m
            berth.setName("甬舟码头2#泊位");
            berth.setShipEnum(ShipEnum.Container_Ship);
            berth.setTonner(100000);   //吨
            berth.setToAnchorageTime(3.25);
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
            traffic.setStatus(1);
            traffic.setStartMon(1);
            traffic.setStartDay(3);
            traffic.setStartHor(5);
            traffic.setStartMin(0);
            traffic.setStartSec(0);
            traffic.setTrafficEnum(TrafficEnum.DANGER_PROHIBIT_ANCHOR);
            traffic.setTrafficDuration(42.93);
            traffic.setTimeEnum(TimeEnum.HOR);
            trafficList.add(traffic);
        }
        {
            traffic = new Traffic();
            traffic.setId(1);
            traffic.setStatus(1);
            traffic.setStartMon(2);
            traffic.setStartDay(4);
            traffic.setStartHor(7);
            traffic.setStartMin(0);
            traffic.setStartSec(0);
            traffic.setTrafficEnum(TrafficEnum.CS_PROHIBIT_ANCHOR);
            traffic.setTrafficDuration(6.33);
            traffic.setTimeEnum(TimeEnum.HOR);
            trafficList.add(traffic);
        }
        {
            traffic = new Traffic();
            traffic.setId(2);
            traffic.setStatus(1);
            traffic.setStartMon(3);
            traffic.setStartDay(4);
            traffic.setStartHor(12);
            traffic.setStartMin(0);
            traffic.setStartSec(0);
            traffic.setTrafficEnum(TrafficEnum.BBS_PROHIBIT_ANCHOR);
            traffic.setTrafficDuration(16.38);
            traffic.setTimeEnum(TimeEnum.HOR);
            trafficList.add(traffic);
        }
        {
            traffic = new Traffic();
            traffic.setId(3);
            traffic.setStatus(1);
            traffic.setStartMon(5);
            traffic.setStartDay(6);
            traffic.setStartHor(8);
            traffic.setStartMin(30);
            traffic.setStartSec(0);
            traffic.setTrafficEnum(TrafficEnum.PROHIBIT_BOTH_TRAVEL_BAD_VISIBILITY);
            traffic.setTrafficDuration(43.12);
            traffic.setTimeEnum(TimeEnum.HOR);
            trafficList.add(traffic);
        }
        {
            traffic = new Traffic();
            traffic.setId(4);
            traffic.setStatus(1);
            traffic.setStartMon(5);
            traffic.setStartDay(30);
            traffic.setStartHor(16);
            traffic.setStartMin(30);
            traffic.setStartSec(0);
            traffic.setTrafficEnum(TrafficEnum.PROHIBIT_CONTRARY_TRAVEL);
            traffic.setTrafficDuration(5.35);
            traffic.setTimeEnum(TimeEnum.HOR);
            trafficList.add(traffic);
        }
        {
            traffic = new Traffic();
            traffic.setId(5);
            traffic.setStatus(1);
            traffic.setStartMon(8);
            traffic.setStartDay(20);
            traffic.setStartHor(15);
            traffic.setStartMin(0);
            traffic.setStartSec(0);
            traffic.setTrafficEnum(TrafficEnum.PROHIBIT_BOTH_TRAVEL_FISH_BOAT_BLOCK);
            traffic.setTrafficDuration(1.35);
            traffic.setTimeEnum(TimeEnum.HOR);
            trafficList.add(traffic);
        }
        {
            traffic = new Traffic();
            traffic.setId(6);
            traffic.setStatus(1);
            traffic.setStartMon(11);
            traffic.setStartDay(6);
            traffic.setStartHor(18);
            traffic.setStartSec(0);
            traffic.setStartMin(0);
            traffic.setTrafficEnum(TrafficEnum.PROHIBIT_BOTH_TRAVEL_ACCIDENT);
            traffic.setTrafficDuration(0.3);
            traffic.setTimeEnum(TimeEnum.HOR);
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
            ship.setShipEnum(ShipEnum.Container_Ship);  //集装箱
            ship.setDepth(10);
            ship.setLength(259.4);
            ship.setNumbers(9840);
            //默认仿真是长是1年，仿真步骤是1秒
            ship.setLambda(27.09);
            ship.setMu(2.45);
            ship.setSigma(0.49);
            ship.setPriorityEnum(PriorityEnum.NORMAL);
            ship.setTonner(6.62);
            ship.setSpeed(1.852);       //km/h
            ship.setSafeDistance(BigDecimalUtil.decimal2Double(259.4 * 6)); //m
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
            ship.setPriorityEnum(PriorityEnum.LOW);
            ship.setTonner(1.67);
            ship.setSpeed(1.852);       //km/h
            ship.setSafeDistance(BigDecimalUtil.decimal2Double(279.4 * 6)); //m
            shipList.add(ship);
        }
        {
            ship = new Ship();
            ship.setId(2);
            ship.setShipEnum(ShipEnum.Chemical_Oil);  //化工油品
            ship.setDepth(10);
            ship.setLength(176.2);
            ship.setNumbers(974);
            //默认仿真是长是1年，仿真步骤是1秒
            ship.setLambda(2.68);
            ship.setMu(3.48);
            ship.setSigma(0.57);
            ship.setPriorityEnum(PriorityEnum.NORMAL);
            ship.setTonner(3.74);
            ship.setSpeed(1.852);       //km/h
            ship.setSafeDistance(BigDecimalUtil.decimal2Double(176.2 * 6)); //m
            shipList.add(ship);
        }
        {
            ship = new Ship();
            ship.setId(3);
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
            ship.setId(4);
            ship.setShipEnum(ShipEnum.Coal);  //煤炭
            ship.setDepth(10);
            ship.setLength(216.3);
            ship.setNumbers(380);
            //默认仿真是长是1年，仿真步骤是1秒
            ship.setLambda(1.05);
            ship.setMu(3.89);
            ship.setSigma(0.67);
            ship.setPriorityEnum(PriorityEnum.HIGH);
            ship.setTonner(6.78);
            ship.setSpeed(1.852);       //km/h
            ship.setSafeDistance(BigDecimalUtil.decimal2Double(216.3 * 5)); //m
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
