<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="../../../static/style.css">
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
    <h1>Friends!</h1>

    <div class="friend_list">

        <c:choose>
            <c:when test="${not empty friends}">
                <h2>Your Friends</h2>

                    <c:forEach var="friend" items="${friends}">
                       <p>${friend.username} </p>
                    </c:forEach>
                <br/>
            </c:when>
            <c:otherwise>
                <h2>You do not have any friends yet</h2>
            </c:otherwise>
        </c:choose>
    </div>

    <div class ="friend_search">
        <!-- Search form -->
        <form action="/search" method="get">
            <input type="text" name="username" placeholder="Search for friends">
            <button type="submit">Search</button>
        </form>

    </div>
    <br>

    <div class = "friends_leaderboard">
    <c:choose>
        <c:when test="${not empty friends}">
            <table class="leaderboard">
                <h1>Friend Leaderboard</h1>
                <thead>
                <tr>
                    <th>Position</th>
                    <th>Username</th>
                    <th>Courses Completed</th>
                    <th>Badge</th> <!-- Add a new column for badges or titles -->
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${friendsLead}" varStatus="loop">
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
            <br/>
        </c:otherwise>
    </c:choose>

        <!-- Section for displaying friend requests -->
        <div class="friend-requests">
            <h2>Friend Requests</h2>
            <c:if test="${not empty friendRequests}">
                <c:forEach var="request" items="${friendRequests}">
                    <div>
                        <p>From: ${request.sender.username}</p>
                        <!-- Add more details about the request if needed -->
                        <form action="/acceptFriendRequest" method="post">
                            <input type="hidden" name="requestId" value="${request.id}">
                            <button type="submit">Accept</button>
                        </form>
                        <form action="/rejectFriendRequest" method="post">
                            <input type="hidden" name="requestId" value="${request.id}">
                            <button type="submit">Reject</button>
                        </form>
                    </div>

                </c:forEach>
            </c:if>
            <c:if test="${empty friendRequests}">
                <p>No pending friend requests.</p>
            </c:if>
        </div>
        <div class="sent-requests">
            <c:if test="${not empty sent}">
                <h2>Sent Requests</h2>
                <c:forEach var="request" items="${sent}">
                    <div>
                        <p>Sent to:  ${request.receiver.username} Status: ${request.status} </p>
                    </div>
                </c:forEach>
            </c:if>
            <c:if test="${empty friendRequests}">
                <br>
            </c:if>
        </div>

    </div>
</div>

</div>


<script type="text/javascript" src="../../static/scripts.js"></script>
</body>
</html>
