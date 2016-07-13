<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%String root = request.getContextPath();%>
<form id="pagerForm" onsubmit="return navTabSearch(this);" method="POST" action="<%=root %>/harbour/ship/toList">
    <input type="hidden" name="pageNum" value="1"/>
    <input type="hidden" name="pageSize" value="10"/>
</form>
<div class="pageContent j-resizeGrid">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="add" href="<%=root %>/harbour/ship/toAdd"
                   target="dialog" mask="true" rel="ship_add" resizable="false"
                   maxable="false" minable="false" title="添加船舶" height="500"
                   width="600"> <span>添加船舶</span>
            </a></li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="85%">
        <thead>
        <tr>
            <th>序号</th>
            <th>船舶类型</th>
            <th>船舶长度</th>
            <th>船舶宽度</th>
            <th>船舶深度</th>
            <th>船舶吨位(吨)</th>
            <th>船舶数量</th>
            <th>船舶速度(km/h)</th>
            <th>船舶优先级</th>
            <th>安全距离(m)</th>
            <th>到达分布(泊松分布)</th>
            <th>靠泊分布(对态正态分布)</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${shipList}" var="item" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${item.shipEnum.nameCN}</td>
                <td>${item.length}</td>
                <td>${item.width}</td>
                <td>${item.depth}</td>
                <td>${item.tonner}</td>
                <td>${item.numbers}</td>
                <td>${item.speed}</td>
                <td>${item.priorityEnum.desc}</td>
                <td>${item.safeDistance}</td>
                <td>(lambda=${item.lambda})</td>
                <td>(mu=${item.mu}, sigma=${item.sigma})</td>
                <td>
                    <a href="<%=root %>/harbour/ship/showDetail/${item.id}"
                       target="dialog" mask="true" rel="ship_update" title="查看详情"
                       height="500" width="600" class="btnEdit">查看详情</a>
                    <a href="<%=root %>/harbour/ship/delete/${item.id}"
                       class="btnDel" title="确定要删除么" target="ajaxTodo">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

