package com.github.liuxboy.harbour.simulation.controller;

import com.github.liuxboy.harbour.simulation.common.util.Logger;
import com.github.liuxboy.harbour.simulation.common.util.LoggerFactory;
import com.github.liuxboy.harbour.simulation.domain.PageParam;
import com.github.liuxboy.harbour.simulation.service.HarbourSimulationService;
import org.apache.avalon.framework.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Title: ConfigCtrl</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/8 16:33</p>
 * <p>Description: 仿真参数设置拦截器 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
@Controller
public class HarbourCtrl {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HarbourSimulationService harbourSimulationService;

    @RequestMapping(value = "/config")
    public String config() {
        return "/harbour/list";
    }

    @RequestMapping(value = "/begin")
    public String begin() {

        return "/harbour/list";
    }

    @RequestMapping(value = "/pause")
    public String pause() {

        return "/harbour/list";
    }

    @RequestMapping(value = "/stop")
    public String stop() {

        return "/harbour/list";
    }
}
