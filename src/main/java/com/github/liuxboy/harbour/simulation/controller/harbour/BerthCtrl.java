package com.github.liuxboy.harbour.simulation.controller.harbour;

import com.github.liuxboy.harbour.simulation.common.util.AjaxResultUtil;
import com.github.liuxboy.harbour.simulation.domain.biz.Anchorage;
import com.github.liuxboy.harbour.simulation.domain.biz.Berth;
import com.github.liuxboy.harbour.simulation.domain.biz.Point;
import org.dom4j.swing.BranchTreeNode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String doAdd(@RequestBody Berth berth,
                        @RequestParam(value="x") double x,
                        @RequestParam(value="y") double y) {
        Point point = new Point(x, y);
        berth.setPoint(point);
        Object obj = httpSession.getAttribute("berthList");
        List<Berth> berthList = obj != null ? (List) obj : new ArrayList<Berth>();
        berth.setId(berthList.size());
        berthList.add(berth);
        httpSession.setAttribute("berthList", berthList);
        return AjaxResultUtil.success();
    }
}
