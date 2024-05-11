<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Leaderboard</title>
    <link rel="stylesheet" type="text/css" href="../../static/style.css">
    <link rel="stylesheet" type="text/css" href="../../static/leaderboard.css">
    <link rel="stylesheet" type="text/css" href="../../static/badge.css">

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

    <h1>Global Leaderboard</h1>

    <c:choose>
        <c:when test="${not empty users}">
            <div class="table-scroll">
                <table class="leaderboard">
                    <thead>
                    <tr>
                        <th>Position</th>
                        <th>Username</th>
                        <th>Courses Completed</th>
                        <th>Badge</th> <!-- Add a new column for badges or titles -->
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="user" items="${users}" varStatus="loop">
                        <tr>
                            <td>${loop.index + 1}</td>
                            <td>${user.username}</td>
                            <td>${user.coursesCompleted}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${loop.index == 0}">
                                        <span class="badge">1st place</span>
                                    </c:when>
                                    <c:when test="${loop.index == 1}">
                                        <span class="silver badge">2nd place</span>
                                    </c:when>
                                    <c:when test="${loop.index == 2}">
                                        <span class="bronze badge">3rd place</span>
                                    </c:when>
                                    <c:when test="${loop.index == 3}">
                                        <span class="purple badge">4th place</span>
                                    </c:when>
                                    <c:when test="${loop.index == 4}">
                                        <span class="green badge">5th place</span>
                                    </c:when>
                                    <c:when test="${(loop.index + 1) <= 10}">
                                        <span class="blue badge">${loop.index + 1}th place</span>
                                    </c:when>
                                    <c:otherwise>
                                        <!-- Add more conditions for other positions if needed -->
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <br/>
                </c:when>
                <c:otherwise>
                    <h1>No Users Found!</h1>
                    <br/>
                </c:otherwise>
                </c:choose>
            </div>

</div>
</div>
</body>
</html>