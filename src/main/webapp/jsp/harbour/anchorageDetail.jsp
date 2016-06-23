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
            <input type="hidden" id="id" name="id" value="${id}">
            <p>
                <label>锚地</label>
                <select id="anchorageEnum" name="anchorageEnum" type="text" readonly="readonly" class="required"
                        maxlength="20">
                    <option value="North" <c:if test="${anchorage.anchorageEnum.typeCode == 0}">selected</c:if> >北锚地</option>
                    <option value="South" <c:if test="${anchorage.anchorageEnum.typeCode == 1}">selected</c:if> >南锚地</option>
                    <option value="Ore" <c:if test="${anchorage.anchorageEnum.typeCode == 2}">selected</c:if> >矿石锚地</option>
                </select>
            </p>
            <div class="divider"/>
            <p>
                <label>左下角坐标(x,y):</label>
                <input name="lx" type="text" class="required" maxlength="50" style="width:30px"
                       value="${anchorage.lx}"/>
                <input name="ly" type="text" class="required" maxlength="50" style="width:30px"
                       value="${anchorage.ly}"/>
            </p>
            <div class="divider"/>
            <p>
                <label>右下角坐标(x,y):</label>
                <input name="ux" type="text" class="required" maxlength="50" style="width:30px"
                       value="${anchorage.ux}"/>
                <input name="uy" type="text" class="required" maxlength="50" style="width:30px"
                       value="${anchorage.uy}"/>
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