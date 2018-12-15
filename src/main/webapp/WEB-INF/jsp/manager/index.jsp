<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp"%>
<html>

<style>
    @font-face{
        font-family:'icomoon';
        src:url('../../css/fonts/icomoon.eot');
        src:url('../../css/fonts/icomoon.eot?#iefix') format('embedded-opentype'),
        url('../../css/fonts/icomoon.woff') format('woff'),
        url('../../css/fonts/icomoon.ttf')  format('truetype'),
        url('../../css/fonts/icomoon.svg#SofiaProLight')  format('svg');
        font-weight:normal;
        font-style:normal;
    }
    span.icom {
        font-family:'icomoon' ;
    }


</style>

<head>
    <title>后台管理系统</title>
    <%@include file="../common/link.jsp"%>
</head>
<body>

<div id="cc" class="easyui-layout" data-options="fit:true" >
    <div data-options="region:'west',title:'菜单',split:true" style="width:180px;">
        <ul id="menu" class="easyui-tree" style="margin-top: 10px;margin-left: 5px;">
            <li>
                <span>视频管理</span>
                <ul>
                    <li data-options="attributes:{'url':'/gopage/manager/video-add'}">新增视频</li>
                    <li data-options="attributes:{'url':'/gopage/manager/video-list'}">查询视频</li>
                </ul>
            </li>
            <li>
                <span>首页管理</span>
                <ul>
                    <li data-options="attributes:{'url':'/gopage/manager/loop'}">轮播图管理</li>
                </ul>
            </li>
        </ul>
    </div>

    <div data-options="region:'center',title:''" style="padding:5px;background:#eee;">
        <div id="tt" class="easyui-tabs" data-options="fit:true">
            <div title=" <span class='icom'></span>">

            </div>

        </div>
    </div>
</div>
<script type="text/javascript">
    $(function () {


        $('#menu').tree({
            // 在用户点击的时候
            onClick: function(node){
                if($('#menu').tree("isLeaf",node.target)) {
                    if ($('#tt').tabs('exists', node.text)) {
                        $('#tt').tabs('select', node.text);
                    } else {
                        $('#tt').tabs('add', {
                            title: node.text,
                            href: node.attributes.url,
                            closable: true
                        });
                    }


                }
            }
        });


    });
</script>
</body>
</html>
