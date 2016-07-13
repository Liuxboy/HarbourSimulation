package com.github.liuxboy.harbour.simulation.controller.harbour;

import com.github.liuxboy.harbour.simulation.common.util.Logger;
import com.github.liuxboy.harbour.simulation.common.util.LoggerFactory;
import com.github.liuxboy.harbour.simulation.domain.biz.*;
import com.github.liuxboy.harbour.simulation.service.HarbourSimulationService;
import org.apache.avalon.framework.service.ServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>Title: SimulationCtrl</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/17 14:52</p>
 * <p>Description: 仿真描述 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/simulation")
public class SimulationCtrl {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    HttpServletRequest httpServletRequest;
    @Resource
    HttpSession httpSession;

    @RequestMapping(value = "/toList")
    public String toList() {
        httpServletRequest.setAttribute("resultList", httpSession.getAttribute("resultList"));
        return "/simulation";
    }
}
