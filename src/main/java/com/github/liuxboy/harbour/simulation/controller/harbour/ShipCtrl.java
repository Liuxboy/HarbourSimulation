package com.github.liuxboy.harbour.simulation.controller.harbour;

import com.github.liuxboy.harbour.simulation.common.constant.BigDecimalUtil;
import com.github.liuxboy.harbour.simulation.common.constant.ShipEnum;
import com.github.liuxboy.harbour.simulation.common.util.AjaxResultUtil;
import com.github.liuxboy.harbour.simulation.domain.biz.Ship;
import com.github.liuxboy.harbour.simulation.service.InitialService;
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
    @Resource
    InitialService initialService;

    @RequestMapping(value = "/toList")
    public String toList() {
        Object obj = httpSession.getAttribute("shipList");
        List<Ship> shipList = obj != null ? (List) obj : new ArrayList<Ship>();
        if (CollectionUtils.isEmpty(shipList)) {
            shipList = initialService.getShipList();
        }
        httpSession.setAttribute("shipList", shipList);
        return "/shipList";
    }

    @RequestMapping(value = "/toAdd")
    public String toAdd() {
        return "/shipAdd";
    }

    @RequestMapping(value = "/doAdd")
    @ResponseBody
    public String doAdd(@ModelAttribute("ship") Ship ship) {
        Object obj = httpSession.getAttribute("shipList");
        List<Ship> shipList = obj != null ? (List) obj : new ArrayList<Ship>();
        ship.setId(shipList.size());
        shipList.add(ship);
        httpSession.setAttribute("shipList", shipList);
        return AjaxResultUtil.success();
    }

    @RequestMapping(value = "/showDetail/{id}")
    public String showDetail(@PathVariable("id") int id) {
        Object obj = httpSession.getAttribute("shipList");
        List<Ship> shipList = obj != null ? (List) obj : new ArrayList<Ship>();
        Ship ship = new Ship();
        if (!CollectionUtils.isEmpty(shipList)) {
            ship = shipList.get(id);
        }
        httpServletRequest.setAttribute("ship", ship);
        return "/shipUpdate";
    }

    @RequestMapping(value = "/doUpdate")
    @ResponseBody
    public String doUpdate(@ModelAttribute("ship") Ship ship) {
        Object obj = httpSession.getAttribute("shipList");
        List<Ship> shipList = obj != null ? (List) obj : new ArrayList<Ship>();
        updateShipEnum(ship);
        shipList.set(ship.getId(), ship);
        httpSession.setAttribute("shipList", shipList);
        return AjaxResultUtil.success();
    }

    @RequestMapping(value = "/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable("id") int id) {
        Object obj = httpSession.getAttribute("shipList");
        List<Ship> shipList = obj != null ? (List) obj : new ArrayList<Ship>();
        if (!CollectionUtils.isEmpty(shipList)) {
            shipList.remove(id);
        }
        httpSession.setAttribute("shipList", shipList);
        return AjaxResultUtil.success();
    }

    private void updateShipEnum(Ship ship) {
        Object obj = httpSession.getAttribute("shipList");
        List<Ship> shipList = obj != null ? (List) obj : new ArrayList<Ship>();
        double totalLambda = 0.0;
        for (Ship tepShip : shipList) {
            if (tepShip.getId() == ship.getId())
                tepShip.setLambda(ship.getLambda());    //设置成新的lambda
            totalLambda += tepShip.getLambda();         //累加起来
        }
        for (Ship tempShip : shipList) {
            ShipEnum.valueOf(tempShip.getShipEnum().name()).setProportion(BigDecimalUtil.decimal4Double(tempShip.getLambda() / totalLambda));
        }
        ShipEnum.Container_Ship.setSection(ShipEnum.Container_Ship.getProportion());
        ShipEnum.Iron_Ore.setSection(BigDecimalUtil.decimal4Double(ShipEnum.Iron_Ore.getProportion() + ShipEnum.Container_Ship.getSection()));
        ShipEnum.Chemical_Oil.setSection(BigDecimalUtil.decimal4Double(ShipEnum.Chemical_Oil.getProportion() + ShipEnum.Iron_Ore.getSection()));
        ShipEnum.Crude_Oil.setSection(BigDecimalUtil.decimal4Double(ShipEnum.Crude_Oil.getProportion() + ShipEnum.Chemical_Oil.getSection()));
        ShipEnum.Coal.setSection(BigDecimalUtil.decimal4Double(ShipEnum.Coal.getProportion() + ShipEnum.Crude_Oil.getSection()));
        ShipEnum.Break_Bulk_Ship.setSection(1.0);
    }
}
