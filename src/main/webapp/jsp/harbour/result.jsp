<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%String root = request.getContextPath();%>
<div class="pageHeader">
    <form id="pagerForm" onsubmit="return navTabSearch(this);"
          method="POST" action="<%=root %>/harbour/result/start">
        <input type="hidden" name="pageNum" value="1"/>
        <input type="hidden" name="pageSize" value="10"/>
        <input type="hidden" name="flag" value="start"/>
        <div class="searchBar">
            <table class="searchContent">
                <tr>
                    <td>
                        <div class="buttonActive">
                            <div class="buttonContent">
                                <button type="submit">开始仿真</button>
                            </div>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
    </form>
</div>
<div class="pageContent j-resizeGrid">
    <table class="table" width="100%" layoutH="60%">
        <thead>
            <tr>
                <th>序号</th>
                <th>船舶类型</th>
                <th>平均在港时间</th>
                <th>平均等待航道时间</th>
                <th>平均等泊时间</th>
                <th>平均在泊时间</th>
                <th>AWT/AST</th>
                <th>泊位利用率</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${resultList}" var="item" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>
                        <c:choose>
                            <c:when test="${item.shipEnum == null}">总体</c:when>
                            <c:otherwise>
                                ${item.shipEnum.nameCN}
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>${item.avgInHarbourTime}</td>
                    <td>${item.avgWaitChannelTime}</td>
                    <td>${item.avgWaitBerthTime}</td>
                    <td>${item.avgOnBerthTime}</td>
                    <td>${item.awtAstIndex}</td>
                    <td>${item.berthUtilizationRatio}</td>
                    <td>
                        <a href="<%=root %>/harbour/result/delete/${item.shipEnum.typeCode}" class="btnDel" title="确定要删除么"
                           target="ajaxTodo">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

