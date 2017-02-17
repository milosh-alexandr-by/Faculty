<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<hr/>
<p>Header</p>
<hr/>
<hr/>
<p>Зарегистрироваться как студент</p>
<form:form name="addUser" modelAttribute="user" action="/registration" method="post">

    <spring:bind path="username">
        <form:input type="text" path="username" placeholder="Логин" name="username" value=""></form:input>
    </spring:bind>

    <spring:bind path="password">
        <form:input type="password" path="password" placeholder="Пароль" name="password" value=""></form:input>
    </spring:bind>

    <input type="submit" value="Регистрация">

    <input type="hidden" name="whoIs" value="student">

</form:form>
<hr/>
<p>Зарегистрироваться как преподаватель</p>
<form:form name="addUser" modelAttribute="user" action="/registration" method="post">

    <spring:bind path="username">
        <form:input type="text" path="username" placeholder="Логин" name="username" value=""></form:input>
    </spring:bind>

    <spring:bind path="password">
        <form:input type="password" path="password" placeholder="Пароль" name="password" value=""></form:input>
    </spring:bind>

    <input type="submit" value="Регистрация">

    <input type="hidden" name="whoIs" value="teacher">

</form:form>
<hr/>
