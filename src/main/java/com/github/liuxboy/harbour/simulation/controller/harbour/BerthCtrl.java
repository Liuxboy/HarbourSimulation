package com.github.liuxboy.harbour.simulation.controller.harbour;

import com.github.liuxboy.harbour.simulation.common.util.AjaxResultUtil;
import com.github.liuxboy.harbour.simulation.domain.biz.Anchorage;
import com.github.liuxboy.harbour.simulation.domain.biz.Berth;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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
    @Resource
    HttpSession httpSession;

    @RequestMapping(value = "/toList")
    public String toList() {
        httpServletRequest.setAttribute("berthList", httpSession.getAttribute("berthList"));
        return "/harbour/berthList";
    }

    @RequestMapping(value = "/toAdd")
    public String toAdd() {
        return "/harbour/berthAdd";
    }

    @RequestMapping(value = "/doAdd")
    @ResponseBody
    public String doAdd(@ModelAttribute("berth") Berth berth) {
        Object obj = httpSession.getAttribute("berthList");
        List<Berth> berthList = obj != null ? (List) obj : new ArrayList<Berth>();
        berth.setId(berthList.size());
        berthList.add(berth);
        httpSession.setAttribute("berthList", berthList);
        return AjaxResultUtil.success();
    }

    @RequestMapping(value = "/showDetail/{id}")
    public String toAdd(@PathVariable("id") int id) {
        Object obj = httpSession.getAttribute("berthList");
        List<Berth> berthList = obj != null ? (List) obj : new ArrayList<Berth>();
        Berth berth = new Berth();
        if (!CollectionUtils.isEmpty(berthList)) {
            berth = berthList.get(id);
        }
        httpServletRequest.setAttribute("berth", berth);
        return "/harbour/berthUpdate";
    }

    @RequestMapping(value = "/doUpdate")
    @ResponseBody
    public String doUpdate(@ModelAttribute("berth") Berth berth) {
        Object obj = httpSession.getAttribute("berthList");
        List<Berth> berthList = obj != null ? (List) obj : new ArrayList<Berth>();
        berthList.set(berth.getId(), berth);
        httpSession.setAttribute("berthList", berthList);
        return AjaxResultUtil.success();
    }

    @RequestMapping(value = "/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable("id") int id) {
        Object obj = httpSession.getAttribute("berthList");
        List<Berth> berthList = obj != null ? (List) obj : new ArrayList<Berth>();
        if (!CollectionUtils.isEmpty(berthList)) {
            berthList.remove(id);
        }
        httpServletRequest.setAttribute("berthList", berthList);
        return AjaxResultUtil.success();
    }
}
