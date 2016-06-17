package com.github.liuxboy.harbour.simulation.controller.harbour;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>Title: BerthCtrl</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/15 20:56</p>
 * <p>Description: 码头设置拦截器 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/berth")
public class BerthCtrl {
    @Resource
    HttpServletRequest httpServletRequest;

    @RequestMapping(value = "/berthList")
    public String berthList() {

        return "/harbour/berthList";
    }
}
