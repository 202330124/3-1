<%@ page import="daelim.book.rental.kimdaelim.admin.account.AdminAccountVo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="<c:url value='/resources/css/admin/include/nav.css' />" rel="stylesheet" type="text/css">

<nav>
    <div id="nav_wrap">
        <%
            AdminAccountVo loginedAdminAccountVo = (AdminAccountVo) session.getAttribute("loginedAdminAccountVo");

            if(loginedAdminAccountVo != null) {
        %>
        <div class="menu">
            <ul>
                <li><a href="<c:url value='/admin/account/logoutConfirm' /> ">로그아웃</a></li>
                <li><a href="<c:url value='/admin/account/createAccountForm' /> ">계정수정</a></li>

                <c:if test="${loginedAdminAccountVo.id eq 'system'}">
                    <li><a href="<c:url value='/admin/account/createAccountForm' /> ">관리자 목록</a></li>
                </c:if>

                <li><a href="<c:url value='/admin/account/createAccountForm' /> ">대출도서</a></li>
                <li><a href="<c:url value='/admin/account/createAccountForm' /> ">전체도서</a></li>
                <li><a href="<c:url value='/admin/account/createAccountForm' /> ">희망도서(입고처리)</a></li>
                <li><a href="<c:url value='/admin/account/createAccountForm' /> ">도서등록</a></li>
            </ul>
        </div>
        <% } else { %>
        <div class="menu">
            <ul>
                <li><a href="<c:url value='/admin/account/loginForm' /> ">로그인</a></li>
                <li><a href="<c:url value='/admin/account/createAccountForm' /> ">회원가입</a></li>
            </ul>
        </div>
        <% } %>
        <div class="search">
            <form>
                <input type="text" name="b_name" placeholder="Enter the name of book you are looking for." />
                <input type="button" value="Search" />
            </form>
        </div>
    </div>
</nav>