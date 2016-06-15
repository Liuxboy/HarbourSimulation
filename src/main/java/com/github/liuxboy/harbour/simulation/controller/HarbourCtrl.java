package com.github.liuxboy.harbour.simulation.controller;

import com.github.liuxboy.harbour.simulation.common.util.Logger;
import com.github.liuxboy.harbour.simulation.common.util.LoggerFactory;
import com.github.liuxboy.harbour.simulation.domain.PageParam;
import com.github.liuxboy.harbour.simulation.domain.biz.*;
import com.github.liuxboy.harbour.simulation.service.HarbourSimulationService;
import org.apache.avalon.framework.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: ConfigCtrl</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/8 16:33</p>
 * <p>Description: 仿真参数设置拦截器 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
@Controller
public class HarbourCtrl {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HarbourSimulationService harbourSimulationService;
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
    private HttpSession httpSession;

    @RequestMapping(value = "/channelList")
    public String channelList() {
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
        return "/harbour/channelList";
    }

    @RequestMapping(value = "/start")
    public String start() {
        System.out.println("锚地左下角：" + anchorage.getLowerLeftCorner());
        System.out.println("锚地右上角：" + anchorage.getUpperRightCorner());
        System.out.println("普通航道左下角：" + normalChannel.getLowerLeftCorner());
        System.out.println("普通航道右上角：" + normalChannel.getUpperRightCorner());
        System.out.println("深水航道左下角：" + deepChannel.getLowerLeftCorner());
        System.out.println("深水航道右上角：" + deepChannel.getUpperRightCorner());
        System.out.println("仿真时间设置：" + simulationTime);
        Result totalResult = new Result();
        //仿真步骤
        int steps = (int) simulationTime.getSimulationTimeOut() / simulationTime.getSimulationTimeStep();
        for (int i = 0; i < steps; i++) {
            //TODO 在这里完成各种参数的计算
        }
        totalResult.setAvgWaitChannelTime("");
        totalResult.setAvgWaitBerthTime("");
        totalResult.setAvgInHarborTime("");
        totalResult.setAvgOnBerthTime("");
        totalResult.setAwtAstIndex("");
        totalResult.setBerthUtilizationRatio("");
        Map configMap =(HashMap) httpSession.getAttribute(httpSession.getId());
        configMap.put("result", totalResult);
        httpSession.setAttribute(httpSession.getId(), configMap);
        System.out.println("session中保存参数：" + httpSession.getAttribute(httpSession.getId()));
        return "/harbour/list";
    }

    @RequestMapping(value = "/pause")
    public String pause() {

        return "/harbour/list";
    }

    @RequestMapping(value = "/stop")
    public String stop() {

        return "/harbour/list";
    }
}
