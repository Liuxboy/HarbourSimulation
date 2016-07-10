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
    private double totalInHarboursTime;
    //船舶平均等待航道时间，单位：小时
    private double avgWaitChannelTime;
    //船舶总等待航道时间，单位：小时
    private double totalWaitChannelTime;
    //船舶平均等待泊位时间，单位：小时
    private double avgWaitBerthTime;
    //船舶总等待泊位时间，单位：小时
    private double totalWaitBerthTime;
    //船舶平均在泊时间，单位：小时
    private double avgOnBerthTime;
    //船舶总在泊时间，单位：小时
    private double totalOnBerthTime;
    //AWT/AST指标
    //AWT表示平均等待时间：平均等待航道时间+平均等待泊位时间
    //AST表示平均在泊时间
    private String awtAstIndex;
    //泊位利用率，百分数%
    private String berthUtilizationRatio;

    public Result(ShipEnum shipEnum) {
        this.shipEnum = shipEnum;
    }

    public Result(int number, ShipEnum shipEnum, double avgInHarbourTime, double totalInHarboursTime, double avgWaitChannelTime, double totalWaitChannelTime, double avgWaitBerthTime, double totalWaitBerthTime, double avgOnBerthTime, double totalOnBerthTime, String awtAstIndex, String berthUtilizationRatio) {
        this.number = number;
        this.shipEnum = shipEnum;
        this.avgInHarbourTime = BigDecimalUtil.decimal2Double(avgInHarbourTime);
        this.totalInHarboursTime = totalInHarboursTime;
        this.avgWaitChannelTime = BigDecimalUtil.decimal2Double(avgWaitChannelTime);
        this.totalWaitChannelTime = totalWaitChannelTime;
        this.avgWaitBerthTime = BigDecimalUtil.decimal2Double(avgWaitBerthTime);
        this.totalWaitBerthTime = totalWaitBerthTime;
        this.avgOnBerthTime = BigDecimalUtil.decimal2Double(avgOnBerthTime);
        this.totalOnBerthTime = totalOnBerthTime;
        this.awtAstIndex = awtAstIndex;
        this.berthUtilizationRatio = berthUtilizationRatio;
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

    public double getAvgWaitChannelTime() {
        return avgWaitChannelTime;
    }

    public void setAvgWaitChannelTime(double avgWaitChannelTime) {
        this.avgWaitChannelTime = avgWaitChannelTime;
    }

    public double getAvgWaitBerthTime() {
        return avgWaitBerthTime;
    }

    public void setAvgWaitBerthTime(double avgWaitBerthTime) {
        this.avgWaitBerthTime = avgWaitBerthTime;
    }

    public double getAvgOnBerthTime() {
        return avgOnBerthTime;
    }

    public void setAvgOnBerthTime(double avgOnBerthTime) {
        this.avgOnBerthTime = avgOnBerthTime;
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

    public double getTotalInHarboursTime() {
        return totalInHarboursTime;
    }

    public void setTotalInHarboursTime(double totalInHarboursTime) {
        this.totalInHarboursTime = totalInHarboursTime;
    }

    public double getTotalWaitChannelTime() {
        return totalWaitChannelTime;
    }

    public void setTotalWaitChannelTime(double totalWaitChannelTime) {
        this.totalWaitChannelTime = totalWaitChannelTime;
    }

    public double getTotalWaitBerthTime() {
        return totalWaitBerthTime;
    }

    public void setTotalWaitBerthTime(double totalWaitBerthTime) {
        this.totalWaitBerthTime = totalWaitBerthTime;
    }

    public double getTotalOnBerthTime() {
        return totalOnBerthTime;
    }

    public void setTotalOnBerthTime(double totalOnBerthTime) {
        this.totalOnBerthTime = totalOnBerthTime;
    }

    @Override
    public String toString() {
        return "Result{" +
                "number=" + number +
                ", shipEnum=" + shipEnum +
                ", avgInHarbourTime=" + avgInHarbourTime +
                ", totalInHarboursTime=" + totalInHarboursTime +
                ", avgWaitChannelTime=" + avgWaitChannelTime +
                ", totalWaitChannelTime=" + totalWaitChannelTime +
                ", avgWaitBerthTime=" + avgWaitBerthTime +
                ", totalWaitBerthTime=" + totalWaitBerthTime +
                ", avgOnBerthTime=" + avgOnBerthTime +
                ", totalOnBerthTime=" + totalOnBerthTime +
                ", awtAstIndex='" + awtAstIndex + '\'' +
                ", berthUtilizationRatio='" + berthUtilizationRatio + '\'' +
                '}';
    }
}
