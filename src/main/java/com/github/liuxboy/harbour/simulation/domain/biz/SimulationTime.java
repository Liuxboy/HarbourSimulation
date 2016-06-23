package com.github.liuxboy.harbour.simulation.domain.biz;

import com.github.liuxboy.harbour.simulation.common.constant.TimeEnum;

/**
 * <p>Title: Berth</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/13 22:47</p>
 * <p>Description: 仿真时间设置 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
public class SimulationTime {
    //id
    private int id;
    //仿真时间总长
    private int simulationTimeOut = 1;
    //仿真时间总长---单位s
    private TimeEnum timeOutUnit;
    //仿真时间步长
    private int simulationTimeStep = 1;
    //仿真时间步长---单位s
    private TimeEnum timeStepUnit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TimeEnum getTimeOutUnit() {
        return timeOutUnit;
    }

    public void setTimeOutUnit(TimeEnum timeOutUnit) {
        this.timeOutUnit = timeOutUnit;
    }

    public TimeEnum getTimeStepUnit() {
        return timeStepUnit;
    }

    public void setTimeStepUnit(TimeEnum timeStepUnit) {
        this.timeStepUnit = timeStepUnit;
    }

    public long getSimulationTimeOut() {
        return simulationTimeOut;
    }

    public void setSimulationTimeOut(int simulationTimeOut) {
        this.simulationTimeOut = simulationTimeOut;
    }

    public int getSimulationTimeStep() {
        return simulationTimeStep;
    }

    public void setSimulationTimeStep(int simulationTimeStep) {
        this.simulationTimeStep = simulationTimeStep;
    }

    @Override
    public String toString() {
        final StringBuilder stbd = new StringBuilder("SimulationTime{");
        stbd.append("\"id\":").append(id);
        stbd.append(",\"simulationTimeOut\":").append(simulationTimeOut);
        stbd.append(",\"timeOutUnit\":").append(timeOutUnit);
        stbd.append(",\"simulationTimeStep\":").append(simulationTimeStep);
        stbd.append(",\"timeStepUnit\":").append(timeStepUnit);
        stbd.append('}');
        stbd.append(super.toString());
        return stbd.toString();
    }
}
