<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Проверка пароля</title>
    <meta charset="utf-8" />
</head>
<body>

<form name="loginCustomForm" action="/j_spring_security_check" method="post">
    <input type="text" placeholder="Логин" name="user_login" value="">
    <input type="password" placeholder="Пароль" name="password_login" value="">
    <input type="submit" value="Вход">
    <input type="checkbox" name="rememberme" id="rememberme"
           checked="checked" name="_spring_security_remember_me">
    <label for="rememberme">Запомнить</label>
</form>

</body>
</html>
