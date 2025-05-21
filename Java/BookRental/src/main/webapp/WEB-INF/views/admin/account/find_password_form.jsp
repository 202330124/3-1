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
    <link href="<c:url value='/resources/css/admin/find_password_form.css' />" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="../../include/header.jsp" />
<jsp:include page="../include/nav.jsp" />
<section>
    <div id="section_wrap">
        <div class="word">
            <h3>FIND PASSWORD FORM</h3>
            <p>(We will send you a new password)</p>
        </div>
        <div class="find_password_form">
            <form method="post" action="<c:url value='/admin/account/findPasswordConfirm' />" name="find_password_form">
                <input type="text" name="id" placeholder="input admin id" /><br/>
                <input type="text" name="name" placeholder="input admin name" /><br/>
                <input type="text" name="email" placeholder="input admin email" /><br/>

                <input type="button" value="find password" onclick="findPassword()">
                <input type="reset" value="reset">
            </form>
        </div>
        <div class="create_account_login">
            <a href="<c:url value='/admin/account/loginForm' />" >login</a>
            <a href="<c:url value='/admin/account/createAccountForm' />" >create account</a>
        </div>
    </div>
</section>
<jsp:include page="../../include/footer.jsp" />
<script type="text/javascript">
    function findPassword() {
        let form = document.find_password_form;

        // TODO form validation 체크
        form.submit();
    }
</script>
</body>
</html>