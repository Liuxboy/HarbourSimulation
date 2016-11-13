package com.github.liuxboy.harbour.simulation.controller.harbour;

import com.github.liuxboy.harbour.simulation.aspect.LogMonitor;
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
@LogMonitor
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
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        httpSession.setAttribute("anchorageList", anchorageList);
        return "/anchorageList";
    }

    @RequestMapping(value = "/toAdd")
    public String toAdd() {
        return "anchorageAdd";
    }

    @RequestMapping(value = "/doAdd")
    @ResponseBody
    public String doAdd(@ModelAttribute("anchorage") Anchorage anchorage) {
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
        return "/anchorageDetail";
    }

    @RequestMapping(value = "/doUpdate")
    @ResponseBody
    public String doUpdate(@ModelAttribute("anchorage") Anchorage anchorage) {
        Object obj = httpSession.getAttribute("anchorageList");
        List<Anchorage> anchorageList = obj != null ? (List) obj : new ArrayList<Anchorage>();
        anchorageList.set(anchorage.getId(), anchorage);
        httpSession.setAttribute("anchorageList", anchorageList);
        return AjaxResultUtil.success();
    }

    @RequestMapping(value = "/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable("id") int id) {
        Object obj = httpSession.getAttribute("anchorageList");
        List<Anchorage> anchorageList = obj != null ? (List) obj : new ArrayList<Anchorage>();
        if (!CollectionUtils.isEmpty(anchorageList)) {
            anchorageList.remove(id);
        }
        httpSession.setAttribute("anchorageList", anchorageList);
        return AjaxResultUtil.success();
    }
    private void test(){
        System.out.println("kkk");
    }
}
