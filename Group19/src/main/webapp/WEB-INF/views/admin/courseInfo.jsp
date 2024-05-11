<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link rel="stylesheet" type="text/css" href="../../../static/CourseInfo.css">
    <script src="https://www.gstatic.com/charts/loader.js"></script>
</head>
<body>
<div class="header1">
    <h1>Admin Dashboard</h1>
</div>

<div class="middle">
    <h1>${course.courseName}</h1>
    <div class="info">
        <div class="charts">
            <div class="pie-chart"></div>
            <div class="bar-chart"></div>
        </div>
        <div id="total" hidden>${total}</div>
        <div id="enrolled" hidden>${enrolled.size()}</div>
        <div id="completed" hidden>${completed.size()}</div>
    </div>
    <!--<div class="users">
        <h2 id="details">Users</h2>
        <c:choose>
            <c:when test="${not empty enrolled}">
                <ol>
                    <c:forEach var="user" items="${enrolled}">
                        <li><a href="/admin/user?id=${user.getId()}">${user.getUsername()}</a></li>
                    </c:forEach>
                </ol>
            </c:when>
            <c:otherwise>
                <h2>No users currently enrolled</h2>
            </c:otherwise>
        </c:choose>
    </div>-->
    <div class="users">
        <h2 id="details">Users</h2>
        <div class="table-scroll">
            <table>
                <thead>
                <tr>
                    <th>User ID</th>
                    <th>Username</th>
                </tr>
                </thead>
                <tbody>
                <c:choose>
                    <c:when test="${not empty enrolled}">
                        <c:forEach var="user" items="${enrolled}">
                            <tr>
                                <td>${user.getId()}</td>
                                <td><a href="/admin/user?id=${user.getId()}">${user.getUsername()}</a></td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td colspan="2">No users currently enrolled</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
                </tbody>
            </table>
        </div>
    </div>
</div>

<button class="back"><a href="/admin/dashboard">Back to Courses</a></button>
</body>

<script src="../../../static/adminDashboard.js"></script>
</html>
