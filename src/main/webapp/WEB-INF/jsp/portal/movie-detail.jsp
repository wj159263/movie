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
    <link rel="shortcut icon" href="../../images/favicon.ico" charset="utf-8">

</head>
<body>
    <div class="container">
        <jsp:include page="../common/searchArea.jsp"></jsp:include>
        <div class="m-detail">
            <h3>${video.name}</h3>
            <div class="movie-detail">
                <div class="m-detail-img"><img src="${video.image}" width="200px" height="300px" />
                    <div class="play-movie-btn">
                        <a href="#" class="play-movie">播放</a>
                        <a href="#" class="play-movie">收藏</a>
                    </div></div>
                <div class="m-detail-info">
                    <ul>
                        <li>上映国家 ： ${video.country}</li>
                        <li>上映时间 ：<fmt:formatDate value="${video.showTime}" pattern="yyyy-MM-dd"></fmt:formatDate></li>
                        <li>评  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  分 ：${video.score}</li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="introduce-div">
            <h2 class="introduce">简介</h2>
            <p>${video.title}</p>

        </div>
        <div class="comment-div">
            <h2 class="comment">评论</h2>
            评论评论评论评论评论评论评论评论评论
            <p>
            </p>
        </div>
    </div>
</body>
</html>