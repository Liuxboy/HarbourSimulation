package com.github.liuxboy.harbour.simulation.controller.harbour;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>Title: AnchorageCtrl</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/16 13:45</p>
 * <p>Description: 锚地设置拦截器 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
@Controller
public class AnchorageCtrl {
    @Resource
    HttpServletRequest httpServletRequest;

    @RequestMapping(value = "/anchorageList")
    public String berthList() {

        return "/harbour/anchorageList";
    }

}
