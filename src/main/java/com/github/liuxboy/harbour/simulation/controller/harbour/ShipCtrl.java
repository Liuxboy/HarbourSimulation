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
 * <p>Description: 船舶设置拦截器 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/ship")
public class ShipCtrl {
    @Resource
    HttpServletRequest httpServletRequest;

    @RequestMapping(value = "/shipList")
    public String berthList() {

        return "/harbour/shipList";
    }
}
