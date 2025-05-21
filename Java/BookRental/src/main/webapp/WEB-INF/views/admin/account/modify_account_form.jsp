<%@ page import="daelim.book.rental.kimdaelim.admin.account.AdminAccountVo" %><%--
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
    <link href="<c:url value='/resources/css/admin/modify_account_form.css' />" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="../../include/header.jsp" />
<jsp:include page="../include/nav.jsp" />
<section>
    <div id="section_wrap">
        <div class="word">
            <h3>MODIFY ADMIN ACCOUNT FORM</h3>
        </div>
        <%
            AdminAccountVo loginedAccountVo = (AdminAccountVo) session.getAttribute("loginedAdminAccountVo");
        %>
        <div class="modify_account_form">
            <form action="<c:url value='/admin/account/modifyAccountConfirm' />" method="post" name="modify_account_form">
                <input type="hidden" name="no" value="<%=loginedAccountVo.getNo() %>" />
                <input type="text" name="id" value="<%=loginedAccountVo.getId() %>" readonly disabled /><br/>
                <input type="password" name="password" value="****" readonly disabled /><br/>
                <input type="text" name="name" placeholder="input admin name" value="<%=loginedAccountVo.getName() %>" /><br/>
                <select name="gender">
                    <option value="">select admin gender</option>
                    <option value="M" <% if(loginedAccountVo.getGender().equals("M")) {%> selected <%}%> >Man</option>
                    <option value="W" <% if(loginedAccountVo.getGender().equals("W")) {%> selected <%}%> >Woman</option>
                </select><br/>
                <input type="text" name="part" placeholder="input admin part" value="<%= loginedAccountVo.getPart() %>" /><br/>
                <input type="text" name="position" placeholder="input admin position" value="<%= loginedAccountVo.getPosition() %>" /><br/>
                <input type="text" name="email" placeholder="input admin email" value="<%= loginedAccountVo.getEmail() %>" /><br/>
                <input type="text" name="phone" placeholder="input admin phone" value="<%= loginedAccountVo.getPhone() %>" /><br/>

                <input type="button" value="modify account" onclick="modifyAccountForm()">
                <input type="reset" value="reset">
            </form>
        </div>
    </div>
</section>
<script type="text/javascript">
    function modifyAccountForm() {
        let form = document.modify_account_form;

        // TODO form validation 체크
        if(form.name.value === "") {
            alert("input admin name");
            form.name.focus();

            return;
        }

        if(form.gender.value === "") {
            alert("input admin gender");
            form.gender.focus();

            return;
        }

        if(form.part.value === "") {
            alert("input admin part");
            form.part.focus();

            return;
        }

        if(form.position.value === "") {
            alert("input admin position");
            form.position.focus();

            return;
        }

        if(form.email.value === "") {
            alert("input admin email");
            form.email.focus();

            return;
        }

        if(form.phone.value === "") {
            alert("input admin phone");
            form.phone.focus();

            return;
        }

        form.submit();
    }
</script>
<jsp:include page="../../include/footer.jsp" />
</body>
</html>