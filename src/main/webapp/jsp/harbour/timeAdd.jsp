<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%String root = request.getContextPath();%>
<div class="pageContent">
    <form action="<%=root %>/harbour/time/doAdd" method="post"
          onsubmit="return validateCallback(this , dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56">
            <p>
                <label>仿真时间总长</label>
                <input name="timeOut" type="text" class="required" maxlength="10"/>
                <select id="timeOutUnit" name="timeOutUnit" type="text" readonly="readonly" class="required"
                        maxlength="20">
                    <option value="DAY">天</option>
                    <option value="WEK">周</option>
                    <option value="MON">月</option>
                    <option value="YER">年</option>
                </select>
            </p>
            <div class="divider"/>
            <p>
                <label>仿真时间步长</label>
                <input name="timeStep" type="text" class="required" maxlength="10"/>
                <select id="timeStepUnit" name="timeStepUnit" type="text" readonly="readonly" class="required"
                        maxlength="20">
                    <option value="HOR">时</option>
                    <option value="MIN">分</option>
                </select>
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
