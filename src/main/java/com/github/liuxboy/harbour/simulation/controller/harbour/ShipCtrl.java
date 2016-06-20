package com.github.liuxboy.harbour.simulation.controller.harbour;

import com.github.liuxboy.harbour.simulation.common.util.AjaxResultUtil;
import com.github.liuxboy.harbour.simulation.domain.biz.Berth;
import com.github.liuxboy.harbour.simulation.domain.biz.Channel;
import com.github.liuxboy.harbour.simulation.domain.biz.Point;
import com.github.liuxboy.harbour.simulation.domain.biz.Ship;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/toList")
    public String toList() {
        httpServletRequest.setAttribute("shipList", httpSession.getAttribute("shipList"));
        return "/harbour/shipList";
    }

    @RequestMapping(value = "/toAdd")
    public String toAdd() {
        return "/harbour/shipAdd";
    }

    @RequestMapping(value = "/doAdd")
    @ResponseBody
    public String doAdd(@RequestBody Ship ship,
                            @RequestParam(value="x") double x,
                            @RequestParam(value="y") double y) {
        Object obj = httpSession.getAttribute("shipList");
        List<Ship> shipList = obj != null ? (List) obj : new ArrayList<Ship>();
        ship.setId(shipList.size());
        shipList.add(ship);
        httpSession.setAttribute("shipList", shipList);
        return AjaxResultUtil.success();
    }

    @RequestMapping(value = "/showDetail/{id}")
    public String showDetail(@PathVariable("id") Integer id) {
        Object obj = httpSession.getAttribute("shipList");
        List<Ship> shipList = obj != null ? (List) obj : new ArrayList<Ship>();
        Ship ship = new Ship();
        if (id != null && !CollectionUtils.isEmpty(shipList)) {
            ship = shipList.get(id);
        }
        httpServletRequest.setAttribute("ship", ship);
        return "/harbour/shipUpdate";
    }

    @RequestMapping(value = "/doUpdate")
    public String doUpdate(@RequestBody Ship ship) {
        Object obj = httpSession.getAttribute("shipList");
        List<Ship> shipList = obj != null ? (List) obj : new ArrayList<Ship>();
        shipList.set(ship.getId(), ship);
        httpSession.setAttribute("shipList", shipList);
        return AjaxResultUtil.success();
    }
}
