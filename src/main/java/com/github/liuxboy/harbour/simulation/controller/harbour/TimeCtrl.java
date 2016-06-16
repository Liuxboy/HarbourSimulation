package com.github.liuxboy.harbour.simulation.controller.harbour;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
public class TimeCtrl {
    @Resource
    HttpServletRequest httpServletRequest;

    @RequestMapping(value = "/timeConfig")
    public String berthList() {

        return "/harbour/timeConfig";
    }
}
