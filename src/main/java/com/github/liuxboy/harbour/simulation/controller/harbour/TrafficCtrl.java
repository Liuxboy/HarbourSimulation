package com.github.liuxboy.harbour.simulation.controller.harbour;

import com.github.liuxboy.harbour.simulation.common.constant.TrafficEnum;
import com.github.liuxboy.harbour.simulation.common.util.AjaxResultUtil;
import com.github.liuxboy.harbour.simulation.domain.biz.Ship;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "/toList")
    public String toList() {
        httpServletRequest.setAttribute("trafficList", httpSession.getAttribute("trafficList"));
        return "/harbour/trafficList";
    }

    @RequestMapping(value = "/toAdd")
    public String toAdd() {
        return "/harbour/trafficAdd";
    }

    @RequestMapping(value = "/doAdd")
    @ResponseBody
    public String doAdd(@RequestBody TrafficEnum trafficEnum) {
        Object obj = httpSession.getAttribute("trafficList");
        List<TrafficEnum> trafficList = obj != null ? (List) obj : new ArrayList<Ship>();
        trafficList.add(trafficEnum);
        httpSession.setAttribute("trafficList", trafficList);
        return AjaxResultUtil.success();
    }
}