<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%String root = request.getContextPath();%>
<form id="pagerForm" onsubmit="return navTabSearch(this);" method="POST" action="<%=root %>/harbour/berth/berthList">
    <input type="hidden" name="pageNum" value="1"/>
    <input type="hidden" name="pageSize" value="10"/>
</form>
<div class="pageContent j-resizeGrid">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="add" href="<%=root %>/harbour/berth/toAddBerth"
                   target="dialog" mask="true" rel="customer_add" resizable="false"
                   maxable="false" minable="false" title="添加泊位" height="400"
                   width="800"> <span>添加泊位</span>
            </a></li>
        </ul>
    </div>
    <div class="pageHeader">
        <form onsubmit="return navTabSearch(this);" method="POST"
              action="<%=root %>/harbour/">
            <div class="searchBar">
                <table class="searchContent">
                    <tr>
                        <td>泊位编号：<input type="text" id="length" name="nickName"
                                        value="${berth.length}" maxlength="50"/>
                        </td>
                        <td>泊位类型：<input type="text" id="mobile" name="mobile"
                                        value="${berth.width}" maxlength="50"/>
                        </td>
                    </tr>
                    <tr>
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
    <table class="table" width="100%" layoutH="135" varStatus="status">
        <thead>
        <tr>
            <th>序号</th>
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
                <td>${item.shipEnum}</td>
                <td>${item.tonner}</td>
                <td>${item.depth}</td>
                <td>${item.length}</td>
                <td>${item.width}</td>
                <td>${item.point.x}</td>
                <td>${item.point.y}</td>
                <td>
                    <a href="<%=root %>/harbour/berth/showDetail/${item.id}"
                       target="dialog" mask="true" rel="showAnchorage"
                       title="查看详情" height="400" width="500" class="btnView">查看详情</a>
                    <a  href="<%=root %>/harbour/berth/forUpdate?id=${item.id}"
                        target="dialog" mask="true" rel="customer_update" title="更新泊位信息"
                        height="400" width="800" class="btnEdit">更新</a></td>
                    <a href="<%=root %>/harbour/berth/delete/?id=${item.id}" class="btnDel" title="确定要删除么"
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

