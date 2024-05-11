<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% int courseId = 0; %><%--@elvariable id="courseId" type=""--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Course Reviews</title>
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
    <h1>Course Reviews</h1>

    <div class="leave-review">
        <!-- Form for leaving a new review -->
        <h2>Leave a Review</h2>
        <form action="/courses/${courseId}/reviews/user/${userID}" method="post">

            <div class="rating" onclick="setRating(event)">
            <input type="hidden" id="rating" name="rating" value="0">
            <label id="star5" for="star5" title="5 stars" style="color:#ccc" data-value="5">&#9733;</label>
            <label id="star4" for="star4" title="4 stars" style="color:#ccc" data-value="4">&#9733;</label>
            <label id="star3" for="star3" title="3 stars" style="color:#ccc" data-value="3">&#9733;</label>
            <label id="star2" for="star2" title="2 stars" style="color:#ccc" data-value="2">&#9733;</label>
            <label id="star1" for="star1" title="1 star" style="color:#ccc" data-value="1">&#9733;</label>
            </div>



            <textarea id="reviewText" name="reviewText" rows="4" cols="50" placeholder="Write a review "></textarea>
            <br>
            <button type="submit" onsubmit="updateRating()" >Submit Review</button>
        </form>

        </div>
    <div class="reviews">
        <c:choose>
            <c:when test="${not empty reviews}">

                <h2>Existing Reviews</h2>

                <table class="table1">
                    <thead>
                    <tr>
                        <th>User Name</th>
                        <th>Rating</th>
                        <th>Comment</th>
                    </tr>
                    </thead>
                    <tbody id="reviewsTableBody">
                    <c:forEach var="review" items="${reviews}">
                    <tr>
                        <td>${review.author.username} </td>
                        <td>${review.rating} / 5</td>
                        <td>${review.reviewText} </td>
                    <tr>
                        </c:forEach>
                        <br/>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <h2>There are no reviews yet</h2>
            </c:otherwise>
        </c:choose>


    </div>

    </div>


</div>

<%
    courseId = (int) request.getAttribute("courseId");
%>

<script type="text/javascript" src="../../static/scripts.js"></script>


</body>
</html>
