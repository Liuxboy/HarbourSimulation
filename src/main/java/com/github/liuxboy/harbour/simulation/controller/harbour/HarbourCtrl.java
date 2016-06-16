package com.github.liuxboy.harbour.simulation.controller.harbour;

import com.github.liuxboy.harbour.simulation.common.util.Logger;
import com.github.liuxboy.harbour.simulation.common.util.LoggerFactory;
import com.github.liuxboy.harbour.simulation.domain.biz.*;
import com.github.liuxboy.harbour.simulation.service.HarbourSimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
    private TimeConfig timeConfig;
    @RequestMapping(value = "/channelList")
    public String channelList() {
        Map<String, Object> configMap = new HashMap<String, Object>();
        anchorage.setLowerLeftCorner(new Point(50.0, 0.0));
        anchorage.setUpperRightCorner(new Point(100.0, 100.0));
        normalChannel.setLowerLeftCorner(new Point(0.0, 10.0));
        normalChannel.setUpperRightCorner(new Point(50.0, 90.0));
        deepChannel.setLowerLeftCorner(new Point(100.0, 2.0));
        deepChannel.setUpperRightCorner(new Point(200.0, 70.0));
        timeConfig.setSimulationTimeOut(24*60*60);
        timeConfig.setSimulationTimeStep(60*60);

        configMap.put("anchorage", anchorage);
        configMap.put("normalChannel", normalChannel);
        configMap.put("deepChannel", deepChannel);
        configMap.put("simulationTime", timeConfig);
        request.setAttribute(request.getSession().getId(), configMap);
        return "/harbour/channelList";
    }

    @RequestMapping(value = "/start")
    public String start() {
        System.out.println("普通航道左下角：" + normalChannel.getLowerLeftCorner());
        System.out.println("普通航道右上角：" + normalChannel.getUpperRightCorner());
        System.out.println("深水航道左下角：" + deepChannel.getLowerLeftCorner());
        System.out.println("深水航道右上角：" + deepChannel.getUpperRightCorner());
        System.out.println("仿真时间设置：" + timeConfig);
        Result totalResult = new Result();
        //仿真步骤
        int steps = (int) timeConfig.getSimulationTimeOut() / timeConfig.getSimulationTimeStep();
        for (int i = 0; i < steps; i++) {
            //TODO 在这里完成各种参数的计算
        }
        totalResult.setAvgWaitChannelTime("");
        totalResult.setAvgWaitBerthTime("");
        totalResult.setAvgInHarborTime("");
        totalResult.setAvgOnBerthTime("");
        totalResult.setAwtAstIndex("");
        totalResult.setBerthUtilizationRatio("");
        Map configMap =(HashMap) request.getAttribute(request.getSession().getId());
        configMap.put("result", totalResult);
        request.setAttribute(request.getSession().getId(), configMap);
        System.out.println("session中保存参数：" + configMap);
        return "/harbour/list";
    }
}
