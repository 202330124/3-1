<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 25. 4. 30.
  Time: 오전 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Step - 2</title>
</head>
<body>
    <h2>Step - 2(회원가입)</h2>
    <form:form action="step3" modelAttribute="registerRequest">
        <p>
            <label for="email">이메일: </label>
            <form:input path="email" />
        </p>

        <p>
            <label for="name">이름: </label>
            <form:input path="name" />
        </p>

        <p>
            <label for="password">비밀번호: </label>
            <form:password path="password" />
        </p>

        <p>
            <label for="confirmPassword">비밀번호 확인: </label>
            <form:password path="confirmPassword" />
        </p>

        <input type="submit" value="가입 완료" />
    </form:form>
</body>
</html>