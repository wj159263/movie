<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="../../js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="../../js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="../../js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<form id="videoAddForm" method="post">
    <div>
        <input class="easyui-validatebox" type="hidden" name="videoId" />
    </div>
    <div>
        <label for="title">视频标题:</label>
        <input class="easyui-validatebox" type="text" name="title"/>
    </div>
    <div>
        <label for="name">视频名称:</label>
        <input class="easyui-validatebox" type="text" name="name"/>
    </div>
    <div>
        <label for="image">视频图片:</label>
        <td>
            <img id="vimg" src="" name="image"/>
            <a id="pic" href="javascript:void(0)" class="easyui-linkbutton picFileUpload">上传图片</a>
            <input type="hidden" name="image"/>
        </td>
    </div>
    <div>
        <a href="javascript:void(0)" class="easyui-linkbutton selectVideoCat">选择类目</a>
        <span class="showCat" name="cId"></span>
        <input type="hidden" id="shidden" class="show-hidden" name="cId"></input>
    </div>
    <div>
        <label for="playurl">播放地址:</label>
        <input class="easyui-validatebox" type="text" name="playurl"/>
    </div>
    <div>
        <label for="showTime">上映时间:</label>
        <input class="easyui-datebox" id="dd"  name="showTime" data-options="showSeconds:false,editable:false" style="width:150px"></input>
    </div>
    <div>
        <label for="country">国家地区:</label>
        <select name="country">
            <option value="大陆">大陆</option>
            <option value="港台">港台</option>
            <option value="欧美">欧美</option>
            <option value="其他">其他</option>
        </select>
    </div>
    <div>
        <label for="playtimes">播放次数:</label>
        <input class="easyui-validatebox" type="text" name="playtimes"/>
    </div>
    <div>
        <label for="score">视频评分:</label>
        <input class="easyui-validatebox" type="text" name="score"/>
    </div>
    <div>
        <label for="state">视频状态:</label>
        <input class="easyui-validatebox" type="text" name="state"/>
    </div>
    <div>
        <label for="introduce">视频简介:</label>
        <textarea style="width:800px;height:300px;" name="introduce"></textarea>
    </div>

</form>

<script type="text/javascript">
    var itemAddEditor ;
    $(function () {

        itemAddEditor = movie.createEdit("#videoAddForm [name=introduce]");
        movie.initPicUpload();
        movie.initVideoCat();
        var row = $('#dg').datagrid("getSelected");

        var show = row.showTime;
        var date = new Date(show);
        var result= date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate();

        $("#videoAddForm").form('load',{
            videoId:row.videoId,
            title:row.title,
            name:row.name,
            image:row.image,
            cId:(row.category).cName,
            playurl:row.playurl,
            showTime:result,
            country:row.country,
            playtimes:row.playtimes,
            score:row.score,
            state:row.state,
            introduce:row.introduce
        });
        itemAddEditor.html(row.introduce);
        $("#vimg").attr("src",row.image);
        $(".showCat").text((row.category).cName);

    });
</script>
