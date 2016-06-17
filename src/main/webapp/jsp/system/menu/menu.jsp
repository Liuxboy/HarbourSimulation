<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String root = request.getContextPath();%>
<!--菜单-->
<div class="accordion" fillSpace="sidebar">
    <!-- 一级目录 -->
    <div class="accordionContent">
        <!-- 二级目录 -->
        <ul class="tree treeFolder">
            <!-- 三级目录 -->
            <li><a>参数配置</a>
                <ul>
                    <li><a href="<%=root %>/harbour/channel/channelList" target="navTab" rel="channel" title="航道设置">航道设置</a>
                    </li>
                </ul>
                <ul>
                    <li><a href="<%=root %>/harbour/berth/berthList" target="navTab" rel="berth" title="泊位设置">泊位设置</a>
                    </li>
                </ul>
                <ul>
                    <li><a href="<%=root %>/harbour/anchorage/anchorageList" target="navTab" rel="anchorage" title="锚地设置">锚地设置</a>
                    </li>
                </ul>
                <ul>
                    <li><a href="<%=root %>/harbour/ship/shipList" target="navTab" rel="ship" title="船舶设置">船舶设置</a>
                    </li>
                </ul>
                <ul>
                    <li><a href="<%=root %>/harbour/time" target="navTab" rel="time" title="时间设置">时间设置</a>
                    </li>
                </ul>
            </li>
            <li><a>显示模块</a>
                <ul>
                    <li><a href="<%=root %>/harbour/simulation" target="navTab" rel="simulation" title="仿真显示">仿真显示</a>
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
