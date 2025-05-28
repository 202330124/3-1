<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="../../include/title.jsp"/>
    <link href="<c:url value='/resources/css/admin/register_book_form.css' />" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="../../include/header.jsp"/>
<jsp:include page="../include/nav.jsp"/>
<section>
    <div id="section_wrap">
        <div class="word">
            <h3>REGISTER BOOK FORM</h3>
        </div>
        <div class="register_book_form">
            <form action="<c:url value='/admin/book/registerBookConfirm' />" method="post"
                  name="register_book_form">
                <input type="text" name="name" placeholder="INPUT BOOK NAME"/><br/>
                <input type="text" name="author" placeholder="INPUT BOOK AUTHOR"/><br/>
                <input type="text" name="publisher" placeholder="INPUT BOOK PUBLISHER"/><br/>
                <input type="text" name="publish_year" placeholder="INPUT BOOK PUBLISHER YEAR"/><br/>
                <input type="text" name="isbn" placeholder="INPUT BOOK ISBN"/><br/>
                <input type="text" name="call_number" placeholder="INPUT BOOK CALL NUMBER"/><br/>

                <select name="rental_able">
                    <option value="">SELECT BOOK RENTAL ABLE</option>
                    <option value="able">대출가능</option>
                    <option value="enable">대출불가능</option>
                </select><br/>

                <input type="button" value="register book" onclick="registerBookForm()">
                <input type="reset" value="reset">
            </form>
        </div>
    </div>
</section>
<script type="text/javascript">
    function registerBookForm() {
        let form = document.register_book_form;

        // TODO form validation 체크
        form.submit();
    }
</script>
<jsp:include page="../../include/footer.jsp"/>
</body>
</html>