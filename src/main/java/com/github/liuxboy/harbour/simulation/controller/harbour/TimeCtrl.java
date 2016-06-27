package com.github.liuxboy.harbour.simulation.controller.harbour;

import com.github.liuxboy.harbour.simulation.common.util.AjaxResultUtil;
import com.github.liuxboy.harbour.simulation.domain.biz.SimulationTime;
import com.github.liuxboy.harbour.simulation.domain.biz.Traffic;
import com.github.liuxboy.harbour.simulation.service.InitialService;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: ShipCtrl</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/16 13:46</p>
 * <p>Description: 时间设置 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/time")
public class TimeCtrl {
    @Resource
    HttpServletRequest httpServletRequest;
    @Resource
    HttpSession httpSession;
    @Resource
    InitialService initialService;

    @RequestMapping(value = "/toList")
    public String toList() {
        Object obj = httpSession.getAttribute("timeList");
        List<SimulationTime> timeList = obj != null ? (List) obj : new ArrayList<SimulationTime>();
        if (CollectionUtils.isEmpty(timeList)) {
            timeList = initialService.getTimeList();
        }
        httpSession.setAttribute("timeList", timeList);
        return "/harbour/timeList";
    }

    @RequestMapping(value = "/toAdd")
    public String toAdd() {
        return "/harbour/timeAdd";
    }

    @RequestMapping(value = "/doAdd")
    @ResponseBody
    public String doAdd(@ModelAttribute("simulationTime") SimulationTime simulationTime) {
        Object obj = httpSession.getAttribute("timeList");
        List<SimulationTime> timeList = obj != null ? (List) obj : new ArrayList<SimulationTime>();
        simulationTime.setId(timeList.size());
        timeList.add(simulationTime);
        httpSession.setAttribute("timeList", timeList);
        return AjaxResultUtil.success();
    }

    @RequestMapping(value = "/showDetail/{id}")
    public String showDetail(@PathVariable("id") int id) {
        Object obj = httpSession.getAttribute("timeList");
        List<SimulationTime> timeList = obj != null ? (List) obj : new ArrayList<SimulationTime>();
        SimulationTime simulationTime = new SimulationTime();
        if (!CollectionUtils.isEmpty(timeList)) {
            simulationTime = timeList.get(id);
        }
        httpServletRequest.setAttribute("simulationTime", simulationTime);
        return "/harbour/timeUpdate";
    }

    @RequestMapping(value = "/doUpdate")
    @ResponseBody
    public String doUpdate(@ModelAttribute("simulationTime") SimulationTime simulationTime) {
        Object obj = httpSession.getAttribute("timeList");
        List<SimulationTime> timeList = obj != null ? (List) obj : new ArrayList<SimulationTime>();
        timeList.set(simulationTime.getId(), simulationTime);
        httpSession.setAttribute("timeList", timeList);
        return AjaxResultUtil.success();
    }

    @RequestMapping(value = "/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable("id") int id) {
        Object obj = httpSession.getAttribute("timeList");
        List<SimulationTime> timeList = obj != null ? (List) obj : new ArrayList<SimulationTime>();
        if (!CollectionUtils.isEmpty(timeList)) {
            timeList.remove(id);
        }
        httpSession.setAttribute("timeList", timeList);
        return AjaxResultUtil.success();
    }
}
