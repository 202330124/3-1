<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 25. 5. 21.
  Time: 오전 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>설문조사</title>
</head>
<body>
    <h3>설문조사</h3>
    <form:form modelAttribute="SurveyCommand">
        <form:errors />

        <p>
            <label>1. 당신의 희망 분야는?</label><br/>
            <form:radiobutton path="part">서버 개발자</form:radiobutton>
            <form:radiobutton path="part">프론트 개발자</form:radiobutton>
            <form:radiobutton path="part">풀스택 개발자</form:radiobutton>
        </p>
        <p>
            <label>2. 가장 많이 사용하는 개발도구는?</label><br/>
            <form:radiobutton path="tool">Eclipse</form:radiobutton>
            <form:radiobutton path="tool">IntelliJ</form:radiobutton>
            <form:radiobutton path="tool">VSCode</form:radiobutton>
        </p>
        <p>
            <label>3. 하고 싶은 말</label><br/>
            <form:textarea path="say" />
        </p>
        <p>
            <label>응답자 이름</label>
            <form:textarea path="name" />
        </p>
        <p>
            <label>응답자 나이</label>
            <form:textarea path="age" />
        </p>
        <input type="submit" value="전송">
    </form:form>
</body>
</html>