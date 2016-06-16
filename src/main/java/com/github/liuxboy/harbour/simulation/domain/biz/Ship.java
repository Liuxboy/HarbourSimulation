package com.github.liuxboy.harbour.simulation.domain.biz;

import com.github.liuxboy.harbour.simulation.common.constant.PriorityEnum;
import com.github.liuxboy.harbour.simulation.common.constant.ShipEnum;
import com.github.liuxboy.harbour.simulation.common.constant.TonnerEnum;

/**
 * <p>Title: Ship</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/4 11:54</p>
 * <p>Description: 船舶 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
public class Ship {
    //编号
    private int id = 1;
    //种类
    private ShipEnum shipEnum;
    //长度
    private int length;
    //宽度
    private int width;
    //吃水深度
    private int depth;
    //航速
    private float speed;
    //到达时间
    private String arrivalTime;
    //在泊位作业时长
    private float workHour;
    //吨级
    private TonnerEnum tonnerEnum;
    //进港优先级
    private PriorityEnum priorityEnum;
    //坐标
    private Point point;
    //数量
    private int numbers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TonnerEnum getTonnerEnum() {
        return tonnerEnum;
    }

    public void setTonnerEnum(TonnerEnum tonnerEnum) {
        this.tonnerEnum = tonnerEnum;
    }

    public ShipEnum getShipEnum() {
        return shipEnum;
    }

    public void setShipEnum(ShipEnum shipEnum) {
        this.shipEnum = shipEnum;
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

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public PriorityEnum getPriorityEnum() {
        return priorityEnum;
    }

    public void setPriorityEnum(PriorityEnum priorityEnum) {
        this.priorityEnum = priorityEnum;
    }

    public float getWorkHour() {
        return workHour;
    }

    public void setWorkHour(float workHour) {
        this.workHour = workHour;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        final StringBuilder stbd = new StringBuilder("Ship{");
        stbd.append("\"id\":").append(id);
        stbd.append("\"shipEnum\":").append(shipEnum);
        stbd.append("\"tonnerEnum\":").append(tonnerEnum);
        stbd.append(",\"length\":").append(length);
        stbd.append(",\"width\":").append(width);
        stbd.append(",\"depth\":").append(depth);
        stbd.append(",\"speed\":").append(speed);
        stbd.append(",\"arrivalTime\":\"").append(arrivalTime).append('\"');
        stbd.append(",\"priorityEnum\":").append(priorityEnum);
        stbd.append(",\"workHour\":").append(workHour);
        stbd.append(",\"point\":").append(point);
        stbd.append(",\"numbers\":").append(numbers);
        stbd.append('}');
        stbd.append(super.toString());
        return stbd.toString();
    }
}
