package com.github.liuxboy.harbour.simulation.controller;

import com.github.liuxboy.harbour.simulation.domain.biz.Anchorage;
import com.github.liuxboy.harbour.simulation.domain.biz.Channel;
import com.github.liuxboy.harbour.simulation.domain.biz.Point;
import com.github.liuxboy.harbour.simulation.domain.biz.SimulationTime;
import com.sun.javafx.collections.MappingChange;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: Berth</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/13 21:57</p>
 * <p>Description: 描述 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
public class HarborCtrl {
    //锚地
    @Resource
    private Anchorage anchorage;
    @Resource
    private Channel normalChannel;
    @Resource
    private Channel deepChannel;
    @Resource
    private SimulationTime simulationTime;
    @Resource
    private HttpServletRequest httpServletRequest;
    @Resource
    private HttpSession httpSession;

    @RequestMapping(value = "/config", method = RequestMethod.POST)
    @ResponseBody
    public String config() {
        Map<String, Object> configMap = new HashMap<String, Object>();

        anchorage.setLowerLeftCorner(new Point(50.0, 0.0));
        anchorage.setUpperRightCorner(new Point(100.0, 100.0));
        normalChannel.setLowerLeftCorner(new Point(0.0, 10.0));
        normalChannel.setUpperRightCorner(new Point(50.0, 90.0));
        deepChannel.setLowerLeftCorner(new Point(100.0, 2.0));
        deepChannel.setUpperRightCorner(new Point(200.0, 70.0));
        simulationTime.setSimulationTimeOut(24*60*60);
        simulationTime.setSimulationTimeStep(60*60);

        configMap.put("anchorage", anchorage);
        configMap.put("normalChannel", normalChannel);
        configMap.put("deepChannel", deepChannel);
        configMap.put("simulationTime", simulationTime);
        httpSession.setAttribute(httpSession.getId(), configMap);
        return "config";
    }

    @RequestMapping(value = "start", method = RequestMethod.POST)
    @ResponseBody
    public String start() {
        System.out.println("锚地左下角：" + anchorage.getLowerLeftCorner());
        System.out.println("锚地右上角：" + anchorage.getUpperRightCorner());
        System.out.println("普通航道左下角：" + normalChannel.getLowerLeftCorner());
        System.out.println("普通航道右上角：" + normalChannel.getUpperRightCorner());
        System.out.println("深水航道左下角：" + deepChannel.getLowerLeftCorner());
        System.out.println("深水航道右上角：" + deepChannel.getUpperRightCorner());
        System.out.println("仿真时间设置：" + simulationTime);

        System.out.println("session中保存参数：" + httpSession.getAttribute(httpSession.getId()));
        return "start";
    }
}
