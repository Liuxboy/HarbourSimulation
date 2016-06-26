package com.github.liuxboy.harbour.simulation.controller.harbour;

import com.github.liuxboy.harbour.simulation.common.util.AjaxResultUtil;
import com.github.liuxboy.harbour.simulation.domain.biz.*;
import com.github.liuxboy.harbour.simulation.service.InitialService;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

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
    @Resource
    InitialService initialService;

    @RequestMapping(value = "/toList")
    public String toList() {
        Object obj = httpSession.getAttribute("anchorageList");
        List<Anchorage> anchorageList = obj != null ? (List) obj : new ArrayList<Anchorage>();
        if(CollectionUtils.isEmpty(anchorageList)) {
            anchorageList = initialService.getAnchorageList();
        }
        httpSession.setAttribute("anchorageList", anchorageList);
        return "/harbour/anchorageList";
    }

    @RequestMapping(value = "/toAdd")
    public String toAdd() {
        return "/harbour/anchorageAdd";
    }

    @RequestMapping(value = "/doAdd")
    @ResponseBody
    public String doAdd(@ModelAttribute("anchorage") Anchorage anchorage) {
        Object obj = httpServletRequest.getAttribute("anchorageList");
        List<Anchorage> anchorageList = obj != null ? (List) obj : new ArrayList<Anchorage>();
        anchorage.setId(anchorageList.size());
        anchorageList.add(anchorage);
        httpServletRequest.setAttribute("anchorageList", anchorageList);
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
        httpSession.setAttribute("anchorage", anchorage);
        return "/harbour/anchorageDetail";
    }

    @RequestMapping(value = "/doUpdate")
    @ResponseBody
    public String doUpdate(@ModelAttribute("anchorage") Anchorage anchorage) {
        Object obj = httpServletRequest.getAttribute("anchorageList");
        List<Anchorage> anchorageList = obj != null ? (List) obj : new ArrayList<Anchorage>();
        anchorageList.set(anchorage.getId(), anchorage);
        httpServletRequest.setAttribute("anchorageList", anchorageList);
        return AjaxResultUtil.success();
    }

    @RequestMapping(value = "/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable("id") int id) {
        Object obj = httpServletRequest.getAttribute("anchorageList");
        List<Anchorage> anchorageList = obj != null ? (List) obj : new ArrayList<Anchorage>();
        if (!CollectionUtils.isEmpty(anchorageList)) {
            anchorageList.remove(id);
        }
        httpServletRequest.setAttribute("anchorageList", anchorageList);
        return AjaxResultUtil.success();
    }
}
