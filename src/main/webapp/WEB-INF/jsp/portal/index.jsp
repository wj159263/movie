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
    <script type="text/javascript" >
        $(function () {
            $("#carousel-example-captions").carousel({
                interval: 5000,
                wrap: true
            });
        });
    </script>
</head>
<body>
<div class="container rootdiv">

    <a href="javascript:scroll(0,0)" class="go-top"  >
        回到顶部<span class="glyphicon glyphicon-arrow-up"></span>
    </a>
    <jsp:include page="../common/searchArea.jsp"></jsp:include>
    <!-- 轮播图-->
    <div class="bs-example">
        <div id="carousel-example-captions" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <!-- 小圆圈-->

                    <c:if test="${not empty centerLoopList}">
                        <c:forEach items="${centerLoopList}" var="loop" varStatus="status">
                            <c:choose>
                                <c:when test="${status.index == 0}">
                                    <li data-target="#carousel-example-captions" data-slide-to="${status.index}" class="active}"></li>
                                </c:when>
                                <c:otherwise>
                                    <li data-target="#carousel-example-captions" data-slide-to="${status.index}"></li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </c:if>

            </ol>

            <div class="carousel-inner loop" role="listbox">
                <c:if test="${not empty centerLoopList}">
                    <c:forEach items="${centerLoopList}" var="loop" varStatus="status">
                        <c:choose>
                            <c:when test="${status.index == 0}">
                                <!-- 第一张图片-->
                                <div class="item active">
                                    <a href="/video/selectSyc/${loop.videoId}" target="_blank"> <img  class="loopimg" src="${loop.image}" width="1138px" height="400px" data-holder-rendered="true"></a>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <!-- 第一张图片-->
                                <div class="item">
                                    <a href="/video/selectSyc/${loop.videoId}" target="_blank"> <img  class="loopimg" src="${loop.image}"  width="1138px" height="400px" data-holder-rendered="true"></a>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </c:if>
            </div>


            <a class="left carousel-control" href="#carousel-example-captions" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#carousel-example-captions" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>

    <!-- 导航分类-->
    <div class="nav-box">
        <ul class="nav-list">
            <c:if test="${not empty categories}">
                <c:forEach items="${categories}" var="category">
                    <li><a href="/video/selectVideoByCate/${category.cId}" title="${category.cName}" target="_blank">${category.cName}</a></li>
                </c:forEach>
            </c:if>

        </ul>
    </div>

    <!-- 电影-->
    <div class="movie-show">

        <c:forEach items="${videoList}" var="data">

        <div class="cat-movie-show">
            <!-- 电影分类名称-->
            <div class="cat-movie">
                <div class="fleft first"><span class="cat-context">${data.cName}</span>  <a onclick="moreViedo(${data.cName})">更多>></a></div>
                <div class="fleft"><span class="movie-rank">电影榜</span></div>
            </div>
            <c:if test="${not empty data.dataList}">
                <c:forEach items="${data.dataList}" var="video">
                <!-- 电影分类的具体电影-->
                    <div class="movie-items">
                    <div class="movie-item">
                        <div class="movie-img">
                            <a href="/video/selectSyc/${video.videoId}" target="_blank"><img src="${video.image}" width="240px" height="180px"></img></a>
                        </div>
                        <div class="movie-desc"><a  href="/video/selectSyc/${video.videoId}" target="_blank" class="movie-title">${video.videoName}</a><span class="movie-score">${video.score}</span></div>
                    </div>

                </div>
                </c:forEach>
            </c:if>
            <div class="rank-items" id="rank-items" style="top: 0px;right: 0px">
                <ul>
                    <li class="rank-item"><span>1</span><span><a href="#">红玫瑰</a></span><span class="movie-score">7.8</span></li>
                    <li class="rank-item"><span>2</span><span><a href="#">红玫瑰dasdasd</a></span><span class="movie-score">7.8</span></li>
                    <li class="rank-item"><span>3</span><span><a href="#">红玫瑰fasdqwe</a></span><span class="movie-score">7.8</span></li>
                    <li class="rank-item"><span>4</span><span><a href="#">红玫瑰asgfasfgasdas</a></span><span class="movie-score">7.8</span></li>
                </ul>

            </div>

        </div>
        </c:forEach>

        </div>



    </div>



</div>
</body>
</html>

