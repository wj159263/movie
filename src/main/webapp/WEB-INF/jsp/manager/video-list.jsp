<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table id="dg"></table>
<div id="win"></div>
<script type="text/javascript">
$(function () {
    $('#dg').datagrid({
        rownumbers:true,
        nowrapL:true,
        pageSize : 10,
        //idField 不写的话，复选框选中数据翻页时，之前页面选中的数据会变没选中。
        idField:'videoId',
        pageList:[1,5,10,20,50],
        pagination:true,
            queryParams: {
                name: '%%'
            },
            //singleSelect:true,
        fit:true,
        url:'/video/list',
        columns:
            [[
                {
                    field:'',
                    checkbox:true,
                },
            {field:'videoId',title:'视频id',width:100},
            {field:'name',title:'名字',width:100},
            {field:'title',title:'标题',width:100},
            {field:'image',title:'图片',width:100},
            {field:'category',title:'分类',width:100,
                formatter: function(value,row,index){
                    if(value){
                        return value.cName;
                    }
                }
            },
            {field:'playurl',title:'播放地址',width:100},
            {field:'showTime',title:'上映时间',width:100,
                formatter: function(value,row,index){
                    if(value){
                        var date = new Date(value);
                        return date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate();
                    }
                }
            },
            {field:'country',title:'地区',width:100},
            {field:'playtimes',title:'播放次数',width:100},
            {field:'score',title:'评分',width:100},
            {field:'state',title:'状态',width:100},
            {field:'introduce',title:'简介',width:100},
            {field:'videoDetail',title:'上传者',width:100,
                formatter: function(value,row,index){
                    if(value){
                        return value.user.nickName;
                    }
                }
            },
            {field:'videoDetail',title:'上传时间',width:100,
                formatter: function(value,row,index){
                    if(value){
                        var time = value.uptime;
                        var date = new Date(time);
                        var timestamp =" "+ date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
                       return date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate() + timestamp;
                    }
                }
            },
            {field:'videoDetail',title:'更新时间',width:100,
                formatter: function(value,row,index){
                    if(value){
                        var time = value.updated;
                        var date = new Date(time);
                        var timestamp =" "+ date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
                        return date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate() + timestamp;
                    }
                }
            }
        ]],
        toolbar: [
            {
                iconCls: ""

            },'-',{
            text:"修改",
            iconCls: 'icom-edit',
            handler: function(){
                var arr = $('#dg').datagrid("getSelections");
                if (arr.length <= 0 ){
                    return;
                }
                if(arr.length > 1){
                    $.messager.show({
                        title:'提示',
                        msg:'修改时只能选中1条数据!',
                        timeout:1500,
                        showType:'slide',
                        closable:false,
                        style:{
                            right:'',
                            top:document.body.scrollTop+document.documentElement.scrollTop,
                            bottom:''
                        }
                    });
                    return ;
                }
                //todo dasda
                $('#win').window({
                    width:1200,
                    height:600,
                    title:"修改页面",
                    modal:true,
                    href : "/manager/video-edit"
                });

            }
        },'-',{
            text:"删除",
            iconCls: 'icom-delete',
            handler: function(){
                var arr = $('#dg').datagrid("getSelections");
                var ids = [];
                for(e in arr){
                    ids.push(arr[e].videoId);
                }
                $.messager.confirm('确认','您确认想要删除记录吗？',function(r){
                    if (r){
                        $.ajax({
                            url : '/video/sudo/deletebach',
                            method:'POST',
                            //traditional:true不写时,则controller接收不是ids，而是ids[]
                            traditional:true,
                            data:{ids:ids},
                            dataType:'json',
                            success: function (data) {
                                if((data.state) == 200){
                                    $.messager.alert('',"成功删除了"+data.data+"条记录！",'info');
                                }else{
                                    $.messager.alert('删除错误','请联系管理员！','error');
                                }
                                //重新刷新页面
                                $("#dg").datagrid("reload");
                                //请除所有勾选的行
                                $("#dg").datagrid("clearSelections");
                            },error: function (XMLHttpRequest, textStatus, errorThrown) {
                                $.messager.alert('删除错误','请联系管理员！','error');
                            }
                        });
                    }
                });

            }
        },'-',{
                text:"地址：<input type='text' id='searchbox' name='name'/>",
            }]

    }

    );


    $('#searchbox').searchbox({
        searcher:function(value,name){
            $('#dg').datagrid('load', {
                name: "%"+value+"%"
            });
        },
        prompt:'请输入值'
    });

});
</script>
<style>
    span.icom-edit::before {
        font-family:'icomoon' ;
        font-size: 16px;
        content: '\e905';
    }
    span.icom-delete::before {
        font-family:'icomoon' ;
        font-size: 16px;
        content: '\e9ac';
    }

</style>

