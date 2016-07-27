package com.github.liuxboy.harbour.simulation.domain.biz;

import com.github.liuxboy.harbour.simulation.common.constant.BigDecimalUtil;
import com.github.liuxboy.harbour.simulation.common.constant.ShipEnum;

import java.io.Serializable;

/**
 * <p>Title: Result</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/14 0:07</p>
 * <p>Description: 最終結果 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
public class Result implements Serializable {
    private static final long serialVersionUID = -7093442578170950522L;
    //船數量
    private int number;
    //船舶类型
    private ShipEnum shipEnum;
    //船舶平均在港时间，单位：小时
    private double avgInHarbourTime;
    //船舶总在港时间，单位：小时
    private int totalInHarboursMins;
    //船舶平均等待航道时间，单位：小时
    private double avgWaitChannelTime;
    //船舶总等待航道时间，单位：小时
    private int totalWaitChannelMins;
    //船舶平均等待泊位时间，单位：小时
    private double avgWaitBerthTime;
    //船舶总等待泊位时间，单位：小时
    private int totalWaitBerthMins;
    //船舶平均在泊时间，单位：小时
    private double avgOnBerthTime;
    //船舶总在泊时间，单位：小时
    private int totalOnBerthMins;
    //AWT/AST指标
    //AWT表示平均等待时间：平均等待航道时间+平均等待泊位时间
    //AST表示平均在泊时间
    private String awtAstIndex;
    //泊位利用率，原始小数
    private double berthUtilization;
    //泊位利用率，百分数%
    private String berthUtilizationRatio;

    public Result(ShipEnum shipEnum) {
        this.shipEnum = shipEnum;
    }

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

    public double getAvgInHarbourTime() {
        return avgInHarbourTime;
    }

    public void setAvgInHarbourTime(double avgInHarbourTime) {
        this.avgInHarbourTime = avgInHarbourTime;
    }

    public int getTotalInHarboursMins() {
        return totalInHarboursMins;
    }

    public void setTotalInHarboursMins(int totalInHarboursMins) {
        this.totalInHarboursMins = totalInHarboursMins;
    }

    public double getAvgWaitChannelTime() {
        return avgWaitChannelTime;
    }

    public void setAvgWaitChannelTime(double avgWaitChannelTime) {
        this.avgWaitChannelTime = avgWaitChannelTime;
    }

    public int getTotalWaitChannelMins() {
        return totalWaitChannelMins;
    }

    public void setTotalWaitChannelMins(int totalWaitChannelMins) {
        this.totalWaitChannelMins = totalWaitChannelMins;
    }

    public double getAvgWaitBerthTime() {
        return avgWaitBerthTime;
    }

    public void setAvgWaitBerthTime(double avgWaitBerthTime) {
        this.avgWaitBerthTime = avgWaitBerthTime;
    }

    public int getTotalWaitBerthMins() {
        return totalWaitBerthMins;
    }

    public void setTotalWaitBerthMins(int totalWaitBerthMins) {
        this.totalWaitBerthMins = totalWaitBerthMins;
    }

    public double getAvgOnBerthTime() {
        return avgOnBerthTime;
    }

    public void setAvgOnBerthTime(double avgOnBerthTime) {
        this.avgOnBerthTime = avgOnBerthTime;
    }

    public int getTotalOnBerthMins() {
        return totalOnBerthMins;
    }

    public void setTotalOnBerthMins(int totalOnBerthMins) {
        this.totalOnBerthMins = totalOnBerthMins;
    }

    public String getAwtAstIndex() {
        return awtAstIndex;
    }

    public void setAwtAstIndex(String awtAstIndex) {
        this.awtAstIndex = awtAstIndex;
    }

    public String getBerthUtilizationRatio() {
        return berthUtilizationRatio;
    }

    public void setBerthUtilizationRatio(String berthUtilizationRatio) {
        this.berthUtilizationRatio = berthUtilizationRatio;
    }

    public double getBerthUtilization() {
        return berthUtilization;
    }

    public void setBerthUtilization(double berthUtilization) {
        this.berthUtilization = berthUtilization;
    }
}
