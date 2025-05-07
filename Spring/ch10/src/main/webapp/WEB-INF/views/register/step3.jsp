<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 25. 4. 30.
  Time: 오후 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><spring:message code="member.register" /></title>
</head>
<body>
    <h2>Step - 3(회원가입 완료)</h2>
    <p>
        <spring:message code="register.done" arguments="${registerRequest.name}" />
    </p>
    <br/><br/>
    <a href="<c:url value='/register/step1'/>">[<spring:message code="go.main" />]</a>
</body>
</html>