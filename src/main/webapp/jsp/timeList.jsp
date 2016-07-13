<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%String root = request.getContextPath();%>
<form id="pagerForm" onsubmit="return navTabSearch(this);" method="POST" action="<%=root %>/harbour/time/toList">
    <input type="hidden" name="pageNum" value="1"/>
    <input type="hidden" name="pageSize" value="10"/>
</form>
<div class="pageContent j-resizeGrid">
    <div class="panelBar">
        <ul class="toolBar">
            <li>
                <a class="add" href="<%=root %>/harbour/time/toAdd"
                   target="dialog" mask="true" rel="time_add" resizable="false"
                   maxable="false" minable="false" title="添加仿真时间" height="400"
                   width="600"> <span>添加仿真时间</span>
                </a>
            </li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="85%">
        <thead>
        <tr>
            <th>序号</th>
            <th>时间总长</th>
            <th>时间步长</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${timeList}" var="item" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${item.timeOut}${item.timeOutUnit.unit}</td>
                <td>${item.timeStep}${item.timeStepUnit.unit}</td>
                <td>
                    <a href="<%=root %>/harbour/time/showDetail/${item.id}"
                       target="dialog" mask="true" rel="traffic_update" title="查看详情"
                       height="500" width="600" class="btnEdit">查看详情</a>
                    <a href="<%=root %>/harbour/time/delete/${item.id}"
                       class="btnDel" title="确定要删除么"
                       target="ajaxTodo">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

