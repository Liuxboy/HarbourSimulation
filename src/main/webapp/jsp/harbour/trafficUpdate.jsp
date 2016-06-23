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
            <input name="id" type="hidden" class="required" maxlength="50" style="width:180px"
                       value="${traffic.id}"/>
            <p>
                <label>管制类型</label>
                <select id="trafficEnum" name="trafficEnum" type="text" readonly="readonly" class="required"
                        maxlength="20">
                    <option value="CS_PROHIBIT_ANCHOR" <c:if test="${traffic.trafficEnum.typeCode == 0}">selected</c:if> >集装箱船靠泊管制</option>
                    <option value="BBS_PROHIBIT_ANCHOR" <c:if test="${traffic.trafficEnum.typeCode == 1}">selected</c:if> >散杂货船靠泊管制</option>
                    <option value="DANGER_PROHIBIT_ANCHOR" <c:if test="${traffic.trafficEnum.typeCode == 2}">selected</c:if> >危险品船靠泊管制</option>
                    <option value="PROHIBIT_BOTH_TRAVEL" <c:if test="${traffic.trafficEnum.typeCode == 3}">selected</c:if> >航行管制</option>
                    <option value="PROHIBIT_CONTRARY_TRAVEL" <c:if test="${traffic.trafficEnum.typeCode == 4}">selected</c:if> >单向航行管制</option>
                </select>
            </p>
            <div class="divider"/>
            <p>
                <label>管制时长</label>
                <input name="trafficDuration" type="text" class="required digits" maxlength="10"
                    value="${traffic.trafficDuration}"/>
                (单位：s)
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