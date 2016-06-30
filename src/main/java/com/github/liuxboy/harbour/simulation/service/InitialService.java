package com.github.liuxboy.harbour.simulation.service;

import com.github.liuxboy.harbour.simulation.domain.biz.*;

import java.util.List;

/**
 * <p>Title: InitialService</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/26 19:46</p>
 * <p>Description: 描述 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
public interface InitialService {
    public List<Anchorage> getAnchorageList();

    public List<Channel> getChannelList();

    public List<Berth> getBerthList();

    public List<Traffic> getTrafficList();

    public List<SimulationTime> getTimeList();

    public List<Ship> getShipList();
}
