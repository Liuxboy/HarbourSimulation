<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%String root = request.getContextPath();%>
<div class="pageContent">
    <form action="<%=root %>/harbour/ship/doAdd" method="post"
          onsubmit="return validateCallback(this , dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56">
            <p>
                <label>船舶类型</label>
                <select id="shipEnum" name="shipEnum" type="text" readonly="readonly" class="required"
                        maxlength="20">
                    <option value="Container_Ship">集装箱船</option>
                    <option value="Iron_Ore">铁矿石</option>
                    <option value="Chemical_Oil">化工油品</option>
                    <option value="Crude_Oil">原油</option>
                    <option value="Coal">煤炭</option>
                    <option value="Break_Bulk_Ship">散杂船</option>
                </select>
            </p>
            <div class="divider"/>
            <p>
                <label>吨位</label>
                <select id="tonnerEnum" name="tonnerEnum" type="text" readonly="readonly" class="required"
                        maxlength="20">
                    <option value="OneTon">1万吨</option>
                    <option value="TwoTon">2万吨</option>
                    <option value="FiveTon">5万吨</option>
                    <option value="TenTon">10万吨</option>
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
                <input name="depth" type="text" class="required" maxlength="10"/>
            </p>
            <div class="divider"/>
            <p>
                <label>长度</label>
                <input name="length" type="text" class="required" maxlength="10"/>
            </p>
            <div class="divider"/>
            <p>
                <label>宽度</label>
                <input name="width" type="text" class="required" maxlength="10"/>
            </p>
            <div class="divider"/>
            <p>
                <label>速度</label>
                <input name="speed" type="text" class="required" maxlength="10"/>
            </p>
            <div class="divider"/>
            <p>
                <label>数量</label>
                <input name="speed" type="text" class="required" maxlength="10"/>
            </p>
            <div class="divider"/>
            <p>
                <label>安全间距</label>
                <input name="safeDistance" type="text" class="required" maxlength="10"/>
            </p>
            <div class="divider"/>
            <p>
                <label>到达分布(lambda)</label>
                <input name="lambda" style="width: 35px" type="text" class="required" maxlength="10"/>
                (泊松分布)
            </p>
            <div class="divider"/>
            <p>
                <label>靠泊分布(mu, sigma)</label>
                <input name="mu" style="width: 35px" type="text" class="required" maxlength="10"/>
                <input name="sigma" style="width: 35px" type="text" class="required" maxlength="10"/>
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
