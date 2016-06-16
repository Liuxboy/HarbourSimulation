package com.github.liuxboy.harbour.simulation.domain.biz;

import org.springframework.stereotype.Component;

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
@Component
public class TimeConfig {
    //仿真时间总长，单位s
    private long simulationTimeOut = 60*60;
    //仿真时间步长，单位s
    private int simulationTimeStep = 60;

    public long getSimulationTimeOut() {
        return simulationTimeOut;
    }

    public void setSimulationTimeOut(long simulationTimeOut) {
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
        return "SimulationTime{" +
                "simulationTimeOut=" + simulationTimeOut +
                ", simulationTimeStep=" + simulationTimeStep +
                '}';
    }
}
