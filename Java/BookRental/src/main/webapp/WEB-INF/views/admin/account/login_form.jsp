<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 25. 4. 30.
  Time: 오후 4:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="../../include/title.jsp" />
    <link href="<c:url value='/resources/css/admin/login_form.css' />" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="../../include/header.jsp" />
<jsp:include page="../include/nav.jsp" />
<section>
    <div id="section_wrap">
        <div class="word">
            <h3>LOGIN FORM</h3>
        </div>
        <div class="login_form">
            <form method="post" action="<c:url value='/admin/account/loginConfirm' />" name="login_form">
                <input type="text" name="id" placeholder="input admin id" /><br/>
                <input type="password" name="password" placeholder="input admin password" /><br/>

                <input type="button" value="login" onclick="doLogin()">
                <input type="reset" value="reset">
            </form>
        </div>
        <div class="find_password_create_account">
            <a href="<c:url value='/admin/account/findPasswordForm' />" >find password</a>
            <a href="<c:url value='/admin/account/admin/account/createAccountForm' />" >create account</a>
        </div>
    </div>
</section>
<jsp:include page="../../include/footer.jsp" />
<script type="text/javascript">
    function doLogin() {
        let form = document.login_form;

        // TODO form validation 체크
        form.submit();
    }
</script>
</body>
</html>