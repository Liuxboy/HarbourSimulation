<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%String root = request.getContextPath();%>
<form id="pagerForm" onsubmit="return navTabSearch(this);" method="POST" action="<%=root %>/manage/customer/list">
    <input type="hidden" name="pageNum" value="1"/>
    <input type="hidden" name="pageSize" value="10"/>
    <input type="hidden" name="beginTime" value="${customerParam.beginTime}"/>
    <input type="hidden" name="endTime" value="${customerParam.endTime}"/>
</form>
<div class="pageContent j-resizeGrid">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="add" href="<%=root %>/harbour/toAddChannel"
                   target="dialog" mask="true" rel="customer_add" resizable="false"
                   maxable="false" minable="false" title="添加航道信息" height="400"
                   width="800"> <span>添加航道信息</span>
            </a></li>
        </ul>
    </div>
    <div class="pageHeader">
        <form onsubmit="return navTabSearch(this);" method="POST"
              action="<%=root %>/harbour/">
            <div class="searchBar">
                <table class="searchContent">
                    <tr>
                        <td>航道长度：<input type="text" id="length" name="nickName"
                                        value="${berth.length}" maxlength="50"/>
                        </td>
                        <td>航道宽度：<input type="text" id="mobile" name="mobile"
                                        value="${berth.width}" maxlength="50"/>
                        </td>
                        <td>航道水深：<input type="text" id="depth" name="customerId"
                                        value="${berth.depth}" maxlength="50"/>
                        </td>
                        <td>航道左下坐标：<input type="text" id="lowerLeftCorner" name="customerId"
                                          value="${berth.lowerLeftCorner}" maxlength="50"/>
                        </td>
                        <td>航道右上坐标：<input type="text" id="upperRightCorner" name="customerId"
                                          value="${berth.upperRightCorner}" maxlength="50"/>
                        </td>
                        <td>通航模式：<input type="text" id="number" name="customerId"
                                        value="${berth.number}" maxlength="50"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="buttonActive">
                                <div class="buttonContent">
                                    <button type="submit">查询</button>
                                </div>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </form>
    </div>
    <table class="table" width="100%" layoutH="135">
        <thead>
        <tr>
            <th>会员id</th>
            <th>关注数</th>
            <th>粉丝数</th>
            <th>被订阅数</th>
            <th>订阅数</th>
            <th>更新</th>
            <th>刷新缓存</th>
            <!-- <th>删除</th> -->
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customerLists}" var="customer">
            <tr>
                <td>${customer.id}</td>
                <td>${customer.followingNo}</td>
                <td>${customer.fansNo}</td>
                <td>${customer.subscribedFansNo}</td>
                <td>${customer.subscribeNo}</td>
                <td><a
                        href="<%=root %>/manage/customer/forUpdate?customerId=${customer.id}"
                        target="dialog" mask="true" rel="customer_update" title="会员信息"
                        height="400" width="800" class="btnEdit">更新</a></td>
                <td><a
                        href="<%=root %>/manage/customer/updateCustomerCache?customerId=${customer.id}"
                        class="btnEdit" title="确定要刷新缓存吗"
                        target="ajaxTodo">刷新缓存</a></td>
                    <%--                 <td>
                    <a href="<%=root %>/manage/customer/delete/?customerId=${customer.id}" class="btnDel" title="确定要删除么"
                       target="ajaxTodo">删除</a>
                </td> --%>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <!--分页页面组件 -->
    <div class="panelBar">
        <div class="pages">
            <span>每页</span> <select class="combox" name="numPerPage"
                                    onchange="navTabPageBreak({numPerPage:this.value})">
            <option value="20" ${customerParam.pageSize eq 20 ? 'selected':''}>20</option>
            <option value="50" ${customerParam.pageSize eq 50 ? 'selected':''}>50</option>
            <option value="100" ${customerParam.pageSize eq 100 ? 'selected':''}>100</option>
            <option value="200" ${customerParam.pageSize eq 200 ? 'selected':''}>200</option>
        </select> <span>满足条件的记录总数: ${customerParam.totalCount}</span>
        </div>
        <div class="pagination" targetType="navTab"
             totalCount="${customerParam.totalCount}"
             numPerPage="${customerParam.pageSize}" pageNumShown="10"
             currentPage="${customerParam.pageNum}"></div>
    </div>
</div>

