<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%String root = request.getContextPath();%>
<div class="pageContent">
    <form action="<%=root %>/harbour/config" method="post" onsubmit="return validateCallback(this , dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56">
            <p>
                <label>会员id</label>
                <input name="id" type="text" class="required" maxlength="50" value="${customer.id}"/>
            </p>

            <p>
                <label>关注数</label>
                <input name="followingNo" type="text" class="required digits" maxlength="10" value="${customer.followingNo}"/>
            </p>

            <p>
                <label>粉丝数</label>
                <input name="fansNo" type="text" class="required digits" maxlength="10" value="${customer.fansNo}"/>
            </p>

            <p>
                <label>被订阅数</label>
                <input name="subscribedFansNo" type="text" class="required digits" maxlength="10" value="${customer.subscribeFansNo}"/>
            </p>

            <p>
                <label>订阅数</label>
                <input name="subscribeNo" type="text" class="required digits" maxlength="10" value="${customer.subscribeNo}"/>
            </p>

            <p>
                <label>创建时间</label>
                <input class="date   valid " datefmt="yyyy-MM-dd HH:mm:ss" name="beginTime" type="text"
                                      maxlength="20" value="${customer.createdTime}"/>
            </p>

            <p>
                <label>更新时间</label>
                <input class="date   valid " datefmt="yyyy-MM-dd HH:mm:ss" name="beginTime" type="text"
                                      maxlength="20" value="${customer.modifiedTime}"/>
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
