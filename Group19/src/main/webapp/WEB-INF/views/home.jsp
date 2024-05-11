<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="../../static/style.css">
</head>
<body>
<div class="navbar">
    <ul>
        <li><a class="link" href="/home?id=${userID}">Home</a></li>
        <li><a class="link" href="/dashboard">Courses</a></li>
        <li><a class="link" href="/leaderboard">Leaderboard</a></li>
        <li><a class="link" href="/friends">Friends</a></li>
        <li><a class="link" href="/login">Log Out</a></li>
    </ul>
</div>

<div class="middle">
    <h1>Hello ${currentUser.name}!</h1>
    <h2>Welcome to your homepage</h2>

    <div class="enrolled">

        <c:choose>
            <c:when test="${not empty enrolled}">
                <h1>Enrolled Courses</h1>
                <table class="table1">
                    <thead>
                    <tr>
                        <th>Course ID</th>
                        <th>Course Name</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="course" items="${enrolled}">
                        <tr>
                            <td>${course.courseId}</td>
                            <td>${course.courseName}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <br/>
            </c:when>
            <c:otherwise>
                <h2>You have not enrolled in any courses yet</h2>
            </c:otherwise>
        </c:choose>
    </div>

    <div class="completed">

        <c:choose>
            <c:when test="${not empty completed}">
                <h1>Completed Courses</h1>
                <table class="table1">
                    <thead>
                    <tr>
                        <th>Course ID</th>
                        <th>Course Name</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="course" items="${completed}">
                        <tr>
                            <td>${course.courseId}</td>
                            <td>${course.courseName}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <br/>
            </c:when>
            <c:otherwise>
                <h2>You have not completed in any courses yet</h2>
            </c:otherwise>
        </c:choose>
    </div>

</div>


<script type="text/javascript" src="../../static/scripts.js"></script>
</body>
</html>
