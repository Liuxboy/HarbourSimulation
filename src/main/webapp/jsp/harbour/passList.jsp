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
    <%--<div class="panelBar">
        <ul class="toolBar">
            <li><a class="add" href="<%=root %>/harbour/pass/toAddPassRule"
                   target="dialog" mask="true" rel="customer_add" resizable="false"
                   maxable="false" minable="false" title="添加通航规则" height="400"
                   width="800"> <span>添加通航规则</span>
            </a></li>
        </ul>
    </div>--%>
    <table class="table" width="100%" layoutH="95%">
        <thead>
        <tr>
            <th>序号</th>
            <th>规则内容</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${passRuleList}" var="item" varStatus="status">
            <tr>
                <td>${item.id}</td>
                <td>${item.passRuleEnum.desc}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

