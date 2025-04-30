<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 25. 4. 30.
  Time: 오전 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Step - 1</title>
</head>
<body>
    <h2>Step - 1(약관 동의)</h2>
    <p>약관 내용</p>
    <form action="step2" method="post">
        <label>
            <input type="checkbox" name="agree" value="true">약관동의
        </label>
        <br>
        <input type="submit" value="다음 단계로 이동">
    </form>
</body>
</html>