<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/12/14
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp"%>
<%@include file="/WEB-INF/jsp/common/link.jsp"%>
<div class="search-fix">
    <div class="search">
        <!-- s搜索-->
        <div class="fleft">
            <form id="searchForm" onsubmit="return validateForm()" target="_blank">
                <input type="text" name="videoName" placeholder="请输入电影名称" class="search-bar" autocomplete="off" maxlength="30">
                <input type="submit" class="search-btn"   value="搜片">
            </form>
        </div>
        <!-- 搜索右边的登陆等组建-->
        <div class="behavior">
            <a href="/sub/selectByUser"> <span class="glyphicon glyphicon-heart-empty"></span> 收藏</a>
            <c:choose>
                <c:when test="${empty SysUser}">
                    <a href="/gopage/user/login"> <span class="glyphicon glyphicon-user"></span> 登陆</a>
                </c:when>
                <c:otherwise>
                    <a href="#"> <span class="glyphicon glyphicon-home"></span> ${SysUser.nickName}</a>
                </c:otherwise>
            </c:choose>

        </div>
    </div>
</div>
<script type="text/javascript">
    function validateForm() {
        var data = $(":input.search-bar").val();
        if (data){
            $("#searchForm").attr("action","/video/selectByName");
            return true;
        }
        return false;
    }
</script>
