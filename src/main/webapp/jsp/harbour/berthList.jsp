<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%String root = request.getContextPath();%>
<form id="pagerForm" onsubmit="return navTabSearch(this);" method="POST" action="<%=root %>/harbour/berth/toList">
    <input type="hidden" name="pageNum" value="1"/>
    <input type="hidden" name="pageSize" value="10"/>
</form>
<div class="pageContent j-resizeGrid">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="add" href="<%=root %>/harbour/berth/toAdd"
                   target="dialog" mask="true" rel="customer_add" resizable="false"
                   maxable="false" minable="false" title="添加泊位" height="400"
                   width="600"> <span>添加泊位</span>
            </a></li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="85%">
        <thead>
        <tr>
            <th>序号</th>
            <th>泊位编号</th>
            <th>泊位类型</th>
            <th>泊位吨位</th>
            <th>泊位深度</th>
            <th>泊位长度</th>
            <th>泊位宽度</th>
            <th>泊位坐标x</th>
            <th>泊位坐标y</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${berthList}" var="item" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${item.id}</td>
                <td>${item.shipEnum.nameCN}</td>
                <td>${item.tonner}</td>
                <td>${item.depth}</td>
                <td>${item.length}</td>
                <td>${item.width}</td>
                <td>${item.x}</td>
                <td>${item.y}</td>
                <td>
                    <a href="<%=root %>/harbour/berth/showDetail/${item.id}"
                       target="dialog" mask="true" rel="showAnchorage"
                       title="查看详情" height="400" width="600" class="btnEdit">查看详情</a>
                    <a href="<%=root %>/harbour/berth/delete/?id=${item.id}" class="btnDel" title="确定要删除么"
                        target="ajaxTodo">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

