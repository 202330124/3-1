<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 25. 5. 28.
  Time: 오전 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>회원 리스트</title>
</head>
<body>
    <form:form modelAttribute="cmd">
        <p>
            <label>from: <form:input path="from" /></label>
            <form:errors path="from" />
            ~
            <label>to: <form:input path="to" /></label>
            <form:errors path="to" />

            <input type="submit" value="조회" />
        </p>

        <c:if test="${ ! empty members }">
            <table>
                <tr>
                    <th>아이디</th><th>이메일</th><th>이름</th><th>가입일</th>
                </tr>
                <c:forEach var="mem" items="${members}">
                    <tr>
                        <td>${mem.id}</td>
                        <td>${mem.email}</td>
                        <td>${mem.name}</td>
                        <td>${mem.registerDateTimeFormatted}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </form:form>
</body>
</html>