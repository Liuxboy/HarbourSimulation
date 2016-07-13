package com.github.liuxboy.harbour.simulation.controller.harbour;

import com.github.liuxboy.harbour.simulation.common.util.AjaxResultUtil;
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
 * <p>Title: TrafficCtrl</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/18 23:10</p>
 * <p>Description: 交通管制 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/traffic")
public class TrafficCtrl {
    @Resource
    HttpServletRequest httpServletRequest;
    @Resource
    HttpSession httpSession;
    @Resource
    InitialService initialService;

    @RequestMapping(value = "/toList")
    public String toList() {
        Object obj = httpSession.getAttribute("trafficList");
        List<Traffic> trafficList = obj != null ? (List) obj : new ArrayList<Traffic>();
        if (CollectionUtils.isEmpty(trafficList)) {
            trafficList = initialService.getTrafficList();
        }
        httpSession.setAttribute("trafficList", trafficList);
        return "/trafficList";
    }

    @RequestMapping(value = "/toAdd")
    public String toAdd() {
        return "/trafficAdd";
    }

    @RequestMapping(value = "/doAdd")
    @ResponseBody
    public String doAdd(@ModelAttribute("traffic") Traffic traffic) {
        Object obj = httpSession.getAttribute("trafficList");
        List<Traffic> trafficList = obj != null ? (List) obj : new ArrayList<Traffic>();
        traffic.setId(trafficList.size());
        trafficList.add(traffic);
        httpSession.setAttribute("trafficList", trafficList);
        return AjaxResultUtil.success();
    }

    @RequestMapping(value = "/showDetail/{id}")
    public String showDetail(@PathVariable("id") int id) {
        Object obj = httpSession.getAttribute("trafficList");
        List<Traffic> trafficList = obj != null ? (List) obj : new ArrayList<Traffic>();
        Traffic traffic = new Traffic();
        if (!CollectionUtils.isEmpty(trafficList)) {
            traffic = trafficList.get(id);
        }
        httpServletRequest.setAttribute("traffic", traffic);
        return "/trafficUpdate";
    }

    @RequestMapping(value = "/doUpdate")
    @ResponseBody
    public String doUpdate(@ModelAttribute("traffic") Traffic traffic) {
        Object obj = httpSession.getAttribute("trafficList");
        List<Traffic> trafficList = obj != null ? (List) obj : new ArrayList<Traffic>();
        trafficList.set(traffic.getId(), traffic);
        httpSession.setAttribute("trafficList", trafficList);
        return AjaxResultUtil.success();
    }

    @RequestMapping(value = "/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable("id") int id) {
        Object obj = httpSession.getAttribute("trafficList");
        List<Traffic> trafficList = obj != null ? (List) obj : new ArrayList<Traffic>();
        if (!CollectionUtils.isEmpty(trafficList)) {
            trafficList.remove(id);
        }
        httpServletRequest.setAttribute("trafficList", trafficList);
        return AjaxResultUtil.success();
    }
}
