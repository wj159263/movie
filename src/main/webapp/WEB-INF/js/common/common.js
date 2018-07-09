var movie  = {
    alertf : function () {
        alert(1111);
    },
    kingEditorParams : {
        //指定上传文件参数名称
        filePostName  : "uploadFile",
        //指定上传文件请求的url。
        uploadJson : '/pic/upload',
        //上传类型，分别为image、flash、media、file
        dir : "image"
    },
    createEdit : function (element) {
            return KindEditor.create(element, this.kingEditorParams);
    },
    initVideoCat : function () {
        $('.selectVideoCat').each(function (i,e) {
            $(e).click(function () {
                $("<div id='wind'>").css({padding:"5px"}).html("<ul class='etree'>").window({
                    width: 600,
                    height: 400,
                    top : 50,
                    iconCls:'icon-save',
                    modal: true,
                    title : "选择分类",
                    onOpen : function () {
                        var _win = this;
                        $('ul.etree').tree({
                            url:'/category/list',
                            animate:true,
                            // 在用户点击的时候提示
                            onClick: function(node){
                                if($(this).tree("isLeaf",node.target)){
                                    //每次点击选择类目时，先把显示类目的span清空再填充
                                    $('span.showCat').hide();
                                    $('span.showCat').text("");
                                    $('span.showCat').text(node.text);
                                    $('span.showCat').show();

                                    // e.parentsUntil("td").find("[name=cId]").val(node.id);
                                    $(e).siblings("[name=cId]").val(node.id);
                                    //选好了就关闭窗口
                                    //$('#wind').window("close");
                                    $(_win).window("close");
                                }
                            }

                        });

                    }
                } );
            });
        });
    },
    initPicUpload : function (data) {
        $(".picFileUpload").each(function (i,e) {
            var _ele = $(e);
            _ele.siblings("div.pics").remove();
            _ele.after('\
    			<div class="pics">\
        			<ul></ul>\
        		</div>');
            // 回显图片
            if(data && data.pics){
                var imgs = data.pics.split(",");
                for(var i in imgs){
                    if($.trim(imgs[i]).length > 0){
                        _ele.siblings(".pics").find("ul").append("<li><a href='"+imgs[i]+"' target='_blank'><img src='"+imgs[i]+"' width='80' height='50' /></a></li>");
                    }
                }
            }
            var form = $(e).parentsUntil("form").parent("form");
            //给“上传图片按钮”绑定click事件
            $(e).click(function(){
                //打开图片上传窗口
                KindEditor.editor(movie.kingEditorParams).loadPlugin('multiimage',function(){
                    var editor = this;
                    editor.plugin.multiImageDialog({
                        clickFn : function(urlList) {
                            var imgArray = [];
                            KindEditor.each(urlList, function(i, data) {
                                imgArray.push(data.url);
                                form.find(".pics ul").append("<li><a href='"+data.url+"' target='_blank'><img src='"+data.url+"' width='80' height='50' /></a></li>");
                            });
                            form.find("[name=image]").val(imgArray.join(","));
                            editor.hideDialog();
                        }
                    });
                });
            });
        });

    }
}
