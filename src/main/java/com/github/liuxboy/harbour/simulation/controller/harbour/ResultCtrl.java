package com.github.liuxboy.harbour.simulation.controller.harbour;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>Title: ResultCtrl</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/16 13:48</p>
 * <p>Description: 结果查询拦截器 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
@Controller
public class ResultCtrl {
    @Resource
    HttpServletRequest httpServletRequest;

    @RequestMapping(value = "/result")
    public String berthList() {

        return "/harbour/result";
    }
}
