package com.github.liuxboy.harbour.simulation.domain.biz;

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
    private String avgInHarbourTime;
    //船舶平均等待航道时间，单位：小时
    private String avgWaitChannelTime;
    //船舶平均等泊时间，单位：小时
    private String avgWaitBerthTime;
    //船舶平均在泊时间，单位：小时
    private String avgOnBerthTime;
    //AWT/AST指标
    //AWT表示平均等待时间：平均等待航道时间+平均等待泊位时间
    //AST表示平均在泊时间
    private String awtAstIndex;
    //泊位利用率，百分数%
    private String berthUtilizationRatio;

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

    public String getAvgInHarbourTime() {
        return avgInHarbourTime;
    }

    public void setAvgInHarbourTime(String avgInHarbourTime) {
        this.avgInHarbourTime = avgInHarbourTime;
    }

    public String getAvgWaitChannelTime() {
        return avgWaitChannelTime;
    }

    public void setAvgWaitChannelTime(String avgWaitChannelTime) {
        this.avgWaitChannelTime = avgWaitChannelTime;
    }

    public String getAvgWaitBerthTime() {
        return avgWaitBerthTime;
    }

    public void setAvgWaitBerthTime(String avgWaitBerthTime) {
        this.avgWaitBerthTime = avgWaitBerthTime;
    }

    public String getAvgOnBerthTime() {
        return avgOnBerthTime;
    }

    public void setAvgOnBerthTime(String avgOnBerthTime) {
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

    @Override
    public String toString() {
        final StringBuilder stbd = new StringBuilder("Result{");
        stbd.append("\"shipEnum\":").append(shipEnum);
        stbd.append(",\"number\":\"").append(number).append('\"');
        stbd.append(",\"avgInHarbourTime\":\"").append(avgInHarbourTime).append('\"');
        stbd.append(",\"avgWaitChannelTime\":\"").append(avgWaitChannelTime).append('\"');
        stbd.append(",\"avgWaitBerthTime\":\"").append(avgWaitBerthTime).append('\"');
        stbd.append(",\"avgOnBerthTime\":\"").append(avgOnBerthTime).append('\"');
        stbd.append(",\"awtAstIndex\":\"").append(awtAstIndex).append('\"');
        stbd.append(",\"berthUtilizationRatio\":\"").append(berthUtilizationRatio).append('\"');
        stbd.append('}');
        stbd.append(super.toString());
        return stbd.toString();
    }
}
