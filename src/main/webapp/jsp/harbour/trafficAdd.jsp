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
                    <option value="DANGER_PROHIBIT_ANCHOR">危险品船靠泊管制-大风</option>
                    <option value="CS_PROHIBIT_ANCHOR">集装箱船靠泊管制-大风</option>
                    <option value="BBS_PROHIBIT_ANCHOR">散杂货船靠泊管制-大风</option>
                    <option value="PROHIBIT_BOTH_TRAVEL_BAD_VISIBILITY">航行管制-能见度不良</option>
                    <option value="PROHIBIT_CONTRARY_TRAVEL">单向航行管制-特殊船舶通航</option>
                    <option value="PROHIBIT_BOTH_TRAVEL_FISH_BOAT_BLOCK">航行管制-渔船阻碍</option>
                    <option value="PROHIBIT_BOTH_TRAVEL_ACCIDENT">航行管制-事故险情</option>
                </select>
            </p>
            <div class="divider"/>
            <p>
                <label>管制开始时刻</label>
                <input name="startMon" type="text" class="required digits" maxlength="3"/>月
            </p>
            <p>
                <label style="font-color:#FFF;">&nbsp;</label>
                <input name="startDay" type="text" class="required digits" maxlength="3"/>日
            </p>
            <p>
                <label style="font-color:#FFF;">&nbsp;</label>
                <input name="startHor" type="text" class="required digits" maxlength="3"/>时
            </p>
            <p>
                <label style="font-color:#FFF;">&nbsp;</label>
                <input name="startMin" type="text" class="required digits" maxlength="3"/>分
            </p>
            <p>
                <label style="font-color:#FFF;">&nbsp;</label>
                <input name="startSec" type="text" class="required digits" maxlength="3"/>秒
            </p>
            <div class="divider"/>
            <p>
                <label>管制时长</label>
                <input name="trafficDuration" type="text" class="required digits" maxlength="10"/>
                <select id="timeEnum" name="timeEnum" type="text" readonly="readonly" class="required"
                        maxlength="20">
                    <option value="SEC">秒</option>
                    <option value="MIN">分</option>
                    <option value="HOR">时</option>
                    <option value="DAY">天</option>
                    <option value="WEK">周</option>
                    <option value="MON">月</option>
                    <option value="YER">年</option>
                </select>
            </p>
            <div class="divider"/>
            <p>
                <label>是否生效</label>
                <select id="status" name="status" type="text" class="required" maxlength="20">
                    <option value=0>无效</option>
                    <option value=1>生效</option>
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
