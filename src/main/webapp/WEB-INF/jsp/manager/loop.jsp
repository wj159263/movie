<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table id="dgloop"></table>
<div id="win"></div>
<script type="text/javascript">
    $(function () {
        $('#dgloop').datagrid({
            rownumbers:true,
            nowrapL:true,
            pageSize : 10,
            //idField 不写的话，复选框选中数据翻页时，之前页面选中的数据会变没选中。
            idField:'videoId',
            pageList:[1,5,10,20,50],
            pagination:true,
            fitColumns:true,
            //singleSelect:true,
            fit:true,
            url:'/loop/list',
                columns:
                    [[
                        {
                            field:'',
                            checkbox:true,
                        },
                        {field:'videoId',title:'视频id',width:100},
                        {field:'name',title:'名字',width:100},
                        {field:'image',title:'图片',width:100}
                    ]],
                toolbar: [
                   {
                        text:"删除",
                        iconCls: 'icom-delete',
                        handler: function(){
                            var arr = $('#dgloop').datagrid("getSelections");
                            var ids = [];
                            for(e in arr){
                                ids.push(arr[e].videoId);
                            }
                            $.messager.confirm('确认','您确认想要删除记录吗？',function(r){
                                if (r){
                                    $.ajax({
                                        url : '/loop/sudo/deletebatch',
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
                                            $("#dgloop").datagrid("reload");
                                            //请除所有勾选的行
                                            $("#dgloop").datagrid("clearSelections");
                                        },error: function (XMLHttpRequest, textStatus, errorThrown) {
                                            $.messager.alert('删除错误','请联系管理员！','error');
                                        }
                                    });
                                }
                            });

                        }
                    }
                    ]

            }

        );
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
    span.icom-loop::before {
        font-family:'icomoon' ;
        font-size: 16px;
        content: '\e90d';
    }

</style>

