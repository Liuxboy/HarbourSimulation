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
    //管制次数
    private long trafficTimes;
    //管制时长
    private long trafficDuration;
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

    public long getTrafficDuration() {
        return trafficDuration;
    }

    public void setTrafficDuration(long trafficDuration) {
        this.trafficDuration = trafficDuration;
    }

    public TimeEnum getTimeEnum() {
        return timeEnum;
    }

    public void setTimeEnum(TimeEnum timeEnum) {
        this.timeEnum = timeEnum;
    }

    public long getTrafficTimes() {
        return trafficTimes;
    }

    public void setTrafficTimes(long trafficTimes) {
        this.trafficTimes = trafficTimes;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        final StringBuilder stbd = new StringBuilder("Traffic{");
        stbd.append("\"id\":").append(id);
        stbd.append(",\"trafficEnum\":").append(trafficEnum);
        stbd.append(",\"trafficTimes\":").append(trafficTimes);
        stbd.append(",\"trafficDuration\":").append(trafficDuration);
        stbd.append(",\"timeEnum\":").append(timeEnum);
        stbd.append(",\"status\":").append(status);
        stbd.append('}');
        stbd.append(super.toString());
        return stbd.toString();
    }
}
