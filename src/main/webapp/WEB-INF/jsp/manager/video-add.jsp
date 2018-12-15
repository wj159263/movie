<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="../../js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="../../js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="../../js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<script type="text/javascript">

    var itemAddEditor ;
    $(function () {

        itemAddEditor = movie.createEdit("#videoAddForm [name=introduce]");
        movie.initPicUpload();
        movie.initVideoCat();

        //解决子框架嵌套的问题
        if(window != window.parent){
            window.parent.location.reload(true);
        }
    });
    function submitForm(){
        itemAddEditor.sync();
        $.post("/video/sudo/insert",$("#videoAddForm").serialize(), function(data){
            if(data.state == 200){
                $.messager.alert('提示','视频添加成功!');
                $('#videoAddForm').form('reset');
                itemAddEditor.html('');
            }else {
                $.messager.alert('提示','视频添加失败!');
            }
        });
        //$('#videoAddForm').submit();
    }

    function clearForm(){
        $('#videoAddForm').form('reset');
        itemAddEditor.html('');
    }
</script>
<div>
    <div style="padding:10px 10px 10px 10px">
        <form id="videoAddForm" class="videoAddForm" method="post" action="/video/sudo/insert">
            <table cellpadding="5">
                <tr>
                    <td>视频类目:</td>
                    <td>
                        <a href="javascript:void(0)" class="easyui-linkbutton selectVideoCat">选择类目</a>
                        <span class="showCat"></span>
                        <input type="hidden" name="cId"></input>
                    </td>
                </tr>
                <tr>
                    <td>所属地区:</td>
                    <td>
                       <select name="country">
                           <option value="大陆">大陆</option>
                           <option value="港台">港台</option>
                           <option value="欧美">欧美</option>
                           <option value="其他">其他</option>
                       </select>
                    </td>
                </tr>
                <tr>
                    <td>上映时间:</td>
                    <td><input class="easyui-datebox"  name="showTime" data-options="showSeconds:false,editable:false" style="width:150px"></input></td>
                </tr>

                <tr>
                    <td>视频评分:</td>
                    <td><input class="easyui-numberbox" type="text" name="score" data-options="min:0,max:10,precision:1" style="width: 150px;" />

                    </td>
                </tr>
                <tr>
                    <td>视频名称:</td>
                    <td><input class="easyui-textbox" type="text" name="name" style="width: 280px;"></input></td>
                </tr>
                               <tr>
                    <td>视频标题:</td>
                    <td><input class="easyui-textbox" type="text" name="title" style="width: 280px;"></input></td>
                </tr>

                <tr>
                    <td>播放地址:</td>
                    <td><input class="easyui-textbox" type="text" name="playurl" style="width: 280px;"></input></td>
                </tr>


                <tr>
                    <td>视频图片:</td>
                    <td>
                        <a id="pic" href="javascript:void(0)" class="easyui-linkbutton picFileUpload">上传图片</a>
                        <input type="hidden" name="image"/>
                    </td>
                </tr>
                <tr>

                </tr>
                <tr>
                    <td>视频描述:</td>
                    <td>
                        <textarea style="width:800px;height:300px;" name="introduce"></textarea>
                    </td>
                </tr>

            </table>
            <input type="hidden" name="playtimes" value="0"></input>
            <input type="hidden" name="state" value="1"></input>
            <input type="hidden" name="userId" value="2"></input>
        </form>
        <div style="padding:5px">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
        </div>


    </div>



</div>