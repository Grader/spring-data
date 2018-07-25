<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>

<head>
    <meta charset="utf-8">
    <title>Документ HTML5</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style_modal.css" type="text/css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
</head>

<body>
    <div id="modal_form">
        <form:form modelAttribute="user" method="post" action="index" >

            <h1 class="form">Авторизация</h1>
            <form:label path="login"><h5>Логин</h5></form:label>
            <form:input path="login"/>
            <form:errors path="login"/>
                        <form:label path="pass"><h5>Пароль</h5></form:label>
                        <form:input path="pass"/>
                        <form:errors path="pass"/>
                                    <h5></h5>
            <input type="submit" value="Вход">
            <h4>Или <a href="/registration">зарегистрируйтесь</a>, если не зарегистрированы</h4>
            </form:form>
    </div>
</body>

</html>