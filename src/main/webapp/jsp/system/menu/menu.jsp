<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
                    <li><a href="/harbour/config" target="navTab" rel="trade_list" title="icon配置">交易统计</a>
                    </li>
                </ul>
            </li>

            <li><a>订阅管理</a>
                <ul>
                    <li><a href="/harbour/subscribe/list" target="navTab" rel="subscribe_list" title="banner配置">订阅统计</a>
                    </li>
                </ul>
            </li>

            <li><a>关注管理</a>
                <ul>
                    <li><a href="/harbour/follow/list" target="navTab" rel="banner_list" title="banner配置">关注统计</a>
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
