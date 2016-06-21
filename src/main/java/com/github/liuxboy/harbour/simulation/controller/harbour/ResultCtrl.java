package com.github.liuxboy.harbour.simulation.controller.harbour;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    @Resource
    HttpServletRequest httpServletRequest;
    @Resource
    HttpSession httpSession;

    @RequestMapping(value = "/toList")
    public String toList() {
        httpServletRequest.setAttribute("result", httpSession.getAttribute("channelList"));
        return "/harbour/result";
    }
}
