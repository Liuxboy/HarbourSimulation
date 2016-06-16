<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%String root = request.getContextPath();%>
<form id="pagerForm" onsubmit="return navTabSearch(this);" method="POST" action="<%=root %>/harbour/pass/passRuleList">
    <input type="hidden" name="pageNum" value="1"/>
    <input type="hidden" name="pageSize" value="10"/>
</form>
<div class="pageContent j-resizeGrid">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="add" href="<%=root %>/harbour/pass/toAddPassRule"
                   target="dialog" mask="true" rel="customer_add" resizable="false"
                   maxable="false" minable="false" title="添加通航规则" height="400"
                   width="800"> <span>添加通航规则</span>
            </a></li>
        </ul>
    </div>
    <div class="pageHeader">
        <form onsubmit="return navTabSearch(this);" method="POST"
              action="<%=root %>/harbour/pass/passRuleList">
            <div class="searchBar">
                <table class="searchContent">
                    <tr>
                        <td>规则编号：<input type="text" id="length" name="nickName"
                                        value="${berth.length}" maxlength="50"/>
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
            <th>规则内容</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${passRuleList}" var="item" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${item.id}</td>
                <td>${item.conent}</td>
                <td>
                    <a href="<%=root %>/harbour/pass/showDetail/${item.id}"
                       target="dialog" mask="true" rel="channel_show"
                       title="查看详情" height="400" width="500" class="btnView">查看详情</a>
                    <a href="<%=root %>/harbour/pass/toUpdate?id=${item.id}"
                       target="dialog" mask="true" rel="channel_update" title="更新航道"
                       height="400" width="800" class="btnEdit">更新</a>
                    <a href="<%=root %>/harbour/pass/delete?id=${item.id}" class="btnDel" title="确定要删除么"
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

