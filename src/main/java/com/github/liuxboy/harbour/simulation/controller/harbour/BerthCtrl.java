package com.github.liuxboy.harbour.simulation.controller.harbour;

import com.github.liuxboy.harbour.simulation.common.util.AjaxResultUtil;
import com.github.liuxboy.harbour.simulation.domain.PageParam;
import com.github.liuxboy.harbour.simulation.domain.biz.Berth;
import com.github.liuxboy.harbour.simulation.service.InitialService;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
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
    @Resource
    InitialService initialService;

    @RequestMapping(value = "/toList")
    public String toList(@ModelAttribute("pageParam") PageParam pageParam) {
        List<Berth> allBerthList = getAllBerthList();
        if (CollectionUtils.isEmpty(allBerthList)) {
            allBerthList = initialService.getBerthList();
            initialList(allBerthList);
        }
        pageParam.setTotalCount(allBerthList.size());
        int beginIndex = (pageParam.getPageNum() - 1) * pageParam.getPageSize();
        int endIndex = pageParam.getPageNum() * pageParam.getPageSize();
        endIndex = endIndex <= pageParam.getTotalCount() ? endIndex : pageParam.getTotalCount();
        httpSession.setAttribute("pageParam", pageParam);
        httpSession.setAttribute("berthList", allBerthList.subList(beginIndex, endIndex));
        return "/harbour/berthList";
    }

    @RequestMapping(value = "/toAdd")
    public String toAdd() {
        return "/harbour/berthAdd";
    }

    @RequestMapping(value = "/doAdd")
    @ResponseBody
    public String doAdd(@ModelAttribute("berth") Berth berth,
                        @ModelAttribute("pageParam") PageParam pageParam) {
        List<Berth> allBerthList = getAllBerthList();
        berth.setId(allBerthList.size());
        allBerthList.add(berth);
        httpSession.setAttribute("pageParam", pageParam);
        httpSession.setAttribute("allBerthList", allBerthList);
        return AjaxResultUtil.success();
    }

    @RequestMapping(value = "/showDetail/{id}")
    public String toAdd(@PathVariable("id") int id) {
        List<Berth> allBerthList = getAllBerthList();
        Berth berth = new Berth();
        if (!CollectionUtils.isEmpty(allBerthList)) {
            berth = allBerthList.get(id);
        }
        httpServletRequest.setAttribute("berth", berth);
        return "/harbour/berthUpdate";
    }

    @RequestMapping(value = "/doUpdate")
    @ResponseBody
    public String doUpdate(@ModelAttribute("berth") Berth berth,
                           @ModelAttribute("pageParam") PageParam pageParam) {
        List<Berth> allBerthList = getAllBerthList();
        allBerthList.set(berth.getId(), berth);
        httpSession.setAttribute("allBerthList", allBerthList);
        httpSession.setAttribute("pageParam", pageParam);
        return AjaxResultUtil.success();
    }

    @RequestMapping(value = "/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable("id") int id) {
        List<Berth> allBerthList = getAllBerthList();
        if (!CollectionUtils.isEmpty(allBerthList)) {
            allBerthList.remove(id);
        }
        httpSession.setAttribute("allBerthList", allBerthList);
        return AjaxResultUtil.success();
    }

    private void initialList(List<Berth> allBerthList) {
        if (!CollectionUtils.isEmpty(allBerthList)) {
            httpSession.setAttribute("allBerthList", allBerthList);
        }
    }

    private List<Berth> getAllBerthList() {
        Object obj = httpSession.getAttribute("allBerthList");
        return obj != null ? (List) obj : new ArrayList<Berth>();
    }
}
