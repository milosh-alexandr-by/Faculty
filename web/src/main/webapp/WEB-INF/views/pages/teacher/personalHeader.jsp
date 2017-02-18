<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<hr/>
<p>Header</p>
<c:choose>
    <c:when test="${pageContext.request.userPrincipal.name != null}">
        ${pageContext.request.userPrincipal.name}
        <a href="/j_spring_security_logout">Logout</a>
    </c:when>
    <c:otherwise>
        <a href="/enter">Вход</a>
        <a href="/registration">Регистрация</a>
    </c:otherwise>
</c:choose>
<hr/>
