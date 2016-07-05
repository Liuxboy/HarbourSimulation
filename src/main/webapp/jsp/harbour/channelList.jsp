<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%String root = request.getContextPath();%>
<form id="pagerForm" onsubmit="return navTabSearch(this);" method="POST"
      action="<%=root %>/harbour/channel/toList">
    <input type="hidden" name="pageNum" value="1"/>
    <input type="hidden" name="pageSize" value="10"/>
</form>
<div class="pageContent j-resizeGrid">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="add" href="<%=root %>/harbour/channel/toAdd"
                   target="dialog" mask="true" rel="channel_add" resizable="false"
                   maxable="false" minable="false" title="添加航道信息" height="400"
                   width="600"> <span>添加航道信息</span>
            </a></li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="85%">
        <thead>
        <tr>
            <th>序号</th>
            <th>航道名</th>
            <th>航道长度(km)</th>
            <th>航道宽度(km)</th>
            <th>航道水深(m)</th>
            <th>航道限速(km/h)</th>
            <th>动态通航能力(艘/h)</th>
            <th>通航模式</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${channelList}" var="item" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${item.name}</td>
                <td>${item.length}</td>
                <td>${item.width}</td>
                <td>${item.depth}</td>
                <td>${item.limitedSpeed}</td>
                <td>${item.dynamicPassRatio}</td>
                <td>${item.passEnum.pattern}</td>
                <td>
                    <a href="<%=root %>/harbour/channel/showDetail/${item.id}"
                       target="dialog" mask="true" rel="channel_show"
                       title="查看详情" height="400" width="500" class="btnEdit">查看详情</a>
                    <a href="<%=root %>/harbour/channel/delete/${item.id}"
                       class="btnDel" title="确定要删除么"
                       target="ajaxTodo">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

