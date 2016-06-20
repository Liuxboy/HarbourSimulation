<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%String root = request.getContextPath();%>
<div class="pageContent">
    <form action="<%=root %>/harbour/berth/doAdd" method="post"
          onsubmit="return validateCallback(this , dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56">
            <p>
                <label>船舶类型</label>
                <select id="shipEnum" name="shipEnum" type="text" readonly="readonly" class="required"
                        maxlength="20">
                    <option value="VLCC">油轮</option>
                    <option value="LPG">液化石油气船</option>
                    <option value="LNG">液化天然气船</option>
                    <option value="CS">集装箱船</option>
                    <option value="CC">化学品船</option>
                    <option value="BBS">散杂船</option>
                </select>
            </p>
            <div class="divider"/>
            <p>
                <label>吨位</label>
                <select id="tonnerEnum" name="tonnerEnum" type="text" readonly="readonly" class="required"
                        maxlength="20">
                    <option value="OneTon">1吨</option>
                    <option value="TwoTon">2吨</option>
                    <option value="FiveTon">5吨</option>
                    <option value="TenTon">10吨</option>
                </select>
            </p>
            <div class="divider"/>
            <p>
                <label>优化级</label>
                <select id="priorityEnum" name="priorityEnum" type="text" readonly="readonly" class="required"
                        maxlength="20">
                    <option value="HIGH">高</option>
                    <option value="NORMAL">中</option>
                    <option value="LOW">低</option>
                </select>
            </p>
            <div class="divider"/>
            <p>
                <label>深度</label>
                <input name="depth" style="width: 30px" type="text" class="required digits" maxlength="10"/>
            </p>
            <div class="divider"/>
            <p>
                <label>长度</label>
                <input name="length" style="width: 30px" type="text" class="required digits" maxlength="10"/>
            </p>
            <div class="divider"/>
            <p>
                <label>宽度</label>
                <input name="width" style="width: 30px" type="text" class="required digits" maxlength="10"/>
            </p>
            <div class="divider"/>
            <p>
                <label>速度</label>
                <input name="speed" style="width: 30px" type="text" class="required digits" maxlength="10"/>
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