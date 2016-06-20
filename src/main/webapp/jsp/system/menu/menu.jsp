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
                    <li><a href="<%=root %>/harbour/anchorage/toList" target="navTab" rel="anchorage" title="锚地设置">锚地设置</a>
                    </li>
                </ul>
                <ul>
                    <li><a href="<%=root %>/harbour/channel/toList" target="navTab" rel="channel" title="航道设置">航道设置</a>
                    </li>
                </ul>
                <ul>
                    <li><a href="<%=root %>/harbour/berth/toList" target="navTab" rel="berth" title="泊位设置">泊位设置</a>
                    </li>
                </ul>
                <ul>
                    <li><a href="<%=root %>/harbour/ship/toList" target="navTab" rel="ship" title="船舶设置">船舶设置</a>
                    </li>
                </ul>
                <ul>
                    <li><a href="<%=root %>/harbour/traffic/toList" target="navTab" rel="travel" title="交通管制">交通管制</a>
                    </li>
                </ul>
                <ul>
                    <li><a href="<%=root %>/harbour/time/toList" target="navTab" rel="time" title="时间设置">时间设置</a>
                    </li>
                </ul>
            </li>
            <li><a>显示模块</a>
                <ul>
                    <li><a href="<%=root %>/harbour/simulation/toList" target="navTab" rel="simulation" title="仿真显示">仿真显示</a>
                    </li>
                </ul>
                <ul>
                    <li><a href="<%=root %>/harbour/result/toList" target="navTab" rel="result" title="仿真结果">仿真结果</a>
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
