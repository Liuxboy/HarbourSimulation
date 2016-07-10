package com.github.liuxboy.harbour.simulation.domain.biz;

/**
 * <p>Title: TimeNode</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/7/2 23:17</p>
 * <p>Description: 时间节点 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
public class TimeNode {
    //到达港口时间
    private int arriveTime;
    //进入航道时间
    private int startInChannelTime;
    //靠泊时间
    private int onBerthTime;
    //在泊作业时间
    private double workTime;
    //离开港口时间
    private int leaveTime;

    public int getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(int arriveTime) {
        this.arriveTime = arriveTime;
    }

    public int getStartInChannelTime() {
        return startInChannelTime;
    }

    public void setStartInChannelTime(int startInChannelTime) {
        this.startInChannelTime = startInChannelTime;
    }

    public int getOnBerthTime() {
        return onBerthTime;
    }

    public void setOnBerthTime(int onBerthTime) {
        this.onBerthTime = onBerthTime;
    }

    public double getWorkTime() {
        return workTime;
    }

    public void setWorkTime(double workTime) {
        this.workTime = workTime;
    }

    public int getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(int leaveTime) {
        this.leaveTime = leaveTime;
    }


    @Override
    public String toString() {
        return "TimeNode{" +
                "arriveTime=" + arriveTime +
                ", startInChannelTime=" + startInChannelTime +
                ", onBerthTime=" + onBerthTime +
                ", workTime=" + workTime +
                ", leaveTime=" + leaveTime +
                '}';
    }
}
