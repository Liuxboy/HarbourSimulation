<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%String root = request.getContextPath();%>
<head>
    <script src="<%=root %>/js/jquery.form.js" type="text/javascript"></script>
    <script src="<%=root %>/js/ajaxfileupload.js" type="text/javascript"></script>
</head>
<div class="pageContent">
   <form action="<%=root %>/manage/customer/update" method="post" onsubmit="return validateCallback(this,dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56">
            <p>
                <label>泊位类型</label>
                <select id="shipEnum" name="shipEnum" type="text" readonly="readonly" class="required"
                        maxlength="20">
                    <option value="Crude_Oil" <c:if test="${berth.shipEnum.typeCode == 0}">selected</c:if> >原油</option>
                    <option value="Coal" <c:if test="${berth.shipEnum.typeCode == 1}">selected</c:if> >煤炭</option>
                    <option value="Iron_Ore" <c:if test="${berth.shipEnum.typeCode == 2}">selected</c:if> >铁矿石</option>
                    <option value="Container_Ship" <c:if test="${berth.shipEnum.typeCode == 3}">selected</c:if> >集装箱船</option>
                    <option value="Chemical_Oil" <c:if test="${berth.shipEnum.typeCode == 4}">selected</c:if> >化工油品</option>
                    <option value="Break_Bulk_Ship" <c:if test="${berth.shipEnum.typeCode == 5}">selected</c:if> >散杂船</option>
                </select>
            </p>
            <div class="divider"/>
            <p>
                <label>吨位</label>
                <input name="tonner" type="text" class="required digits" maxlength="10"
                       value="${berth.tonner}"/>
            </p>
            <div class="divider"/>
            <p>
                <label>深度</label>
                <input name="depth" type="text" class="required digits" maxlength="10"
                       value="${berth.depth}"/>
            </p>
            <div class="divider"/>
            <p>
                <label>长度</label>
                <input name="length" type="text" class="required digits" maxlength="10"
                       value="${berth.length}"/>
            </p>
            <div class="divider"/>
            <p>
                <label>宽度</label>
                <input name="width" type="text" class="required digits" maxlength="10"
                       value="${berth.width}"/>
            </p>
            <div class="divider"/>
            <p>
                <label>泊位中心坐标(x,y)</label>
                <input name="x" style="width: 30px" type="text" class="required digits" maxlength="10"
                       value="${berth.x}"/>
                <input name="y" style="width: 30px" type="text" class="required digits" maxlength="10"
                       value="${berth.y}"/>
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