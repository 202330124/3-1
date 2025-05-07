<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 25. 4. 30.
  Time: 오전 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><spring:message code="member.register" /></title>
</head>
<body>
    <h2><spring:message code="member_info" /></h2>
    <form:form action="step3" modelAttribute="registerRequest">
        <p>
            <label for="<spring:message code="email" />">이메일: </label>
            <form:input path="email" />
            <form:errors path="email" />
        </p>

        <p>
            <label for="<spring:message code="name" />">이름: </label>
            <form:input path="name" />
            <form:errors path="name" />
        </p>

        <p>
            <label for="<spring:message code="password" />">비밀번호: </label>
            <form:password path="password" />
            <form:errors path="password" />
        </p>

        <p>
            <label for="<spring:message code="password.confirm" />">비밀번호 확인: </label>
            <form:password path="confirmPassword" />
            <form:errors path="confirmPassword" />
        </p>

        <input type="submit" value="<spring:message code="register.btn" />" />
    </form:form>
</body>
</html>