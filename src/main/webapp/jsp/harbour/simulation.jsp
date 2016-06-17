<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%String root = request.getContextPath();%>
<form id="pagerForm" onsubmit="return navTabSearch(this);" method="POST" action="<%=root %>/harbour/ship/shipList">
    <input type="hidden" name="pageNum" value="1"/>
    <input type="hidden" name="pageSize" value="10"/>
</form>
<div class="pageContent j-resizeGrid">
    <table class="table" width="100%" layoutH="65%">
        <thead>
        <tr>
            <th>序号</th>
            <th>船舶类型</th>
            <th>船舶长度</th>
            <th>船舶宽度</th>
            <th>船舶深度</th>
            <th>船舶吨位</th>
            <th>船舶数量</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${shipLists}" var="item" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${item.shipEnum.nameCN}</td>
                <td>${item.length}</td>
                <td>${item.width}</td>
                <td>${item.depth}</td>
                <td>${item.tonnerEnum.tonner}</td>
                <td>${item.numbers}</td>
                <td>${item.priorityEnum.desc}</td>
                <td>
                    <a  href="<%=root %>/harbour/ship/forUpdate?id=${item.id}"
                        target="dialog" mask="true" rel="ship_update" title="船舶信息"
                        height="400" width="800" class="btnEdit">更新</a>
                </td>
                    <a href="<%=root %>/harbour/ship/delete?id=${item.id}" class="btnDel" title="确定要删除么"
                       target="ajaxTodo">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

