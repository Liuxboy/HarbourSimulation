package com.github.liuxboy.harbour.simulation.domain.biz;

import com.github.liuxboy.harbour.simulation.common.constant.PriorityEnum;
import com.github.liuxboy.harbour.simulation.common.constant.ShipEnum;

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
    private double length;
    //宽度
    private double width;
    //吃水深度
    private double depth;
    //航速
    private double speed;
    //到达分布，泊松分布平均lambda
    private double lambda;
    //靠泊分布，对数正态分布，参数mu
    private double mu;
    //靠泊分布，对数正态分布，参数sigma
    private double sigma;
    //吨级
    private double tonner;
    //进港优先级
    private PriorityEnum priorityEnum;
    //安全距离
    private double safeDistance;
    //坐标纬度
    private double x;
    //坐标经度
    private double y;
    //数量
    private int numbers;
    //船舶在港时间点
    private TimeNode timeNode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSpeed() {
        return speed;
    }

    public double getTonner() {
        return tonner;
    }

    public void setTonner(double tonner) {
        this.tonner = tonner;
    }

    public ShipEnum getShipEnum() {
        return shipEnum;
    }

    public void setShipEnum(ShipEnum shipEnum) {
        this.shipEnum = shipEnum;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public PriorityEnum getPriorityEnum() {
        return priorityEnum;
    }

    public void setPriorityEnum(PriorityEnum priorityEnum) {
        this.priorityEnum = priorityEnum;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getLambda() {
        return lambda;
    }

    public void setLambda(double lambda) {
        this.lambda = lambda;
    }

    public double getMu() {
        return mu;
    }

    public void setMu(double mu) {
        this.mu = mu;
    }

    public double getSigma() {
        return sigma;
    }

    public void setSigma(double sigma) {
        this.sigma = sigma;
    }

    public double getSafeDistance() {
        return safeDistance;
    }

    public void setSafeDistance(double safeDistance) {
        this.safeDistance = safeDistance;
    }

    public TimeNode getTimeNode() {
        return timeNode;
    }

    public void setTimeNode(TimeNode timeNode) {
        this.timeNode = timeNode;
    }

    @Override
    public String toString() {
        final StringBuilder stbd = new StringBuilder("Ship{");
        stbd.append("\"id\":").append(id);
        stbd.append(",\"shipEnum\":").append(shipEnum);
        stbd.append(",\"length\":").append(length);
        stbd.append(",\"width\":").append(width);
        stbd.append(",\"depth\":").append(depth);
        stbd.append(",\"speed\":").append(speed);
        stbd.append(",\"lambda\":").append(lambda);
        stbd.append(",\"mu\":").append(mu);
        stbd.append(",\"sigma\":").append(sigma);
        stbd.append(",\"tonner\":").append(tonner);
        stbd.append(",\"priorityEnum\":").append(priorityEnum);
        stbd.append(",\"numbers\":").append(numbers);
        stbd.append(",\"timeNode\":").append(timeNode);
        stbd.append(",\"y\":").append(y);
        stbd.append(",\"x\":").append(x);
        stbd.append('}');
        stbd.append(super.toString());
        return stbd.toString();
    }
}
