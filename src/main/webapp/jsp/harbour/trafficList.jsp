<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%String root = request.getContextPath();%>
<form id="pagerForm" onsubmit="return navTabSearch(this);" method="POST" action="<%=root %>/harbour/traffic/toList">
    <input type="hidden" name="pageNum" value="1"/>
    <input type="hidden" name="pageSize" value="10"/>
</form>
<div class="pageContent j-resizeGrid">
    <div class="panelBar">
        <ul class="toolBar">
            <li>
                <a class="add" href="<%=root %>/harbour/traffic/toAdd"
                   target="dialog" mask="true" rel="time_add" resizable="false"
                   maxable="false" minable="false" title="添加交通管制" height="400"
                   width="600"> <span>添加交通管制</span>
                </a>
            </li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="85%">
        <thead>
        <tr>
            <th>序号</th>
            <th>管制类型</th>
            <th>管制次数</th>
            <th>管制时长</th>
            <th>是否生效</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${trafficList}" var="item" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${item.trafficEnum.desc}</td>
                <td>${item.trafficTimes}</td>
                <td>${item.trafficDuration}</td>
                <td>
                    <c:if test="${item.status == 0}">无效</c:if>
                    <c:if test="${item.status == 1}">生效</c:if>
                </td>
                <td>
                    <a href="<%=root %>/harbour/traffic/showDetail/${item.id}"
                       target="dialog" mask="true" rel="traffic_update" title="查看详情"
                       height="500" width="600" class="btnEdit">查看详情</a>
                    <a href="<%=root %>/harbour/traffic/delete?id=${item.id}" class="btnDel" title="确定要删除么"
                       target="ajaxTodo">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

