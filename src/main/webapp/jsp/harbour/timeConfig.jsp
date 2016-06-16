<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%String root = request.getContextPath();%>
<form id="pagerForm" onsubmit="return navTabSearch(this);" method="POST" action="<%=root %>/harbour/time/timeConfig">
    <input type="hidden" name="pageNum" value="1"/>
    <input type="hidden" name="pageSize" value="10"/>
    <input type="hidden" name="beginTime" value="${customerParam.beginTime}"/>
    <input type="hidden" name="endTime" value="${customerParam.endTime}"/>
</form>
<div class="pageContent j-resizeGrid">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="add" href="<%=root %>/harbour/harbour/toAddTimeConfig"
                   target="dialog" mask="true" rel="time_add" resizable="false"
                   maxable="false" minable="false" title="添加仿真时间" height="400"
                   width="800"> <span>添加仿真时间</span>
            </a></li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="135">
        <thead>
        <tr>
            <th>序号</th>
            <th>仿真时长</th>
            <th>仿真步长</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${timeConfigList}" var="item" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${item.simulationTimeOut}</td>
                <td>${item.simulationTimeStep}</td>
                <td>
                    <a href="<%=root %>/harbour/ship/delete?id=${item.id}" class="btnDel" title="确定要删除么"
                       target="ajaxTodo">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <!--分页页面组件 -->
    <div class="panelBar">
        <div class="pages">
            <span>每页</span> <select class="combox" name="numPerPage"
                                    onchange="navTabPageBreak({numPerPage:this.value})">
            <option value="20" ${pageParam.pageSize eq 20 ? 'selected':''}>20</option>
            <option value="50" ${pageParam.pageSize eq 50 ? 'selected':''}>50</option>
            <option value="100" ${pageParam.pageSize eq 100 ? 'selected':''}>100</option>
            <option value="200" ${pageParam.pageSize eq 200 ? 'selected':''}>200</option>
        </select> <span>满足条件的记录总数: ${pageParam.totalCount}</span>
        </div>
        <div class="pagination" targetType="navTab"
             totalCount="${pageParam.totalCount}"
             numPerPage="${pageParam.pageSize}" pageNumShown="10"
             currentPage="${pageParam.pageNum}"></div>
    </div>
</div>

