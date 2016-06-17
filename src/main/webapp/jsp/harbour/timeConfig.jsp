<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%String root = request.getContextPath();%>
<form id="pagerForm" onsubmit="return navTabSearch(this);" method="POST" action="<%=root %>/harbour/time/timeConfig">
    <input type="hidden" name="pageNum" value="1"/>
    <input type="hidden" name="pageSize" value="10"/>
</form>
<div class="pageContent j-resizeGrid">
    <div class="panelBar">
        <ul class="toolBar">
            <li>
                <a class="add" href="<%=root %>/harbour/time/toAddTimeConfig"
                   target="dialog" mask="true" rel="time_add" resizable="false"
                   maxable="false" minable="false" title="添加仿真时间" height="400"
                   width="800"> <span>添加仿真时间</span>
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
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${timeConfigList}" var="item" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${item.simulationTimeOut}</td>
                <td>${item.simulationTimeStep}</td>
                <td>
                    <a href="<%=root %>/harbour/time/delete?id=${item.id}" class="btnDel" title="确定要删除么"
                       target="ajaxTodo">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

