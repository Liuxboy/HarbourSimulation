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
                   maxable="false" minable="false" title="添加船舶" height="400"
                   width="800"> <span>添加船舶</span>
            </a></li>
        </ul>
    </div>
    <div class="pageHeader">
        <form onsubmit="return navTabSearch(this);" method="POST"
              action="<%=root %>/harbour/ship/toList">
            <div class="searchBar">
                <table class="searchContent">
                    <tr>
                        <td>船舶类型：<input type="text" id="shipEnum" name="shipEnum"
                                        value="${ship.shipEnum.typeCode}" maxlength="50"/>
                        </td>
                        <td>
                            <div class="buttonActive">
                                <div class="buttonContent">
                                    <button type="submit">查询</button>
                                </div>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </form>
    </div>
    <table class="table" width="100%" layoutH="120%">
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
