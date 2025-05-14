<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 25. 5. 14.
  Time: 오전 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
    <form:form modelAttribute="loginCommand">
        <form:errors />

        <p>
            <label>Email</label>
            <form:input path="email" />
            <form:errors path="email" />
        </p>

        <p>
            <label>Password</label>
            <form:input path="password" />
            <form:errors path="password" />
        </p>

        <input type="submit" value="Login" />

        <p>
            <label>이메일 기억하기</label>
            <form:checkbox path="rememberEmail" />
        </p>
    </form:form>
</body>
</html>.
