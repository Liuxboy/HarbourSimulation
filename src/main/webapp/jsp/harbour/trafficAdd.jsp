<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%String root = request.getContextPath();%>
<div class="pageContent">
    <form action="<%=root %>/harbour/traffic/doAdd" method="post"
          onsubmit="return validateCallback(this , dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56">
            <p>
                <label>管制类型</label>
                <select id="trafficEnum" name="trafficEnum" type="text" readonly="readonly" class="required"
                        maxlength="20">
                    <option value="CS_PROHIBIT_ANCHOR">集装箱船靠泊管制</option>
                    <option value="BBS_PROHIBIT_ANCHOR">散杂货船靠泊管制</option>
                    <option value="DANGER_PROHIBIT_ANCHOR">危险品船靠泊管制</option>
                    <option value="PROHIBIT_BOTH_TRAVEL">航行管制</option>
                    <option value="PROHIBIT_CONTRARY_TRAVEL">单向航行管制</option>
                </select>
            </p>
            <div class="divider"/>
            <p>
                <label>管制时长</label>
                <input name="trafficDuration" type="text" class="required digits" maxlength="10"/>
                <select id="timeStepUnit" name="timeUnit" type="text" readonly="readonly" class="required"
                        maxlength="20">
                    <option value="1">秒</option>
                    <option value="60">分</option>
                    <option value="3600">时</option>
                </select>
            </p>
        </div>
        <div class="formBar">
            <ul>
                <li>
                    <div class="buttonActive">
                        <div class="buttonContent">
                            <button type="submit">保存</button>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="button">
                        <div class="buttonContent">
                            <button type="button" class="close">取消</button>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </form>
</div>
