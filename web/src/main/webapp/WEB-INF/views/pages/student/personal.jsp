<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<hr/>
<p>Student personal</p>
<hr/>
<p>Список ваших курсов</p>
<table border="1" cellspacing="0" cellpadding="5">
    <tr>
        <td>Название курса</td>
        <td>Ваша оценка</td>
    </tr>
    <c:forEach var="uc" items="${userCourses}" >
    <tr>
        <td><c:out value="${uc.course.courseName}" /></td>
        <td><c:out value="${uc.rating}" /></td>
    </tr>
    </c:forEach>
</table>
<hr/>
<p>Записаться на новый курс</p>
<form:form method="post" commandName="course" action="/personal">
    <table border="1" cellspacing="0" cellpadding="5">
        <tr>
            <td>Название курса</td>
        <tr>
        <c:forEach var="cN" items="${courseNames}" >
        <tr>
            <td>
                <form:radiobutton path="courseName" value="${cN}" label="${cN}"/>
            </td>
        </tr>
        </c:forEach>
    </table><br/>
    <input type="submit" value="Записаться">
</form:form>
<hr/>