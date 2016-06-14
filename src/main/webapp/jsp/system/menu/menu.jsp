<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String root = request.getContextPath();%>
<!--菜单-->
<div class="accordion" fillSpace="sidebar">
    <div class="accordionHeader">
        <h2><span>Folder</span>运营管理</h2>
    </div>
    <!-- 一级目录 -->
    <div class="accordionContent">
        <!-- 二级目录 -->
        <ul class="tree treeFolder">
            <!-- 三级目录 -->
            <li><a>参数配置</a>
                <ul>
                    <li><a href="<%=root %>/harbour/config" target="navTab" rel="config" title="仿真参数设置">仿真参数设置</a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
    <%--<div class="accordionHeader">
        <h2><span>Folder</span>系统管理</h2>
    </div>
    <div class="accordionContent">
        <ul class="tree treeFolder">
            <li><a href="/manage/wallet/property/query" target="navTab" rel="property_list">Key-Value配置</a></li>
        </ul>
    </div>--%>
</div>
