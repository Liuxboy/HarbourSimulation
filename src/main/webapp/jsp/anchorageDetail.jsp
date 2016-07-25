<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%String root = request.getContextPath();%>
<head>
    <script src="<%=root %>/js/jquery.form.js" type="text/javascript"></script>
    <script src="<%=root %>/js/ajaxfileupload.js" type="text/javascript"></script>
</head>
<div class="pageContent">
   <form action="<%=root %>/harbour/anchorage/doUpdate" method="post" onsubmit="return validateCallback(this,dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56">
            <input type="hidden" id="id" name="id" value="${anchorage.id}">
            <p>
                <label>锚地</label>
                <select id="anchorageEnum" name="anchorageEnum" type="text" readonly="readonly" class="required"
                        maxlength="20">
                    <option value="North" <c:if test="${anchorage.anchorageEnum.typeCode == 0}">selected</c:if> >北锚地</option>
                    <option value="South" <c:if test="${anchorage.anchorageEnum.typeCode == 1}">selected</c:if> >南锚地</option>
                    <option value="Ore" <c:if test="${anchorage.anchorageEnum.typeCode == 2}">selected</c:if> >矿石锚地</option>
                    <option value="Oil" <c:if test="${anchorage.anchorageEnum.typeCode == 3}">selected</c:if> >油轮锚地</option>
                    <option value="QiLi" <c:if test="${anchorage.anchorageEnum.typeCode == 4}">selected</c:if> >七里锚地</option>
                    <option value="JinTang" <c:if test="${anchorage.anchorageEnum.typeCode == 5}">selected</c:if> >金塘锚地</option>
                </select>
            </p>
            <div class="divider"/>
            <p class="nowrap">
                <label>坐标1经纬度</label>
                <input name="point1X" type="text" maxlength="10" value="${anchorage.point1X}"/>
                <input name="point1Y" type="text" maxlength="10" value="${anchorage.point1Y}"/>
            </p>
            <div class="divider"/>
            <p class="nowrap">
                <label>坐标2经纬度</label>
                <input name="point2X" type="text" maxlength="10" value="${anchorage.point2X}"/>
                <input name="point2Y" type="text" maxlength="10" value="${anchorage.point2Y}"/>
            </p>
            <div class="divider"/>
            <p class="nowrap">
                <label>坐标3经纬度</label>
                <input name="point3X" type="text" maxlength="10" value="${anchorage.point3X}"/>
                <input name="point3Y" type="text" maxlength="10" value="${anchorage.point3Y}"/>
            </p>
            <div class="divider"/>
            <p class="nowrap">
                <label>坐标4经纬度</label>
                <input name="point4X" type="text" maxlength="10" value="${anchorage.point4X}"/>
                <input name="point4Y" type="text" maxlength="10" value="${anchorage.point4Y}"/>
            </p>
            <div class="divider"/>
            <p class="nowrap">
                <label>坐标5经纬度</label>
                <input name="point5X" type="text" maxlength="10" value="${anchorage.point5X}"/>
                <input name="point5Y" type="text" maxlength="10" value="${anchorage.point5Y}"/>
            </p>
            <div class="divider"/>
            <p class="nowrap">
                <label>坐标6经纬度</label>
                <input name="point6X" type="text" maxlength="10" value="${anchorage.point6X}"/>
                <input name="point6Y" type="text" maxlength="10" value="${anchorage.point6Y}"/>
            </p>
            <div class="divider"/>
            <p class="nowrap">
                <label>锚位数量</label>
                <input name="size" type="text" class="required" value="${anchorage.size}"/>
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