package com.github.liuxboy.harbour.simulation.controller.harbour;

import com.github.liuxboy.harbour.simulation.common.constant.PassRuleEnum;
import com.github.liuxboy.harbour.simulation.domain.biz.PassRule;
import com.github.liuxboy.harbour.simulation.service.InitialService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: PassCtrl</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/21 23:01</p>
 * <p>Description: 通航规则 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/pass")
public class PassCtrl {
    @Resource
    HttpServletRequest httpServletRequest;
    @Resource
    HttpSession httpSession;
    @Resource
    InitialService initialService;

    @RequestMapping(value = "/toList")
    public String toList() {
        Object obj = httpSession.getAttribute("passRuleList");
        List<PassRule> passRuleList = obj != null ? (List) obj : new ArrayList<PassRule>();
        if (CollectionUtils.isEmpty(passRuleList)) {
            passRuleList = initialService.passRuleList();
        }
        httpSession.setAttribute("passRuleList", passRuleList);
        return "/passList";
    }
}
