<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%String root = request.getContextPath();%>
<form id="pagerForm" onsubmit="return navTabSearch(this);" method="POST" action="<%=root %>/manage/customer/list">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="pageSize" value="10"/>
	<input type="hidden" name="beginTime" value="${customerParam.beginTime}" />
	<input type="hidden" name="endTime" value="${customerParam.endTime}" />
</form>
<div class="pageContent j-resizeGrid">
	<%-- <div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="<%=root %>/manage/customer/forAdd"
				target="dialog" mask="true" rel="customer_add" resizable="false"
				maxable="false" minable="false" title="添加会员信息" height="400"
				width="800"> <span>添加会员信息</span>
			</a></li>
		</ul>
	</div> --%>
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" method="POST"
			action="<%=root %>/manage/customer/list">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>昵称：<input type="text" id="nickName" name="nickName"
							value="${customerParam.nickName}" maxlength="50" />
						</td>
						<td>手机号：<input type="text" id="mobile" name="mobile"
							value="${customerParam.mobile}" maxlength="50" />
						</td>
						<td>会员id：<input type="text" id="customerId" name="customerId"
							value="${customerParam.customerId}" maxlength="50" />
						</td>
					</tr>
					<tr>
						<td>统计时间段： <input class="date   valid "
							datefmt="yyyy-MM-dd HH:mm:ss" name="beginTime" type="text"
							maxlength="20" value="${customerParam.beginTime}" />至 <input
							class="date   valid " datefmt="yyyy-MM-dd HH:mm:ss"
							name="endTime" type="text" maxlength="20"
							value="${customerParam.endTime}" />
						</td>

						<td>排序字段： <select name="listSortField">
								<option value="5" <c:if test="">selected="selected"</c:if>>
								</option>
								<option value="0"
									<c:if test="${customerParam.listSortField eq 0}">selected="selected"</c:if>>关注数</option>
								<option value="1"
									<c:if test="${customerParam.listSortField eq 1}">selected="selected"</c:if>>粉丝数</option>
								<option value="2"
									<c:if test="${customerParam.listSortField eq 2}">selected="selected"</c:if>>被订阅数</option>
								<option value="3"
									<c:if test="${customerParam.listSortField eq 3}">selected="selected"</c:if>>订阅数</option>
								<option value="4"
									<c:if test="${customerParam.listSortField eq 4}">selected="selected"</c:if>>创建时间</option>
						</select>
						</td>
						<td>排序类型：<select name="listSortType">
								<option value="3" <c:if test="">selected="selected"</c:if>>
								</option>
								<option value="0"
									<c:if test="${customerParam.listSortType eq 0}">selected="selected"</c:if>>降序</option>
								<option value="1"
									<c:if test="${customerParam.listSortType eq 1}">selected="selected"</c:if>>升序</option>
						</select>
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

	<table class="table" width="100%" layoutH="135">
		<thead>
			<tr>
				<th>会员id</th>
				<th>关注数</th>
				<th>粉丝数</th>
				<th>被订阅数</th>
				<th>订阅数</th>
				<th>更新</th>
				<th>刷新缓存</th>
				<!-- <th>删除</th> -->
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${customerLists}" var="customer">
				<tr>
					<td>${customer.id}</td>
					<td>${customer.followingNo}</td>
					<td>${customer.fansNo}</td>
					<td>${customer.subscribedFansNo}</td>
					<td>${customer.subscribeNo}</td>
					<td><a
						href="<%=root %>/manage/customer/forUpdate?customerId=${customer.id}"
						target="dialog" mask="true" rel="customer_update" title="会员信息"
						height="400" width="800" class="btnEdit">更新</a></td>
					<td><a
						href="<%=root %>/manage/customer/updateCustomerCache?customerId=${customer.id}"
						class="btnEdit" title="确定要刷新缓存吗"
                       target="ajaxTodo">刷新缓存</a></td>	
					<%--                 <td>
                    <a href="<%=root %>/manage/customer/delete/?customerId=${customer.id}" class="btnDel" title="确定要删除么"
                       target="ajaxTodo">删除</a>
                </td> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!--分页页面组件 -->
	<div class="panelBar">
		<div class="pages">
			<span>每页</span> <select class="combox" name="numPerPage"
				onchange="navTabPageBreak({numPerPage:this.value})">
				<option value="20" ${customerParam.pageSize eq 20 ? 'selected':''}>20</option>
				<option value="50" ${customerParam.pageSize eq 50 ? 'selected':''}>50</option>
				<option value="100" ${customerParam.pageSize eq 100 ? 'selected':''}>100</option>
				<option value="200" ${customerParam.pageSize eq 200 ? 'selected':''}>200</option>
			</select> <span>满足条件的记录总数: ${customerParam.totalCount}</span>
		</div>
		<div class="pagination" targetType="navTab"
			totalCount="${customerParam.totalCount}"
			numPerPage="${customerParam.pageSize}" pageNumShown="10"
			currentPage="${customerParam.pageNum}"></div>
	</div>
</div>
<script>
function cacheCustomer() {
    var r = confirm("亲，你确定更新当前会员缓存信息吗？");
    if (r == true) {
        var url = "<%=root%>/manage/customer/updateCustomerCache";
        var callback = function (result) {

            var msg = "";
            if ("true" == result) {
                msg = "更新当前会员缓存信息成功";
            } else if ("false" == result) {
                msg = "更新当前会员缓存信息失败";
            } else {
                msg = "系统异常";
            }
            alert(msg);
            if ("true" == result) {
                window.returnValue = result;
                window.close();
            }
        }
        $.ajax({
            type: "POST",
            url: url,
            data: "",
            dataType: "text",
            success: callback,
            async: false
        });
    }
}
</script>
