<%@ page import="com.example.group19.model.Quiz" %>
<%@ page import="com.example.group19.model.Question" %>
<%@ page import="java.util.List" %>
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
    <h1>Quiz for ${course.courseName}</h1>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <%
        Quiz quiz = (Quiz) request.getAttribute("quiz");
        if (quiz == null || quiz.getQuestions().isEmpty()) {
    %>

    <h2>No questions yet</h2>

    <%
    } else {
        List<Question> questions = quiz.getQuestions();
        int totalQuestions = questions.size();
        int score = 0;

        // Check if the form has been submitted
        if (request.getMethod().equalsIgnoreCase("post")) {
            // Process form submission
            for (int i = 0; i < totalQuestions; i++) {
                String param = "answer_" + i;
                String userAnswer = request.getParameter(param);
                int correctAnswerIndex = questions.get(i).getCorrectAnswerIndex();
                if (userAnswer != null && Integer.parseInt(userAnswer) == correctAnswerIndex) {
                    score++;
                }
            }
        }
    %>

    <form action="" method="post">
        <%
            for (int i = 0; i < questions.size(); i++) {
                Question question = questions.get(i);
        %>
        <div>
            <h3>Question <%= i + 1 %>:</h3>
            <p><%= question.getQuestion() %></p>

            <%
                List<String> options = question.getOptions();
                for (int j = 0; j < options.size(); j++) {
                    String option = options.get(j);
            %>
            <input type="radio" name="answer_<%= i %>" value="<%= j %>">
            <%= option %><br>
            <% } %>
        </div>
        <% } %>
        <input type="submit" value="Submit">
    </form>

    <%
        if (request.getMethod().equalsIgnoreCase("post")) {
    %>
    <h2>Your score: <%= score %> / <%= totalQuestions %></h2>
    <% } %>

    <% } %>

</div>

<script type="text/javascript" src="../../static/scripts.js"></script>
</body>
</html>
