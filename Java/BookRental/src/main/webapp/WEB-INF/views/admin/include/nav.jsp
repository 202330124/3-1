<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="<c:url value='/resources/css/admin/include/nav.css' />" rel="stylesheet" type="text/css">

<nav>
    <div id="nav_wrap">
        <div class="menu">
            <ul>
                <li><a href="<c:url value='/admin/account/loginForm' /> ">로그인</a></li>
                <li><a href="<c:url value='/admin/account/createAccountForm' /> ">회원가입</a></li>
            </ul>
        </div>

        <div class="search">
            <form>
                <input type="text" name="b_name" placeholder="Enter the name of book you are looking for." />
                <input type="button" value="Search" />
            </form>
        </div>
    </div>
</nav>