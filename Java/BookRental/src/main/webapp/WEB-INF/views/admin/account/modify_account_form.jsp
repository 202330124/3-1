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
    <link href="<c:url value='/resources/css/admin/create_account_form.css' />" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="../../include/header.jsp" />
<jsp:include page="../include/nav.jsp" />
<section>
    <div id="section_wrap">
        <div class="word">
            <h3>CREATE ADMIN ACCOUNT FORM</h3>
        </div>
        <div class="create_account_form">
            <form action="<c:url value='/admin/account/createAccountConfirm' />" method="post" name="create_account_form">
                <input type="text" name="id" placeholder="input admin id" /><br/>
                <input type="password" name="password" placeholder="input admin password" /><br/>
                <input type="password" name="password_again" placeholder="input admin password again" /><br/>
                <input type="text" name="name" placeholder="input admin name" /><br/>
                <select name="gender">
                    <option value="">select admin gender</option>
                    <option value="M">Man</option>
                    <option value="W">Woman</option>
                </select><br/>
                <input type="text" name="part" placeholder="input admin part" /><br/>
                <input type="text" name="position" placeholder="input admin position" /><br/>
                <input type="text" name="email" placeholder="input admin email" /><br/>
                <input type="text" name="phone" placeholder="input admin phone" /><br/>

                <input type="button" value="create account" onclick="createAccountForm()">
                <input type="reset" value="reset">
            </form>
        </div>
        <div class="login">
            <a href="<c:url value='/admin/account/loginForm' />" >login</a>
        </div>
    </div>
</section>
<script type="text/javascript">
    function createAccountForm() {
        let form = document.create_account_form;

        // TODO form validation 체크
        form.submit();
    }
</script>
<jsp:include page="../../include/footer.jsp" />
</body>
</html>