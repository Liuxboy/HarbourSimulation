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
                   maxable="false" minable="false" title="添加锚地" height="400"
                   width="600"> <span>添加锚地</span>
                </a>
            </li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="85%">
        <thead>
        <tr>
            <th>序号</th>
            <th>锚地名称</th>
            <th>坐标1经纬度</th>
            <th>坐标2经纬度</th>
            <th>坐标3经纬度</th>
            <th>坐标4经纬度</th>
            <th>锚位数</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${anchorageList}" var="item" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${item.anchorageEnum.name}</td>
                <td>(${item.point1X},${item.point1Y})</td>
                <td>(${item.point2X},${item.point2Y})</td>
                <td>(${item.point3X},${item.point3Y})</td>
                <td>(${item.point4X},${item.point4Y})</td>
                <td>${item.size}</td>
                <td>
                    <a href="<%=root %>/harbour/anchorage/showDetail/${item.id}"
                       target="dialog" mask="true" rel="showAnchorage"
                       title="查看详情" height="400" width="600" class="btnEdit">查看详情</a>
                    <a href="<%=root %>/harbour/anchorage/delete/${item.id}"
                       class="btnDel" title="确定要删除么"
                       target="ajaxTodo">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

