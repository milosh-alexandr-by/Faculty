<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<hr/>
<p>Admin allCourses</p>
<p><a href="/admin/allCourses">Список всех курсов</a></p>
<p><a href="/admin/allStudents">Список всех студентов</a></p>
<p><a href="/admin/allTeachers">Список всех преподавателей</a></p>
<p><a href="/admin/allUserCourses">Список все юзер-курсы</a></p>
<hr/>
<p><b>Список курсов:</b></p><br/>
<table>
    <tr>
        <th>course_id</th>
        <th>courseName</th>
    </tr>
    <c:forEach var="c" items="${courses}">
        <tr>
            <td><c:out value="${c.course_id}" />
            <td><c:out value="${c.courseName}" />
        <tr />
    </c:forEach>
</table>
<hr/>
<p><b>Добавить курс</b></p><br/>
<form name="addCourse" method="get" action="/admin/addCourse">
    Название курса: <input type="text" name="title" value=""><br/><br/>
    <input type="submit" value="Добавить">
</form>
