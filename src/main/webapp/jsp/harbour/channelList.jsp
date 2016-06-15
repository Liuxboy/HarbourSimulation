<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%String root = request.getContextPath();%>
<form id="pagerForm" onsubmit="return navTabSearch(this);" method="POST" action="<%=root %>/harbour/channelList">
    <input type="hidden" name="pageNum" value="1"/>
    <input type="hidden" name="pageSize" value="10"/>
</form>
<div class="pageContent j-resizeGrid">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="add" href="<%=root %>/harbour/toAddChannel"
                   target="dialog" mask="true" rel="customer_add" resizable="false"
                   maxable="false" minable="false" title="添加航道信息" height="400"
                   width="800"> <span>添加航道信息</span>
            </a></li>
        </ul>
    </div>
    <div class="pageHeader">
        <form onsubmit="return navTabSearch(this);" method="POST"
              action="<%=root %>/harbour/channelList">
            <div class="searchBar">
                <table class="searchContent">
                    <tr>
                        <td>航道编号：<input type="text" id="number" name="number"
                                        value="${berth.length}" maxlength="50"/>
                        </td>
                        <td>航道长度：<input type="text" id="length" name="length"
                                        value="${berth.length}" maxlength="50"/>
                        </td>
                        <td>航道宽度：<input type="text" id="width" name="width"
                                        value="${berth.width}" maxlength="50"/>
                        </td>
                        <td>航道水深：<input type="text" id="depth" name="depth"
                                        value="${berth.depth}" maxlength="50"/>
                        </td>
                        <td>航道左下坐标：<input type="text" id="lowerLeftCorner" name="lowerLeftCorner"
                                          value="${berth.lowerLeftCorner}" maxlength="50"/>
                        </td>
                        <td>航道右上坐标：<input type="text" id="upperRightCorner" name="upperRightCorner"
                                          value="${berth.upperRightCorner}" maxlength="50"/>
                        </td>
                        <td>通航模式：<input type="text" id="passEnum" name="passEnum"
                                        value="${berth.number}" maxlength="50"/>
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
    <table class="table" width="100%" layoutH="135">
        <thead>
        <tr>
            <th>航道航道编号</th>
            <th>航道长度</th>
            <th>航道宽度</th>
            <th>航道水深</th>
            <th>航道左下坐标</th>
            <th>航道右上坐标</th>
            <th>通航模式</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${channelList}" var="channel">
            <tr>
                <td>${channel.id}</td>
                <td>${channel.followingNo}</td>
                <td>${channel.fansNo}</td>
                <td>${channel.subscribedFansNo}</td>
                <td>${channel.subscribeNo}</td>
                <td><a href="<%=root %>/harbour/toUpdate?id=${channel.id}"
                       target="dialog" mask="true" rel="channel_update" title="航道信息"
                       height="400" width="800" class="btnEdit">更新</a>
                </td>
                <td>
                    <a href="<%=root %>/harbour/channel/delete?id=${channel.id}" class="btnDel" title="确定要删除么"
                       target="ajaxTodo">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <!--分页页面组件 -->
    <div class="panelBar">
        <div class="pages">
            <span>每页</span>
            <select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
                <option value="20" ${pageParam.pageSize eq 20 ? 'selected':''}>20</option>
                <option value="50" ${pageParam.pageSize eq 50 ? 'selected':''}>50</option>
                <option value="100" ${pageParam.pageSize eq 100 ? 'selected':''}>100</option>
                <option value="200" ${pageParam.pageSize eq 200 ? 'selected':''}>200</option>
            </select>
            <span>满足条件的记录总数: ${pageParam.totalCount}</span>
        </div>
        <div class="pagination" targetType="navTab" totalCount="${pageParam.totalCount}"
             numPerPage="${pageParam.pageSize}"
             pageNumShown="10" currentPage="${pageParam.pageNum}"></div>
    </div>
</div>

