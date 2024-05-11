<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link rel="stylesheet" type="text/css" href="../../static/adminDashboard.css">
</head>
<body>
<div class="header1">
    <h1>Admin Dashboard</h1>
    <a class="logout" href="/login">Log Out</a>
</div>

<!--<div class="middle">-->
<h1>Courses</h1>
    <c:choose>
        <c:when test="${not empty courses}">
            <table id="preferencesTable">
                <thead>
                <tr>
                    <th>Course ID</th>
                    <th>Course Name</th>
                    <th>Course Info</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="course" items="${courses}">
                    <tr>
                        <td>${course.getCourseId()}</td>
                        <td>${course.getCourseName()}</td>
                        <td>
                            <a href="/admin/course?id=${course.courseId}" class="link">
                                <button>Info</button>
                            </a>
                            <!--<button><a class="link" href="/admin/course?id=${course.courseId}">Info</a></button>-->
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <br/>
        </c:when>
        <c:otherwise>
            <h2>There are no courses yet</h2>
        </c:otherwise>
    </c:choose>
<!--</div>-->
</body>
</html>
