package com.github.liuxboy.harbour.simulation.domain.biz;

import com.github.liuxboy.harbour.simulation.common.constant.AnchorageEnum;

import java.util.LinkedList;

/**
 * <p>Title: Anchorage</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/4 12:04</p>
 * <p>Description: 锚地 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
public class Anchorage {
    //錨地船舶列表
    private LinkedList<Ship> shipList = new LinkedList<Ship>();
    //锚位数量
    private int size;
    //编号
    private int id = 1;
    //类型
    private AnchorageEnum anchorageEnum;
    //坐标1纬度
    private double point1X;
    //坐标1经度
    private double point1Y;
    //坐标2纬度
    private double point2X;
    //坐标2经度
    private double point2Y;
    //坐标3纬度
    private double point3X;
    //坐标3经度
    private double point3Y;
    //坐标4纬度
    private double point4X;
    //坐标4经度
    private double point4Y;
    //坐标5纬度
    private double point5X;
    //坐标5经度
    private double point5Y;
    //坐标6纬度
    private double point6X;
    //坐标6经度
    private double point6Y;

    public LinkedList<Ship> getShipList() {
        return shipList;
    }

    public void setShipList(LinkedList<Ship> shipList) {
        this.shipList = shipList;
    }

    public AnchorageEnum getAnchorageEnum() {
        return anchorageEnum;
    }

    public void setAnchorageEnum(AnchorageEnum anchorageEnum) {
        this.anchorageEnum = anchorageEnum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPoint1X() {
        return point1X;
    }

    public void setPoint1X(double point1X) {
        this.point1X = point1X;
    }

    public double getPoint1Y() {
        return point1Y;
    }

    public void setPoint1Y(double point1Y) {
        this.point1Y = point1Y;
    }

    public double getPoint2X() {
        return point2X;
    }

    public void setPoint2X(double point2X) {
        this.point2X = point2X;
    }

    public double getPoint2Y() {
        return point2Y;
    }

    public void setPoint2Y(double point2Y) {
        this.point2Y = point2Y;
    }

    public double getPoint3X() {
        return point3X;
    }

    public void setPoint3X(double point3X) {
        this.point3X = point3X;
    }

    public double getPoint3Y() {
        return point3Y;
    }

    public void setPoint3Y(double point3Y) {
        this.point3Y = point3Y;
    }

    public double getPoint4X() {
        return point4X;
    }

    public void setPoint4X(double point4X) {
        this.point4X = point4X;
    }

    public double getPoint4Y() {
        return point4Y;
    }

    public void setPoint4Y(double point4Y) {
        this.point4Y = point4Y;
    }

    public double getPoint5X() {
        return point5X;
    }

    public void setPoint5X(double point5X) {
        this.point5X = point5X;
    }

    public double getPoint5Y() {
        return point5Y;
    }

    public void setPoint5Y(double point5Y) {
        this.point5Y = point5Y;
    }

    public double getPoint6X() {
        return point6X;
    }

    public void setPoint6X(double point6X) {
        this.point6X = point6X;
    }

    public double getPoint6Y() {
        return point6Y;
    }

    public void setPoint6Y(double point6Y) {
        this.point6Y = point6Y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        final StringBuilder stbd = new StringBuilder("Anchorage{");
        stbd.append("\"size\":").append(size);
        stbd.append(",\"id\":").append(id);
        stbd.append(",\"anchorageEnum\":").append(anchorageEnum);
        stbd.append(",\"point1X\":").append(point1X);
        stbd.append(",\"point1Y\":").append(point1Y);
        stbd.append(",\"point2X\":").append(point2X);
        stbd.append(",\"point2Y\":").append(point2Y);
        stbd.append(",\"point3X\":").append(point3X);
        stbd.append(",\"point3Y\":").append(point3Y);
        stbd.append(",\"point4X\":").append(point4X);
        stbd.append(",\"point4Y\":").append(point4Y);
        stbd.append(",\"point5X\":").append(point5X);
        stbd.append(",\"point5Y\":").append(point5Y);
        stbd.append(",\"point6X\":").append(point6X);
        stbd.append(",\"point6Y\":").append(point6Y);
        stbd.append('}');
        stbd.append(super.toString());
        return stbd.toString();
    }
}
