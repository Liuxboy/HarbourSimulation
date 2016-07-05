<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%String root = request.getContextPath();%>
<head>
    <script src="<%=root %>/js/jquery.form.js" type="text/javascript"></script>
    <script src="<%=root %>/js/ajaxfileupload.js" type="text/javascript"></script>
</head>
<div class="pageContent">
    <form action="<%=root %>/harbour/traffic/doUpdate" method="post"
          onsubmit="return validateCallback(this,dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56">
            <input name="id" type="hidden" class="required" value="${traffic.id}"/>
            <p>
                <label>管制类型</label>
                <select id="trafficEnum" name="trafficEnum" type="text" readonly="readonly" class="required"
                        maxlength="20">
                    <option value="CS_PROHIBIT_ANCHOR"
                            <c:if test="${traffic.trafficEnum.typeCode == 0}">selected</c:if> >集装箱船靠泊管制
                    </option>
                    <option value="BBS_PROHIBIT_ANCHOR"
                            <c:if test="${traffic.trafficEnum.typeCode == 1}">selected</c:if> >散杂货船靠泊管制
                    </option>
                    <option value="DANGER_PROHIBIT_ANCHOR"
                            <c:if test="${traffic.trafficEnum.typeCode == 2}">selected</c:if> >危险品船靠泊管制
                    </option>
                    <option value="PROHIBIT_BOTH_TRAVEL"
                            <c:if test="${traffic.trafficEnum.typeCode == 3}">selected</c:if> >航行管制
                    </option>
                    <option value="PROHIBIT_CONTRARY_TRAVEL"
                            <c:if test="${traffic.trafficEnum.typeCode == 4}">selected</c:if> >单向航行管制
                    </option>
                </select>
            </p>
            <div class="divider"/>
            <p>
                <label>管制开始时刻</label>
                <input name="startMon" type="text" class="required digits" maxlength="3"
                       value="${traffic.startMon}"/>月
            </p>
            <p>
                <label style="font-color:#FFF;">&nbsp;</label>
                <input name="startDay" type="text" class="required digits" maxlength="3"
                       value="${traffic.startDay}"/>日
            </p>
            <p>
                <label style="font-color:#FFF;">&nbsp;</label>
                <input name="startHor" type="text" class="required digits" maxlength="3"
                       value="${traffic.startHor}"/>时
            </p>
            <p>
                <label style="font-color:#FFF;">&nbsp;</label>
                <input name="startMin" type="text" class="required digits" maxlength="3"
                       value="${traffic.startMin}"/>分
            </p>
            <p>
                <label style="font-color:#FFF;">&nbsp;</label>
                <input name="startSec" type="text" class="required digits" maxlength="3"
                       value="${traffic.startSec}"/>秒
            </p>
            <div class="divider"/>
            <p>
                <label>管制时长</label>
                <input name="trafficDuration" type="text" class="required" maxlength="10"
                       value="${traffic.trafficDuration}"/>
                <select id="timeStepUnit" name="timeStepUnit" type="text" readonly="readonly" class="required"
                        maxlength="20">
                    <option value="SEC"
                            <c:if test="${traffic.timeEnum.unit eq '秒'}">selected</c:if> >秒
                    </option>
                    <option value="MIN"
                            <c:if test="${traffic.timeEnum.unit eq '分'}">selected</c:if> >分
                    </option>
                    <option value="HOR"
                            <c:if test="${traffic.timeEnum.unit eq '时'}">selected</c:if> >时
                    </option>
                    <option value="DAY"
                            <c:if test="${traffic.timeEnum.unit eq '天'}">selected</c:if> >天
                    </option>
                    <option value="WEK"
                            <c:if test="${traffic.timeEnum.unit eq '周'}">selected</c:if> >周
                    </option>
                    <option value="MON"
                            <c:if test="${traffic.timeEnum.unit eq '月'}">selected</c:if> >月
                    </option>
                    <option value="YER"
                            <c:if test="${traffic.timeEnum.unit eq '年'}">selected</c:if> >年
                    </option>
                </select>
            </p>
            <div class="divider"/>
            <p>
                <label>是否生效</label>
                <select id="status" name="status" type="text" readonly="readonly" class="required"
                        maxlength="20">
                    <option value=0
                            <c:if test="${traffic.status==0}">selected</c:if> >无效
                    </option>
                    <option value=1
                            <c:if test="${traffic.status==1}">selected</c:if> >生效
                    </option>
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