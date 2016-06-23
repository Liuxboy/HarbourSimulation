<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%String root = request.getContextPath();%>
<div class="pageContent">
    <form action="<%=root %>/harbour/anchorage/doAdd" method="post"
          onsubmit="return validateCallback(this , dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56">
            <p>
                <label>锚地</label>
                <select id="anchorageEnum" name="anchorageEnum" type="text" readonly="readonly" class="required"
                        maxlength="20">
                    <option value="North">北锚地</option>
                    <option value="South">南锚地</option>
                    <option value="Ore">矿石锚地</option>
                </select>
            </p>
            <div class="divider"/>
            <p>
                <label>左下角坐标(x,y)</label>
                <input name="lx" style="width: 30px" type="text" class="required digits" maxlength="10"/>
                <input name="ly" style="width: 30px" type="text" class="required digits" maxlength="10"/>
            </p>
            <div class="divider"/>
            <p>
                <label>右上角坐标(x,y)</label>
                <input name="ux" style="width: 30px" type="text" class="required digits" maxlength="10"/>
                <input name="uy" style="width: 30px" type="text" class="required digits" maxlength="10"/>
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
