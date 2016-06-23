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
                <label>泊位类型</label>
                <select id="shipEnum" name="shipEnum" type="text" readonly="readonly" class="required"
                        maxlength="20">
                    <option value="Crude_Oil">原油</option>
                    <option value="Coal">煤炭</option>
                    <option value="Iron_Ore">铁矿石</option>
                    <option value="Container_Ship">集装箱船</option>
                    <option value="Chemical_Oil">化工油品</option>
                    <option value="Break_Bulk_Ship">散杂船</option>
                </select>
            </p>
            <div class="divider"/>
            <p>
                <label>吨位</label>
                <input name="tonner" type="text" class="required digits" maxlength="10"/>
            </p>
            <div class="divider"/>
            <p>
                <label>深度</label>
                <input name="depth" type="text" class="required digits" maxlength="10"/>
            </p>
            <div class="divider"/>
            <p>
                <label>长度</label>
                <input name="length" type="text" class="required digits" maxlength="10"/>
            </p>
            <div class="divider"/>
            <p>
                <label>宽度</label>
                <input name="width" type="text" class="required digits" maxlength="10"/>
            </p>
            <div class="divider"/>
            <p>
                <label>泊位中心坐标(x,y)</label>
                <input name="x" style="width: 30px" type="text" class="required digits" maxlength="10"/>
                <input name="y" style="width: 30px" type="text" class="required digits" maxlength="10"/>
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
