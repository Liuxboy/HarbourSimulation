package com.github.liuxboy.harbour.simulation.controller.harbour;

import com.github.liuxboy.harbour.simulation.common.util.Logger;
import com.github.liuxboy.harbour.simulation.common.util.LoggerFactory;
import com.github.liuxboy.harbour.simulation.domain.biz.*;
import com.github.liuxboy.harbour.simulation.service.HarbourSimulationService;
import org.apache.avalon.framework.service.ServiceException;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
        List<Anchorage> anchorageList = (List) httpSession.getAttribute("anchorageList");
        List<Channel> channelList = (List) httpSession.getAttribute("channelList");
        List<Berth> berthList = (List) httpSession.getAttribute("berthList");
        List<Ship> shipList = (List) httpSession.getAttribute("shipList");
        List<Traffic> trafficList = (List) httpSession.getAttribute("trafficList");
        List<SimulationTime> timeList = (List) httpSession.getAttribute("timeList");
        try {
            List<Result> resultList = harbourSimulationService.simulation(anchorageList, channelList, berthList, shipList, trafficList, timeList);
            httpServletRequest.setAttribute("resultList", resultList);
            httpServletRequest.setAttribute("flag", 1);
            logger.info("resultList:", resultList);
            Thread.sleep(5000 + RandomUtils.nextInt(10000));
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "/harbour/result";
    }
}
