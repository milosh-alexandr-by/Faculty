<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<hr/>
<p>Admin allUserCourse</p>
<p><a href="/admin/allCourses">Список всех курсов</a></p>
<p><a href="/admin/allStudents">Список всех студентов</a></p>
<p><a href="/admin/allTeachers">Список всех преподавателей</a></p>
<p><a href="/admin/allUserCourses">Список все юзер-курсы</a></p>
<hr/>
<p><b>Список юзер-курсов:</b></p><br/>
<table>
    <tr>
        <th>user_course_id</th>
        <th>user</th>
        <th>course</th>
        <th>rating</th>
    </tr>
    <c:forEach var="uc" items="${userCourses}">
        <tr>
            <td><c:out value="${uc.user_course_id}" />
            <td><c:out value="${uc.user.username}" />
            <td><c:out value="${uc.course.courseName}" />
            <td><c:out value="${uc.rating}" />
        <tr />
    </c:forEach>
</table>
<hr/>

