package com.github.liuxboy.harbour.simulation.controller.harbour;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>Title: SimulationCtrl</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/17 14:52</p>
 * <p>Description: 描述 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
@Controller
public class SimulationCtrl {
    @Resource
    HttpServletRequest httpServletRequest;

    @RequestMapping(value = "/simulation")
    public String berthList() {
        return "/harbour/simulation";
    }
}
