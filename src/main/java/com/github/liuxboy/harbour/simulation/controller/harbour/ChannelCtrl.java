package com.github.liuxboy.harbour.simulation.controller.harbour;

import com.github.liuxboy.harbour.simulation.common.util.AjaxResultUtil;
import com.github.liuxboy.harbour.simulation.common.util.Logger;
import com.github.liuxboy.harbour.simulation.common.util.LoggerFactory;
import com.github.liuxboy.harbour.simulation.domain.biz.Channel;
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
 * <p>Title: ChannelCtrl</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/8 16:33</p>
 * <p>Description: 航道设置拦截器 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/channel")
public class ChannelCtrl {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    HttpServletRequest httpServletRequest;
    @Resource
    HttpSession httpSession;
    @Resource
    InitialService initialService;

    @RequestMapping(value = "/toList")
    public String toList() {
        Object obj = httpSession.getAttribute("channelList");
        List<Channel> channelList = obj != null ? (List) obj : new ArrayList<Channel>();
        if (CollectionUtils.isEmpty(channelList)) {
            channelList = initialService.getChannelList();
        }
        httpSession.setAttribute("channelList", channelList);
        return "/harbour/channelList";
    }

    @RequestMapping(value = "/toAdd")
    public String toAdd() {
        return "/harbour/channelAdd";
    }

    @RequestMapping(value = "/doAdd")
    @ResponseBody
    public String doAdd(@ModelAttribute("channel") Channel channel) {
        Object obj = httpSession.getAttribute("channelList");
        List<Channel> channelList = obj != null ? (List) obj : new ArrayList<Channel>();
        channel.setId(channelList.size());
        channelList.add(channel);
        httpSession.setAttribute("channelList", channelList);
        return AjaxResultUtil.success();
    }

    @RequestMapping(value = "/showDetail/{id}")
    public String showDetail(@PathVariable("id") int id) {
        Object obj = httpSession.getAttribute("channelList");
        List<Channel> channelList = obj != null ? (List) obj : new ArrayList<Channel>();
        Channel channel = new Channel();
        if (!CollectionUtils.isEmpty(channelList)) {
            channel = channelList.get(id);
        }
        httpServletRequest.setAttribute("channel", channel);
        return "/harbour/channelDetail";
    }

    @RequestMapping(value = "/doUpdate")
    @ResponseBody
    public String doUpdate(@ModelAttribute("channel") Channel channel) {
        Object obj = httpSession.getAttribute("channelList");
        List<Channel> channelList = obj != null ? (List) obj : new ArrayList<Channel>();
        channelList.set(channel.getId(), channel);
        httpSession.setAttribute("channelList", channelList);
        return AjaxResultUtil.success();
    }
}
