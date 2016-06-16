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
                    <li><a href="<%=root %>/harbour/channelList" target="navTab" rel="channelList" title="航道设置">航道设置</a>
                    </li>
                </ul>
                <ul>
                    <li><a href="<%=root %>/harbour/berthList" target="navTab" rel="berthList" title="码头设置">码头设置</a>
                    </li>
                </ul>
                <ul>
                    <li><a href="<%=root %>/harbour/anchorageList" target="navTab" rel="anchorageList" title="锚地设置">码头设置</a>
                    </li>
                </ul>
                <ul>
                    <li><a href="<%=root %>/harbour/shipList" target="navTab" rel="berthList" title="船舶设置">船舶设置</a>
                    </li>
                </ul>
                <ul>
                    <li><a href="<%=root %>/harbour/timeConfig" target="navTab" rel="timeConfig" title="时间设置">时间设置</a>
                    </li>
                </ul>
                <ul>
                    <li><a href="<%=root %>/harbour/result" target="navTab" rel="result" title="仿真结果">仿真结果</a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
    <%--
    <div class="accordionHeader">
        <h2><span>Folder</span>系统管理</h2>
    </div>
    <div class="accordionContent">
        <ul class="tree treeFolder">
            <li><a href="/manage/wallet/property/query" target="navTab" rel="property_list">Key-Value配置</a></li>
        </ul>
    </div>
    --%>
</div>
