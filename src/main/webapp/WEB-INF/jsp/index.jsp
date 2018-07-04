<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>电影-在线电影</title>
    <link rel="shortcut icon" href="favicon.ico" charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../css/movie.css" />
    <link rel="stylesheet" type="text/css" href="../bootstrap-3.3.7/css/bootstrap.css" />
    <script type="text/javascript" src="../js/index.js"></script>
    <script type="text/javascript" src="../bootstrap-3.3.7/js/jquery.min.js"></script>
    <script type="text/javascript" src="../bootstrap-3.3.7/js/bootstrap.js"></script>
    <script type="text/javascript" >
        $(function () {

        });
    </script>
</head>
<body>
<div class="container rootdiv">

    <a href="javascript:scroll(0,0)" class="go-top"  >
        回到顶部<span class="glyphicon glyphicon-arrow-up"></span>
    </a>
    <div class="search-fix">
        <div class="search">
            <!-- s搜索-->
            <div class="fleft">
                <form>
                    <input type="text" placeholder="请输入电影名称" class="search-bar" autocomplete="off" maxlength="30">
                    <input type="submit" class="search-btn" value="搜片">
                </form>
            </div>
            <!-- 搜索右边的登陆等组建-->
            <div class="behavior">
                <a> <span class="glyphicon glyphicon-heart-empty"></span> 收藏</a>
                <a> <span class="glyphicon glyphicon-user"></span> 登陆</a>
            </div>
        </div>
    </div>
    <!-- 轮播图-->
    <div class="bs-example">
        <div id="carousel-example-captions" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <!-- 小圆圈-->
                <li data-target="#carousel-example-captions" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-captions" data-slide-to="1" class=""></li>
                <li data-target="#carousel-example-captions" data-slide-to="2" class=""></li>
                <li data-target="#carousel-example-captions" data-slide-to="2" class=""></li>
            </ol>

            <div class="carousel-inner loop" role="listbox">
                <!-- 第一张图片-->
                <div class="item active ">
                    <a href="#"> <img  class="loopimg" src="../images/loop1.jpg" data-holder-rendered="true"></a>
                </div>
                <!-- 第二张图片-->
                <div class="item">
                    <a href="#"> <img class="loopimg"  src="../images/loop2.jpg" data-holder-rendered="true"></a>
                </div>
                <!-- 第三张图片-->
                <div class="item">
                    <a href="#"> <img class="loopimg"  src="../images/loop3.jpg" data-holder-rendered="true"></a>
                </div>
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
                    <li><a href="http://www.baofeng.com/tv.html" title="剧集" target="_blank">剧集</a></li>
                    <li><a href="http://www.baofeng.com/movie.html" title="电影" target="_blank">电影</a></li>
                    <li><a href="http://www.baofeng.com/comic.html" title="动漫" target="_blank">动漫</a></li>
                    <li><a href="http://www.baofeng.com/enc.html" title="综艺" target="_blank">综艺</a></li>
                    <li><a href="http://sports.baofeng.com/" title="体育" target="_blank">体育</a></li>
                    <li><a href="http://www.baofeng.com/edu/881/list-type-66-ishot-1-sid-1-p-1.shtml" title="教育" target="_blank">教育</a></li>
                    <li><a href="http://www.baofeng.com/bbc/580/list-type-63-ishot-1-sid-1-p-1.shtml" title="记录" target="_blank">记录</a></li>
                    <li><a href="http://hd.baofeng.com/edu/651/list-type-66-cateid-8051-ishot-1-sid-1-p-1.shtml" title="亲子" target="_blank">亲子</a></li>
                    <li><a href="http://hd.baofeng.com/edu/197/list-type-66-areaid-67-ishot-1-sid-1-p-1.shtml" title="生活" target="_blank">生活</a></li>
                    <li><a href="http://hd.baofeng.com/topic/hesuipian.html" title="全景" target="_blank">全景</a></li>
                </ul>
    </div>

    <!-- 电影-->
    <div class="movie-show">
        <div class="cat-movie-show">
            <!-- 电影分类名称-->
            <div class="cat-movie">
                <div class="fleft first"><span class="cat-context">电影</span>  <a>更多>></a></div>
                <div class="fleft"><span class="movie-rank">电影榜</span></div>
            </div>
            <!-- 电影分类的具体电影-->
            <div class="movie-items">
            <div class="movie-item">
                <div class="movie-img">
                    <a href="#"><img src="../images/movie-item.jpg"></img></a>
                </div>
                <div class="movie-desc"><a  href="#"  class="movie-title">猫和老鼠</a><span class="movie-score">8</span></div>
            </div>
            <div class="movie-item">
                <div class="movie-img">
                    <a href="#"><img src="../images/movie-item.jpg"></img></a>
                </div>
                <div class="movie-desc"><a  href="#"  class="movie-title">猫和老鼠</a><span class="movie-score">8</span></div>
            </div>
            <div class="movie-item">
                <div class="movie-img">
                    <a href="#"><img src="../images/movie-item.jpg"></img></a>
                </div>
                <div class="movie-desc"><a  href="#"  class="movie-title">猫和老鼠</a><span class="movie-score">8</span></div>
            </div>
        </div>

            <div class="rank-items">
                <ul>
                    <li class="rank-item"><span>1</span><span><a href="#">红玫瑰</a></span><span class="movie-score">7.8</span></li>
                    <li class="rank-item"><span>2</span><span><a href="#">红玫瑰dasdasd</a></span><span class="movie-score">7.8</span></li>
                    <li class="rank-item"><span>3</span><span><a href="#">红玫瑰fasdqwe</a></span><span class="movie-score">7.8</span></li>
                    <li class="rank-item"><span>4</span><span><a href="#">红玫瑰asgfasfgasdas</a></span><span class="movie-score">7.8</span></li>
                </ul>

            </div>
        </div>


        <div class="cat-movie-show">
            <!-- 电影分类名称-->
            <div class="cat-movie">
                <div class="fleft first"><span class="cat-context">电影</span>  <a>更多>></a></div>
                <div class="fleft"><span class="movie-rank">电影榜</span></div>
            </div>
            <!-- 电影分类的具体电影-->
            <div class="movie-items">
                <div class="movie-item">
                    <div class="movie-img">
                        <a href="#"><img src="../images/movie-item.jpg"></img></a>
                    </div>
                    <div class="movie-desc"><a  href="#"  class="movie-title">猫和老鼠</a><span class="movie-score">8</span></div>
                </div>
                <div class="movie-item">
                    <div class="movie-img">
                        <a href="#"><img src="../images/movie-item.jpg"></img></a>
                    </div>
                    <div class="movie-desc"><a  href="#"  class="movie-title">猫和老鼠</a><span class="movie-score">8</span></div>
                </div>
                <div class="movie-item">
                    <div class="movie-img">
                        <a href="#"><img src="../images/movie-item.jpg"></img></a>
                    </div>
                    <div class="movie-desc"><a  href="#"  class="movie-title">猫和老鼠</a><span class="movie-score">8</span></div>
                </div>
            </div>

            <div class="rank-items">
                <ul>
                    <li class="rank-item"><span>1</span><span><a href="#">红玫瑰</a></span><span class="movie-score">7.8</span></li>
                    <li class="rank-item"><span>2</span><span><a href="#">红玫瑰</a></span><span class="movie-score">7.8</span></li>
                    <li class="rank-item"><span>3</span><span><a href="#">红玫瑰</a></span><span class="movie-score">7.8</span></li>
                    <li class="rank-item"><span>4</span><span><a href="#">红玫瑰</a></span><span class="movie-score">7.8</span></li>
                </ul>

            </div>
        </div>



    </div>



</div>
</body>
</html>
