package com.github.liuxboy.harbour.simulation.domain.biz;

import com.github.liuxboy.harbour.simulation.common.constant.ShipEnum;

/**
 * <p>Title: Berth</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/4 12:04</p>
 * <p>Description: 泊位 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
public class Berth {
    //编号
    private int id = 1;
    //泊位名称
    private String name;
    //泊位类型，对应的船泊类型
    private ShipEnum shipEnum;
    //泊位吨级
    private double tonner;
    //泊位水深
    private double depth;
    //泊位长度
    private double length;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShipEnum getShipEnum() {
        return shipEnum;
    }

    public void setShipEnum(ShipEnum shipEnum) {
        this.shipEnum = shipEnum;
    }

    public double getTonner() {
        return tonner;
    }

    public void setTonner(double tonner) {
        this.tonner = tonner;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        final StringBuilder stbd = new StringBuilder("Berth{");
        stbd.append("\"id\":").append(id);
        stbd.append(",\"name\":").append(name);
        stbd.append(",\"shipEnum\":").append(shipEnum);
        stbd.append(",\"tonner\":").append(tonner);
        stbd.append(",\"depth\":").append(depth);
        stbd.append(",\"length\":").append(length);
        stbd.append('}');
        stbd.append(super.toString());
        return stbd.toString();
    }
}
