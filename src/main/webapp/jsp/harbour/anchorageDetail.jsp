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
                <label>左下角坐标(x,y):</label>
                <input name="lx" type="text" class="required" maxlength="50" style="width:30px"
                       value="${anchorage.lowerLeftCorner.x}"/>
                <input name="ly" type="text" class="required" maxlength="50" style="width:30px"
                       value="${anchorage.lowerLeftCorner.y}"/>
            </p>
            <div class="divider"/>
            <p>
                <label>右下角坐标(x,y):</label>
                <input name="ux" type="text" class="required" maxlength="50" style="width:30px"
                       value="${anchorage.upperRightCorner.x}"/>
                <input name="uy" type="text" class="required" maxlength="50" style="width:30px"
                       value="${anchorage.upperRightCorner.y}"/>
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