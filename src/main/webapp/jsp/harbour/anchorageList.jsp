<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%String root = request.getContextPath();%>
<form id="pagerForm" onsubmit="return navTabSearch(this);" method="POST"
      action="<%=root %>/harbour/anchorage/toList">
    <input type="hidden" name="pageNum" value="1"/>
    <input type="hidden" name="pageSize" value="10"/>
</form>
<div class="pageContent j-resizeGrid">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="add" href="<%=root %>/harbour/anchorage/toAdd"
                   target="dialog" mask="true" rel="anchorage_add" resizable="false"
                   maxable="false" minable="false" title="添加锚地" height="200"
                   width="400"> <span>添加锚地</span>
                </a>
            </li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="85%">
        <thead>
        <tr>
            <th>序号</th>
            <th>左下角坐标</th>
            <th>右上角坐标</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${anchorageList}" var="item" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>(${item.lowerLeftCorner.x},${item.lowerLeftCorner.y})</td>
                <td>(${item.upperRightCorner.x},${item.upperRightCorner.y})</td>
                <td>
                    <a href="<%=root %>/harbour/anchorage/showDetail/${item.id}"
                       target="dialog" mask="true" rel="showAnchorage"
                       title="查看详情" height="200" width="400" class="btnEdit">查看详情</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
