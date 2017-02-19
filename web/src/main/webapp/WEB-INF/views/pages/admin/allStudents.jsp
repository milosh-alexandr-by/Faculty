<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<hr/>
<p>Admin allStudents</p>
<p><a href="/admin/allCourses">Список всех курсов</a></p>
<p><a href="/admin/allStudents">Список всех студентов</a></p>
<p><a href="/admin/allTeachers">Список всех преподавателей</a></p>
<p><a href="/admin/allUserCourses">Список все юзер-курсы</a></p>
<hr/>
<p><b>Список студентов:</b></p><br/>
<table>
    <tr>
        <th>user_id</th>
        <th>firstName</th>
        <th>lastName</th>
        <th>username</th>
        <th>password</th>
    </tr>
    <c:forEach var="u" items="${users}">
        <tr>
            <td><c:out value="${u.user_id}" />
            <td><c:out value="${u.firstName}" />
            <td><c:out value="${u.lastName}" />
            <td><c:out value="${u.username}" />
            <td><c:out value="${u.password}" />
        <tr />
    </c:forEach>
</table>
<hr/>
