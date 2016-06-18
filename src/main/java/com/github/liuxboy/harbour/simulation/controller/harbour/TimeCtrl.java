package com.github.liuxboy.harbour.simulation.controller.harbour;

import com.github.liuxboy.harbour.simulation.common.util.AjaxResultUtil;
import com.github.liuxboy.harbour.simulation.domain.biz.Ship;
import com.github.liuxboy.harbour.simulation.domain.biz.TimeConfig;
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

    @RequestMapping(value = "/timeList")
    public String berthList() {
        httpServletRequest.setAttribute("timeList", httpSession.getAttribute("timeList"));
        return "/harbour/timeList";
    }

    @RequestMapping(value = "/toAddTime")
    public String toAddAnchorage() {
        return "/harbour/timeAdd";
    }

    @RequestMapping(value = "/doAdd")
    @ResponseBody
    public String berthList(@RequestBody TimeConfig timeConfig) {
        Object obj = httpSession.getAttribute("timeList");
        List<TimeConfig> timeList = obj != null ? (List) obj : new ArrayList<TimeConfig>();
        timeList.add(timeConfig);
        httpSession.setAttribute("timeList", timeList);
        return AjaxResultUtil.success();
    }
}
