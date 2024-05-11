<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="../../../static/style.css">
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
    <div class ="friend_search">
        <!-- Search form -->
        <form action="/search" method="get">
            <input type="text" name="username" placeholder="Search for friends">
            <button type="submit">Search</button>
        </form>

    </div>
    <br>
    <br>

    <c:choose>

        <c:when test="${not empty searchResults}">
            <div class="middle">
                <c:forEach var="user" items="${searchResults}">
                    <div>
                        <p>Username:   ${user.username}</p>
                        <p>Name:     ${user.name}</p>
                        <p>Courses Completed:     ${user.coursesCompleted}</p>
                        <form action="/addFriend?receiverId=${user.id}" method="post">
                            <input type="hidden" name="userId" value="${user.id}">
                            <button type="submit">Add as Friend</button>
                        </form>
                    </div>
                </c:forEach>
            </div>
        </c:when>
        <c:otherwise>
            <h1>No usernames found</h1>

        </c:otherwise>
    </c:choose>

    <br/>




</div>

<script type="text/javascript" src="../../static/scripts.js"></script>
</body>
</html>
