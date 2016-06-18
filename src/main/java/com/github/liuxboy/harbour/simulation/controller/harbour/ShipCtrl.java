package com.github.liuxboy.harbour.simulation.controller.harbour;

import com.github.liuxboy.harbour.simulation.common.util.AjaxResultUtil;
import com.github.liuxboy.harbour.simulation.domain.biz.Berth;
import com.github.liuxboy.harbour.simulation.domain.biz.Point;
import com.github.liuxboy.harbour.simulation.domain.biz.Ship;
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
 * <p>Title: ShipCtrl</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/16 13:46</p>
 * <p>Description: 船舶设置拦截器 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/ship")
public class ShipCtrl {
    @Resource
    HttpServletRequest httpServletRequest;
    @Resource
    HttpSession httpSession;

    @RequestMapping(value = "/shipList")
    public String berthList() {
        httpServletRequest.setAttribute("shipList", httpSession.getAttribute("shipList"));
        return "/harbour/shipList";
    }

    @RequestMapping(value = "/toAddShip")
    public String toAddAnchorage() {
        return "/harbour/shipAdd";
    }

    @RequestMapping(value = "/doAdd")
    @ResponseBody
    public String berthList(@RequestBody Ship ship,
                            @RequestParam(value="x") double x,
                            @RequestParam(value="y") double y) {
        Object obj = httpSession.getAttribute("shipList");
        List<Ship> shipList = obj != null ? (List) obj : new ArrayList<Ship>();
        shipList.add(ship);
        httpSession.setAttribute("shipList", shipList);
        return AjaxResultUtil.success();
    }
}
