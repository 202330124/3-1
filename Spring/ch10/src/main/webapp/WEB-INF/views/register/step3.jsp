<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 25. 4. 30.
  Time: 오후 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Step - 3</title>
</head>
<body>
    <h2>Step - 3(회원가입 완료)</h2>
    <p>
        <strong>${registerRequest.name}님</strong>
    </p>
    <p>회원가입을 완료하였습니다.</p>
    <br/><br/>
    <a href="<c:url value='/register/step1'/>">[첫 화면으로 이동]</a>
</body>
</html>