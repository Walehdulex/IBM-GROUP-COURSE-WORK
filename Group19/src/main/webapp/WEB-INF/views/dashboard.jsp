<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link rel="stylesheet" type="text/css" href="../../static/style.css">
    <style>
        /* Progress bar container */
        .progress {
            width: 100%;
            height: 30px;
            background-color: #f3f3f3;
            border-radius: 5px;
            margin-bottom: 20px;
        }

        /* Progress bar */
        #progressBar {
            height: 100%;
            background-color: #4caf50;
            border-radius: 5px;
            width: 0%; /* Initial width is 0, it will be dynamically adjusted */
            transition: width 0.3s ease-in-out; /* Smooth transition effect */
        }
    </style>
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
    <div class="left-side">



    <div class="right-side">
        <h1>Courses</h1>
        <form id="selectCoursesForm">
            <c:choose>
                <c:when test="${not empty courses}">
                    <table class="table1">
                        <thead>
                        <tr>
                            <th>Select</th>
                            <th>Course ID</th>
                            <th>Course Name</th>

                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="course" items="${courses}">
                            <tr id="course_${course.courseId}">
                                <td><input type="checkbox" name="selectedCourses" value="${course.courseId}" onchange="displaySelectedCourses()"></td>
                                <td>${course.courseId}</td>
                                <td>${course.courseName}  </td>
<%--                                <td>--%>
<%--                                    <button onclick="ibm('${course.courseLink}');">View</button>--%>
<%--                                </td>--%>
                                <!-- Other table data -->
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                <table class="table2">
                    <c:forEach var="course" items="${courses}">
                    <tr id="course_${course.courseId}">
                        <td>${course.courseId}</td>
                        <td>${course.courseName}  </td>
                        <td><button onclick="ibm('${course.courseLink}');">View</button></td>
                        <td><button id="takeQuiz_${course.courseId}" onclick="takeQuiz('${course.courseId}');">Take quiz</button></td>
                        </c:forEach>
                </table>
    </div>

                    <br/>
                </c:when>
                <c:otherwise>
                    <h2>There are no courses yet</h2>
                </c:otherwise>
            </c:choose>
        </form>

        <h1>Selected Courses</h1>
        <table class="table1" id="selectedCoursesTable">
            <thead>
            <tr>
                <th>Course ID</th>
                <th>Course Name</th>
                <th>Start Course</th>
                <th>Pause/Resume Course</th>
                <th>Complete Course</th>
                <th>Course time elapsed</th>
                <th>Course completion date</th>
                <th>Course Review</th>


            </tr>

            </thead>
            <tbody>
            <c:forEach var="course" items="${selectedCourses}">
                <tr>
                    <td>${course.courseId}</td>
                    <td>${course.courseName}</td>
                    <td>
                        <button onclick="startTimer('${course.courseId}'); startTime('${course.courseId}'); ibm('${course.courseLink}'); ">Start Course</button>
                    </td>
                    <td>
                        <button onclick="pauseTimer('${course.courseId}');">Pause Timer</button>
                        <button onclick="resumeTimer('${course.courseId}');">Resume Timer</button>
                    </td>
                    <td>
                        <button id="completeBtn_${course.courseId}" onclick="completeCourse('${course.courseId}')">Complete Course</button>
                    </td>

                    <td>
                        <span id="timer_${course.courseId}"></span>
                    </td>
                    <td>
                        <span id="completionTime_${course.courseId}"></span>
                    </td>

                    <td>
                        <button id="leaveReview_${course.courseId}" onclick="leaveReview('${course.courseId}');">Leave a review</button>
                    </td>



                </tr>
            </c:forEach>
            </tbody>
        </table>

        <h2>Progress</h2>
        <div class="progress">
            <div id="progressBar"></div>
        </div>
    </div>
</div>

<script type="text/javascript" src="../../static/scripts.js"></script>
</body>
</html>

