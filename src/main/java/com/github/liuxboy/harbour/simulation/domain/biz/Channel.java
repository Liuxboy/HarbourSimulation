package com.github.liuxboy.harbour.simulation.domain.biz;

import com.github.liuxboy.harbour.simulation.common.constant.PassDirectEnum;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>Title: Channel</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/4 12:04</p>
 * <p>Description: 航道 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
@Component
public class Channel {
    //编号
    private int id = 1;
    //航道名
    private String name;
    //宽度
    private double width;
    //长度
    private double length;
    //深度
    private double depth;
    //限速
    private double limitedSpeed;
    //通航模式
    private PassDirectEnum passEnum;
    //进入航道船舶列表
    private LinkedList<Ship> inShipList = new LinkedList<Ship>();
    //驶离航道船舶列表
    private LinkedList<Ship> outShipList = new LinkedList<Ship>();

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

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double getLimitedSpeed() {
        return limitedSpeed;
    }

    public void setLimitedSpeed(double limitedSpeed) {
        this.limitedSpeed = limitedSpeed;
    }

    public PassDirectEnum getPassEnum() {
        return passEnum;
    }

    public void setPassEnum(PassDirectEnum passEnum) {
        this.passEnum = passEnum;
    }

    public LinkedList<Ship> getInShipList() {
        return inShipList;
    }

    public void setInShipList(LinkedList<Ship> inShipList) {
        this.inShipList = inShipList;
    }

    public LinkedList<Ship> getOutShipList() {
        return outShipList;
    }

    public void setOutShipList(LinkedList<Ship> outShipList) {
        this.outShipList = outShipList;
    }

    @Override
    public String toString() {
        final StringBuilder stbd = new StringBuilder("Channel{");
        stbd.append("\"id\":").append(id);
        stbd.append(",\"name\":").append(name);
        stbd.append(",\"width\":").append(width);
        stbd.append(",\"length\":").append(length);
        stbd.append(",\"depth\":").append(depth);
        stbd.append(",\"limitedSpeed\":").append(limitedSpeed);
        stbd.append(",\"passEnum\":").append(passEnum);
        stbd.append(",\"inShipList\":").append(inShipList);
        stbd.append(",\"outShipList\":").append(outShipList);
        stbd.append('}');
        stbd.append(super.toString());
        return stbd.toString();
    }
}
