<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<hr/>
<p>Student personal</p>
<hr/>
<p>Список ваших курсов</p>
${userCourses}<br/><br/>
<c:forEach var="uc" items="${userCourses}">
    <c:out value="${uc.course.courseName}" />
</c:forEach>
<hr/>
<p>Записаться на новый курс</p>
<form name="addCourseToUser" method="get" action="/student/addCourseToUser">
    Название курса: <input type="text" name="title" value=""><br/><br/>
    <input type="submit" value="Записаться на курс">
</form>
<hr/>