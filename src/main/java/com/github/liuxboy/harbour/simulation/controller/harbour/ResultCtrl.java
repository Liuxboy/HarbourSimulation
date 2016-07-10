package com.github.liuxboy.harbour.simulation.controller.harbour;

import com.github.liuxboy.harbour.simulation.common.util.Logger;
import com.github.liuxboy.harbour.simulation.common.util.LoggerFactory;
import com.github.liuxboy.harbour.simulation.domain.biz.*;
import com.github.liuxboy.harbour.simulation.service.HarbourSimulationService;
import com.github.liuxboy.harbour.simulation.service.InitialService;
import org.apache.avalon.framework.service.ServiceException;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * <p>Title: ResultCtrl</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/21 11:02</p>
 * <p>Description: 结果拦截器 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/result")
public class ResultCtrl {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    HttpServletRequest httpServletRequest;
    @Resource
    HttpSession httpSession;
    @Resource
    private HarbourSimulationService harbourSimulationService;
    @Resource
    InitialService initialService;

    @RequestMapping(value = "/toList")
    public String toList(@RequestParam(value = "flag", required = false) String flag) {
        httpServletRequest.setAttribute("result", httpSession.getAttribute("channelList"));
        if ("start".equals(flag)) {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "/harbour/result";
    }


    @RequestMapping(value = "/start")
    public String start() {
        Object obj = httpSession.getAttribute("anchorageList");
        List<Anchorage> anchorageList = obj != null ? (List) obj : new ArrayList<Anchorage>();
        if(CollectionUtils.isEmpty(anchorageList)) {
            anchorageList = initialService.getAnchorageList();
        }
        Object obj1 = httpSession.getAttribute("allBerthList");
        List<Berth> allBerthList = obj1 != null ? (List) obj1 : new ArrayList<Berth>();
        if (CollectionUtils.isEmpty(allBerthList)) {
            allBerthList = initialService.getBerthList();
        }

        Object obj2 = httpSession.getAttribute("channelList");
        List<Channel> channelList = obj2 != null ? (List) obj2 : new ArrayList<Channel>();
        if (CollectionUtils.isEmpty(channelList)) {
            channelList = initialService.getChannelList();
        }

        Object obj3 = httpSession.getAttribute("shipList");
        List<Ship> shipList = obj3 != null ? (List) obj3 : new ArrayList<Ship>();
        if (CollectionUtils.isEmpty(shipList)) {
            shipList = initialService.getShipList();
        }

        Object obj4 = httpSession.getAttribute("trafficList");
        List<Traffic> trafficList = obj4 != null ? (List) obj4 : new ArrayList<Traffic>();
        if (CollectionUtils.isEmpty(trafficList)) {
            trafficList = initialService.getTrafficList();
        }
        Object obj5 = httpSession.getAttribute("timeList");
        List<SimulationTime> timeList = obj5 != null ? (List) obj5 : new ArrayList<SimulationTime>();
        if (CollectionUtils.isEmpty(timeList)) {
            timeList = initialService.getTimeList();
        }

        try {
            List<Result> resultList = harbourSimulationService.simulation(anchorageList, channelList, allBerthList, shipList, trafficList, timeList);
            httpServletRequest.setAttribute("resultList", resultList);
            httpServletRequest.setAttribute("flag", 1);
            SimulationTime simulationTime = timeList.get(0);
            int totalTime = 0;
            if (simulationTime != null) {
                totalTime = simulationTime.getTimeOut() * simulationTime.getTimeOutUnit().getTime();
            }
            Thread.sleep(totalTime / 3600);
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "/harbour/result";
    }
}
