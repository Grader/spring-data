<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>spring boot form submit example</title>
</head>
<body>
<h1>spring boot form submit example</h1>
<h2> Details as submitted successfully </h2>
<h4> Имя : ${firstName} </h4>
<h4> Фамилия : ${lastName} </h4>
<h4> Пароль : ${pass} </h4>
<h4> Email : ${email} </h4>
</body>
</html>