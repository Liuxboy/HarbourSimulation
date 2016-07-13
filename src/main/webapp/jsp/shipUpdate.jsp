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
                <select id="shipEnum" name="shipEnum" type="text" readonly="readonly" class="required"
                        maxlength="20">
                    <option value="Crude_Oil" <c:if test="${ship.shipEnum.typeCode == 0}">selected</c:if> >原油</option>
                    <option value="Coal" <c:if test="${ship.shipEnum.typeCode == 1}">selected</c:if> >煤炭</option>
                    <option value="Iron_Ore" <c:if test="${ship.shipEnum.typeCode == 2}">selected</c:if> >铁矿石</option>
                    <option value="Container_Ship" <c:if test="${ship.shipEnum.typeCode == 3}">selected</c:if> >集装箱船</option>
                    <option value="Chemical_Oil" <c:if test="${ship.shipEnum.typeCode == 4}">selected</c:if> >化工油品</option>
                    <option value="Break_Bulk_Ship" <c:if test="${ship.shipEnum.typeCode == 50}">selected</c:if> >散杂船</option>
                </select>
            </p>
            <div class="divider"/>
            <p>
                <label>吨位</label>
                <input name="tonner" value="${ship.tonner}"
                       type="text" class="required" maxlength="10"/>
            </p>
            <div class="divider"/>
            <p>
                <label>优化级</label>
                <select id="priorityEnum" name="priorityEnum" type="text" readonly="readonly" class="required"
                        maxlength="20">
                    <option value="HIGH" <c:if test="${ship.priorityEnum.priority == 0}">selected</c:if>>高</option>
                    <option value="NORMAL" <c:if test="${ship.priorityEnum.priority == 1}">selected</c:if>>中</option>
                    <option value="LOW" <c:if test="${ship.priorityEnum.priority == 2}">selected</c:if>>低</option>
                </select>
            </p>
            <div class="divider"/>
            <p>
                <label>深度</label>
                <input name="depth" value="${ship.depth}"
                       type="text" class="required" maxlength="10"/>
            </p>
            <div class="divider"/>
            <p>
                <label>长度</label>
                <input name="length" value="${ship.length}"
                       type="text" class="required" maxlength="10"/>
            </p>
            <div class="divider"/>
            <p>
                <label>宽度</label>
                <input name="width" value="${ship.width}"
                       type="text" class="required" maxlength="10"/>
            </p>
            <div class="divider"/>
            <p>
                <label>速度</label>
                <input name="speed" value="${ship.speed}"
                       type="text" class="required" maxlength="10"/>
            </p>
            <div class="divider"/>
            <p>
                <label>数量</label>
                <input name="number" value="${ship.speed}"
                       type="text" class="required" maxlength="10"/>
            </p>
            <div class="divider"/>
            <p>
                <label>到达时间分布</label>
                <input name="lambda" style="width: 30px" type="text" class="required" maxlength="10"
                       value="${ship.lambda}"/>
                (泊松分布)
            </p>
           <div class="divider"/>
           <p>
               <label>靠泊分布(mu, sigma)</label>
               <input name="mu" style="width: 30px" type="text" class="required" maxlength="10"
                      value="${ship.mu}"/>
               <input name="sigma" style="width: 30px" type="text" class="required" maxlength="10"
                      value="${ship.sigma}"/>
               (对数正态分布)
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