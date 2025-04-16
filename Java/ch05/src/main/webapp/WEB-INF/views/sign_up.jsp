<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 25. 4. 16.
  Time: 오후 3:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignUp</title>
</head>
<body>
    This Page is Sign Up

    <form action = "/signUpConfirm">
        ID: <input type="text" name="id" /><br/>
        NAME: <input type="text" name="name" /><br/>
        EMAIL: <input type="text" name="email" /><br/>
        PASSWORD: <input type="password" name="password" /><br/>

        <input type="submit" value="회원가입" />
        <input type="reset" value="취소" />
    </form>
</body>
</html>