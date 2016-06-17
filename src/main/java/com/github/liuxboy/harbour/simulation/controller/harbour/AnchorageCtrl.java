package com.github.liuxboy.harbour.simulation.controller.harbour;

import com.github.liuxboy.harbour.simulation.domain.biz.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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
@RequestMapping(value = "/anchorage")
public class AnchorageCtrl {
    @Resource
    HttpServletRequest httpServletRequest;

    @RequestMapping(value = "/anchorageList")
    public String berthList() {
        return "/harbour/anchorageList";
    }

    @RequestMapping(value = "/toAddAnchorage")
    public String toAddAnchorage() {
        return "/harbour/anchorageAdd";
    }

    @RequestMapping(value = "/doAdd")
    public String berthList(@RequestParam(value="lx") double lx,
                            @RequestParam(value="ly") double ly,
                            @RequestParam(value="ux") double ux,
                            @RequestParam(value="uy") double uy) {
        Anchorage anchorage = new Anchorage();
        Point pointL = new Point(lx, ly);
        Point pointR = new Point(ux, uy);
        anchorage.setLowerLeftCorner(pointL);
        anchorage.setUpperRightCorner(pointR);
        List<Anchorage> anchorageList = new ArrayList<Anchorage>();
        anchorageList.add(anchorage);
        httpServletRequest.setAttribute("anchorageList", anchorageList);
        return "/harbour/anchorageList";
    }
}
