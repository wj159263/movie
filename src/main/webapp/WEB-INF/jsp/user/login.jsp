<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>电影-在线电影</title>
    <%@include file="/WEB-INF/jsp/common/link.jsp"%>
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="../../css/form-elements.css">
    <link rel="shortcut icon" href="../../images/favicon.ico" charset="utf-8">

    <style type="text/css">
       body{
           background-color: #888 !important;
       }
    </style>

    <script type="text/javascript" >
        $(function () {

        });
    </script>
</head>
<body>
<!-- Top content -->
<div class="top-content">
    <div class="inner-bg1">
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <p>请输入您的账号和密码</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-lock"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form role="form" action="/user/login" method="post" class="login-form">
                            <div class="form-group">
                                <label class="sr-only" for="form-username">账号</label>
                                <input type="text" name="account" placeholder="请输入账号" class="form-username form-control" id="form-username">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-password">密码</label>
                                <input type="password" name="password" placeholder="请输入密码" class="form-password form-control" id="form-password">
                            </div>
                            <button type="submit" class="btn">登陆</button>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>

</div>
<div class="backstretch" style="left: 0px; top: 0px; overflow: hidden; margin: 0px; padding: 0px; height: 379px; width: 1349px; z-index: -999999; position: fixed;"><img src="assets/img/backgrounds/3.jpg" style="position: absolute; margin: 0px; padding: 0px; border: none; width: 1349px; height: 899.333px; max-height: none; max-width: none; z-index: -999999; left: 0px; top: -260.167px;">
</div>
</body>
</html>
