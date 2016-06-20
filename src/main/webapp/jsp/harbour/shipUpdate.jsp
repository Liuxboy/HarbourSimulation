<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%String root = request.getContextPath();%>
<head>
    <script src="<%=root %>/js/jquery.form.js" type="text/javascript"></script>
    <script src="<%=root %>/js/ajaxfileupload.js" type="text/javascript"></script>
</head>
<div class="pageContent">
   <form action="<%=root %>/harbour/ship/doUpdate" method="post" onsubmit="return validateCallback(this,dialogAjaxDone);">
       <input name="id" hidden="hidden" type="text" class="required" value="${ship.id}" maxlength="10"/>
       <div class="pageFormContent" layoutH="56">
            <p>
                <label>船舶类型</label>
                < id="shipEnum" name="shipEnum" type="text" readonly="readonly" class="required"
                        maxlength="20">
                    <option value="VLCC" <c:if test="${ship.shipEnum.typeCode == 0}">selected</c:if> >油轮</option>
                    <option value="LPG" <c:if test="${ship.shipEnum.typeCode == 1}">selected</c:if> >液化石油气船</option>
                    <option value="LNG" <c:if test="${ship.shipEnum.typeCode == 2}">selected</c:if> >液化天然气船</option>
                    <option value="CS" <c:if test="${ship.shipEnum.typeCode == 3}">selected</c:if> >集装箱船</option>
                    <option value="CC" <c:if test="${ship.shipEnum.typeCode == 4}">selected</c:if> >化学品船</option>
                    <option value="BBS" <c:if test="${ship.shipEnum.typeCode == 50}">selected</c:if> >散杂船</option>
                </select>
            </p>
            <div class="divider"/>
            <p>
                <label>吨位</label>
                <select id="tonnerEnum" name="tonnerEnum" type="text" readonly="readonly" class="required"
                        maxlength="20">
                    <option value="OneTon" <c:if test="${ship.tonnerEnum.typeCode == 0}">selected</c:if> >1吨</option>
                    <option value="TwoTon" <c:if test="${ship.tonnerEnum.typeCode == 1}">selected</c:if> >2吨</option>
                    <option value="FiveTon" <c:if test="${ship.tonnerEnum.typeCode == 2}">selected</c:if> >5吨</option>
                    <option value="TenTon" <c:if test="${ship.tonnerEnum.typeCode == 3}">selected</c:if> >10吨</option>
                </select>
            </p>
            <div class="divider"/>
            <p>
                <label>优化级</label>
                <select id="priorityEnum" name="priorityEnum" type="text" readonly="readonly" class="required"
                        maxlength="20">
                    <option value="HIGH" <c:if test="${ship.priorityEnum.typeCode == 0}">selected</c:if>>高</option>
                    <option value="NORMAL" <c:if test="${ship.priorityEnum.typeCode == 1}">selected</c:if>>中</option>
                    <option value="LOW" <c:if test="${ship.priorityEnum.typeCode == 2}">selected</c:if>>低</option>
                </select>
            </p>
            <div class="divider"/>
            <p>
                <label>深度</label>
                <input name="depth" style="width: 30px" value="${ship.depth}"
                       type="text" class="required digits" maxlength="10"/>
            </p>
            <div class="divider"/>
            <p>
                <label>长度</label>
                <input name="length" style="width: 30px" value="${ship.length}"
                       type="text" class="required digits" maxlength="10"/>
            </p>
            <div class="divider"/>
            <p>
                <label>宽度</label>
                <input name="width" style="width: 30px" value="${ship.width}"
                       type="text" class="required digits" maxlength="10"/>
            </p>
            <div class="divider"/>
            <p>
                <label>速度</label>
                <input name="speed" style="width: 30px" value="${ship.speed}"
                       type="text" class="required digits" maxlength="10"/>
            </p>
            <div class="divider"/>
            <p>
                <label>到达时间分布</label>
                <input name="" style="width: 30px" type="text" class="required digits" maxlength="10"/>
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