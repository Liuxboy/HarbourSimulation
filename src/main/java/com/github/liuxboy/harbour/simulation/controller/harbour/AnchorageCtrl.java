package com.github.liuxboy.harbour.simulation.controller.harbour;

import com.github.liuxboy.harbour.simulation.common.util.AjaxResultUtil;
import com.github.liuxboy.harbour.simulation.domain.biz.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    @Resource
    HttpSession httpSession;

    @RequestMapping(value = "/toList")
    public String toList() {
        httpServletRequest.setAttribute("anchorageList", httpSession.getAttribute("anchorageList"));
        return "/harbour/anchorageList";
    }

    @RequestMapping(value = "/toAdd")
    public String toAdd() {
        return "/harbour/anchorageAdd";
    }

    @RequestMapping(value = "/doAdd")
    @ResponseBody
    public String doAdd(@RequestParam(value="lx") double lx,
                        @RequestParam(value="ly") double ly,
                        @RequestParam(value="ux") double ux,
                        @RequestParam(value="uy") double uy) {
        Anchorage anchorage = new Anchorage();
        Point pointL = new Point(lx, ly);
        Point pointR = new Point(ux, uy);
        anchorage.setLowerLeftCorner(pointL);
        anchorage.setUpperRightCorner(pointR);
        Object obj = httpSession.getAttribute("anchorageList");
        List<Anchorage> anchorageList = obj != null ? (List) obj : new ArrayList<Anchorage>();
        anchorage.setId(anchorageList.size());
        anchorageList.add(anchorage);
        httpSession.setAttribute("anchorageList", anchorageList);
        return AjaxResultUtil.success();
    }

    @RequestMapping(value = "/showDetail/{id}")
    public String toAdd(@PathVariable("id") Integer id) {
        Object obj = httpSession.getAttribute("anchorageList");
        List<Anchorage> anchorageList = obj != null ? (List) obj : new ArrayList<Anchorage>();
        Anchorage anchorage = new Anchorage();
        if (id != null && !CollectionUtils.isEmpty(anchorageList)) {
            anchorage = anchorageList.get(id);
        }
        httpServletRequest.setAttribute("anchorage", anchorage);
        return "/harbour/anchorageDetail";
    }

    @RequestMapping(value = "/doUpdate")
    @ResponseBody
    public String doAdd(@RequestParam(value="lx") double lx,
                        @RequestParam(value="ly") double ly,
                        @RequestParam(value="ux") double ux,
                        @RequestParam(value="uy") double uy,
                        @RequestParam(value="id") int id) {
        Anchorage anchorage = new Anchorage();
        Point pointL = new Point(lx, ly);
        Point pointR = new Point(ux, uy);
        anchorage.setLowerLeftCorner(pointL);
        anchorage.setUpperRightCorner(pointR);
        anchorage.setId(id);
        Object obj = httpSession.getAttribute("anchorageList");
        List<Anchorage> anchorageList = obj != null ? (List) obj : new ArrayList<Anchorage>();
        anchorageList.set(anchorage.getId(), anchorage);
        httpSession.setAttribute("anchorageList", anchorageList);
        return AjaxResultUtil.success();
    }
}
