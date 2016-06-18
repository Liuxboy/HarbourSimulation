package com.github.liuxboy.harbour.simulation.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: AjaxResultUtil</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/18 19:59</p>
 * <p>Description:  </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
public class AjaxResultUtil {

    public static String success() {
        Map<String, String> resultMap = new HashMap<String, String>();
        resultMap.put("statusCode", "200");
        resultMap.put("message", "操作失败");
        resultMap.put("callbackType", "closeCurrent");
        return JSONObject.toJSONString(resultMap);
    }

    public static String fail() {
        Map<String, String> resultMap = new HashMap<String, String>();
        resultMap.put("statusCode", "300");
        resultMap.put("message", "操作失败");
        resultMap.put("callbackType", "closeCurrent");
        return JSONObject.toJSONString(resultMap);
    }
}
