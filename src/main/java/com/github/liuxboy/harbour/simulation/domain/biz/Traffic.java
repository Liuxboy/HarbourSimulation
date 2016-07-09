package com.github.liuxboy.harbour.simulation.domain.biz;

import com.github.liuxboy.harbour.simulation.common.constant.TimeEnum;
import com.github.liuxboy.harbour.simulation.common.constant.TrafficEnum;

/**
 * <p>Title: Traffic</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/24 00:31</p>
 * <p>Description: 交通管制 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
public class Traffic {
    //id
    private int id;
    //管制类型
    private TrafficEnum trafficEnum;
    //管制开始时刻-月
    private int startMon;
    //管制开始时刻-天
    private int startDay;
    //管制开始时刻-时
    private int startHor;
    //管制开始时刻-分
    private int startMin;
    //管制开始时刻-秒
    private int startSec;
    //管制时长
    private double trafficDuration;
    //管制时长--单位s
    private TimeEnum timeEnum;
    //1-有效，0-无效
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TrafficEnum getTrafficEnum() {
        return trafficEnum;
    }

    public void setTrafficEnum(TrafficEnum trafficEnum) {
        this.trafficEnum = trafficEnum;
    }

    public double getTrafficDuration() {
        return trafficDuration;
    }

    public void setTrafficDuration(double trafficDuration) {
        this.trafficDuration = trafficDuration;
    }

    public TimeEnum getTimeEnum() {
        return timeEnum;
    }

    public int getStartMon() {
        return startMon;
    }

    public void setStartMon(int startMon) {
        this.startMon = startMon;
    }

    public int getStartDay() {
        return startDay;
    }

    public void setStartDay(int startDay) {
        this.startDay = startDay;
    }

    public int getStartHor() {
        return startHor;
    }

    public void setStartHor(int startHor) {
        this.startHor = startHor;
    }

    public int getStartMin() {
        return startMin;
    }

    public void setStartMin(int startMin) {
        this.startMin = startMin;
    }

    public int getStartSec() {
        return startSec;
    }

    public void setStartSec(int startSec) {
        this.startSec = startSec;
    }

    public void setTimeEnum(TimeEnum timeEnum) {
        this.timeEnum = timeEnum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Traffic{" +
                "id=" + id +
                ", trafficEnum=" + trafficEnum +
                ", startMon=" + startMon +
                ", startDay=" + startDay +
                ", startHor=" + startHor +
                ", startMin=" + startMin +
                ", startSec=" + startSec +
                ", trafficDuration=" + trafficDuration +
                ", timeEnum=" + timeEnum +
                ", status=" + status +
                '}';
    }
}
