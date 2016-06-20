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
                <label>会员id:</label>${customer.id}
                <input name="id" type="hidden" class="required" maxlength="50" style="width:180px"
                       value="${customer.id}"/>
            </p>
            <p>
                <label>关注数:</label>
                <input name="followingNo" type="text" class="required digits" maxlength="20" style="width:180px"
                       value="${customer.followingNo}"/>
            </p>
            <p>
                <label>粉丝数:</label>
                <input name="fansNo" type="text" class="required digits" maxlength="20" style="width:180px"
                       value="${customer.fansNo}"/>
            </p>
            <p>
                <label>被订阅数:</label>
                <input name="subscribedFansNo" type="text" class="required digits" maxlength="20" style="width:180px"
                       value="${customer.subscribedFansNo}"/>
            </p>

            <p>
                <label>订阅数</label>
                <input name="subscribeNo" type="text" class="required digits" maxlength="20" value="${customer.subscribeNo}"/>
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