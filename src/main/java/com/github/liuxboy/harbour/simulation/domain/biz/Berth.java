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
    private int number;
    //泊位类型，对应的船泊类型
    private ShipEnum shipEnum;
    //泊位吨级
    private int tonner;
    //泊位水深
    private int depth;
    //泊位长度
    private int length;
    //泊位宽度
    private int width;
    //坐标
    private Point point;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ShipEnum getShipEnum() {
        return shipEnum;
    }

    public void setShipEnum(ShipEnum shipEnum) {
        this.shipEnum = shipEnum;
    }

    public int getTonner() {
        return tonner;
    }

    public void setTonner(int tonner) {
        this.tonner = tonner;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    @Override
    public String toString() {
        final StringBuilder stbd = new StringBuilder("Berth{");
        stbd.append("\"number\":").append(number);
        stbd.append(",\"shipEnum\":").append(shipEnum);
        stbd.append(",\"tonner\":").append(tonner);
        stbd.append(",\"depth\":").append(depth);
        stbd.append(",\"length\":").append(length);
        stbd.append(",\"width\":").append(width);
        stbd.append(",\"point\":").append(point);
        stbd.append('}');
        stbd.append(super.toString());
        return stbd.toString();
    }
}
