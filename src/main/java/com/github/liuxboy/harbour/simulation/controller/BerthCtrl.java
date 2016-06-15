package com.github.liuxboy.harbour.simulation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: BerthCtrl</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/15 20:56</p>
 * <p>Description: 描述 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
@Controller
public class BerthCtrl {
    @Resource
    private HttpSession httpSession;

    @RequestMapping(value = "/berthList")
    public String berthList(HttpServletRequest httpServletRequest) {
        HttpSession httpSession1 = httpServletRequest.getSession();
        Map<String, Object> configMap =  (Map)httpSession.getAttribute(httpSession.getId());
        return "/harbour/berthList";
    }
}
