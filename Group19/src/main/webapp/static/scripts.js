let timers = {};
const courseProgress = {};
let courseId; // Define courseId globally
function startTime(courseId, id){
    fetch('/courses/start', {
        method: 'POST',
    })
        .then(response => {
            if (response.ok) {
                alert("Course started successfully!");
                isCourseStarted = true;
                document.getElementById(`completeBtn_${courseId}`).style.display = 'block';
                addToEnrolledList(courseId, id);
            } else {
                alert("Failed to start the course. Please try again.");
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert("An error occurred while starting the course. Please try again later.");
        });
}

function ibm(link){
    window.open(link, "_blank")
}

// function startCourse() {
//     document.getElementById("completeButton").disabled = false;
// }

function completeCourse(courseId) {
    pauseTimer(courseId);

    fetch('/courses/complete', {
        method: 'POST',
    })
        .then(response => {
            if (response.ok) {
                alert("Course completed successfully!");
                const completionTime = new Date().toLocaleString();
                document.getElementById(`completionTime_${courseId}`).innerText = `Completion Time: ${completionTime}`;
                moveFromEnrolledToCompleted(courseId)
                // updateProgressBar(courseId);
                // Assuming courseId is unique and corresponds to the progress bar
                const progressBar = document.getElementById("progressBar");
                const currentWidth = parseFloat(progressBar.style.width) || 0; // Get current width or default to 0

                // Increment the progress by (100/13)
                const increment = (100 / getSelectedCourses().length);
                const newWidth = Math.min(currentWidth + increment, 100); // Ensure the width doesn't exceed 100%
                progressBar.style.width = newWidth + "%";
            } else {
                throw new Error('Failed to complete the course. Please try again.');
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert(error.message);
        });
}

function startTimer(courseId) {
    if (!timers[courseId]) {
        let startTimeStamp = Date.now();
        timers[courseId] = {
            intervalId: null,
            elapsedTime: 0
        };
        timers[courseId].intervalId = setInterval(function() {
            const currentTimeStamp = Date.now();
            timers[courseId].elapsedTime = currentTimeStamp - startTimeStamp;
            displayTimer(courseId);
        }, 1000);
    }
}

function pauseTimer(courseId) {
    clearInterval(timers[courseId].intervalId);
    timers[courseId].intervalId = null;
}

function resumeTimer(courseId) {
    if (!timers[courseId].intervalId) {
        let startTimeStamp = Date.now() - timers[courseId].elapsedTime;
        timers[courseId].intervalId = setInterval(function() {
            const currentTimeStamp = Date.now();
            timers[courseId].elapsedTime = currentTimeStamp - startTimeStamp;
            displayTimer(courseId);
        }, 1000);
    }
}

function displayTimer(courseId) {
    const timerDisplay = document.getElementById(`timer_${courseId}`);
    if (timerDisplay) {
        const elapsedTime = timers[courseId].elapsedTime;
        const hours = Math.floor(elapsedTime / 3600000);
        const minutes = Math.floor((elapsedTime % 3600000) / 60000);
        const seconds = Math.floor((elapsedTime % 60000) / 1000);
        timerDisplay.innerText = `Time Elapsed: ${hours}h ${minutes}m ${seconds}s`;
    }
}
function addToEnrolledList(courseId, id) {
    fetch('/user/enrollCourse', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            courseId: courseId,
            id: id // Replace 'current_username' with actual username or fetch it dynamically
        })
    })
        .then(response => {
            if (response.ok) {
                console.log("Course enrolled successfully!");
            } else {
                console.error("Failed to enroll in the course.");
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
}
function moveFromEnrolledToCompleted(courseId) {
    fetch('/user/completeCourse', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            courseId: courseId,
            username: 'current_username' // Replace 'current_username' with actual username or fetch it dynamically
        })
    })
        .then(response => {
            if (response.ok) {
                console.log("gg");
            } else {
                console.error("fail");
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
}
function getSelectedCourses() {
    const selectedCourses = document.querySelectorAll('input[name="selectedCourses"]:checked');
    const selectedCourseIds = [];
    selectedCourses.forEach(course => {
        selectedCourseIds.push(course.value);
    });
    return selectedCourseIds;
}

// Function to display selected courses
// Function to display selected courses
function displaySelectedCourses() {
    const selectedCourseIds = getSelectedCourses();
    const tableBody = document.querySelector('#selectedCoursesTable tbody');
    tableBody.innerHTML = ''; // Clear existing table data
    selectedCourseIds.forEach(courseId => {
        const courseRow = document.querySelector(`#course_${courseId}`);
        selectedCourseIds.forEach(courseId => {
            courseProgress[courseId] = 0;
        });
        if (courseRow) {
            const newRow = tableBody.insertRow();
            for (let i = 1; i < courseRow.cells.length; i++) {
                const newCell = newRow.insertCell();
                newCell.innerHTML = courseRow.cells[i].innerHTML; // Copy course information
            }
            const buttonCell = newRow.insertCell();
            const startButton = document.createElement('button');
            startButton.textContent = 'Start Course';
            startButton.onclick = function() {

                    startTimer(courseId);
                    startTime(courseId);
            };
            buttonCell.appendChild(startButton);
            const pauseResumeCell = newRow.insertCell();
            const pauseButton = document.createElement('button');
            pauseButton.textContent = 'Pause Timer';
            pauseButton.onclick = function() {
                pauseTimer(courseId);
            };
            pauseResumeCell.appendChild(pauseButton);
            const resumeButton = document.createElement('button');
            resumeButton.textContent = 'Resume Timer';
            resumeButton.onclick = function() {
                resumeTimer(courseId);
            };
            pauseResumeCell.appendChild(resumeButton);
            const completeCell = newRow.insertCell();
            const completeButton = document.createElement('button');
            completeButton.id = `completeBtn_${courseId}`;
            completeButton.textContent = 'Complete Course';
            completeButton.onclick = function() {
                // updateProgressBar(courseId);
                completeCourse(courseId);
            };
            completeCell.appendChild(completeButton);
            const timerCell = newRow.insertCell();
            const timerSpan = document.createElement('span');
            timerSpan.id = `timer_${courseId}`;
            timerCell.appendChild(timerSpan);
            const completionCell = newRow.insertCell();
            const completionSpan = document.createElement('span');
            completionSpan.id = `completionTime_${courseId}`;
            completionCell.appendChild(completionSpan);

            const reviewCell = newRow.insertCell();
            const reviewButton = document.createElement('button');
            reviewButton.textContent = 'Leave Review';
            reviewButton.onclick = function() {
                leaveReview(courseId); // Directly access courseId
            };
            reviewCell.appendChild(reviewButton);
        }
    });
}
function fetchCourseLink(courseId) {
    fetch(`/courses/link?courseId=${courseId}`, {
        method: 'GET',
    })
        .then(response => {
            if (response.ok) {
                return response.text();
            } else {
                throw new Error('Failed to fetch course link.');
            }
        })
        .then(courseLink => {
            console.log("Received course link:", courseLink); // Debugging statement
            // Now you have the course link, you can proceed to start the course or perform any other actions
            // For example, you can call the startCourse function passing the course link
            startCourse(courseId, courseLink);
        })
        .catch(error => {
            console.error('Error:', error);
            alert('Failed to fetch course link. Please try again later.');
        });
}
function updateProgressBar(courseId) {
    const selectedCoursesCount = document.querySelectorAll('input[name="selectedCourses"]:checked').length;
    const completedCoursesCount = document.querySelectorAll('.completionTime').length; // Assuming each completed course has a completionTime span
    const progress = (completedCoursesCount / selectedCoursesCount) * 100; // Calculate progress percentage
    document.getElementById('progressBar').style.width = `${progress}%`;

}

function leaveReview(courseId) {
    window.location.href = `/courses/${courseId}/reviews`;
}

function takeQuiz(courseId) {
    event.preventDefault();
    window.location.href = `/courses/${courseId}/quiz`;

    function submitReview(courseId) {
        const reviewText = document.getElementById("reviewText").value;
        const formData = new FormData();
        formData.append('reviewText', reviewText);

        fetch(`/courses/${courseId}/reviews/add`, {
            method: 'POST',
            body: formData
        })
            .then(response => {
                if (response.ok) {
                    return response.text();
                } else {
                    throw new Error('Failed to add review');
                }
            })
            .then(review => {

                const reviewHtml = `<div>${review.reviewText}</div>`; // Construct HTML for the review
                document.getElementById('reviewsSection').insertAdjacentHTML('beforeend', reviewHtml); // Append HTML to the reviews section
            })
            .catch(error => {
                console.error('Error:', error);
                // Handle error if needed
            });
    }

    function setRating(event) {
        const stars = document.querySelectorAll('.leave-review .rating label');
        const ratingInput = document.getElementById('rating');
        const selectedStar = event.target;
        let rating = 0;

        stars.forEach((star, index) => {
            if (star === selectedStar) {
                rating = index + 1;
            }
        });

        stars.forEach((star, index) => {
            if (index < rating) {
                star.style.color = 'gold'; // Fill in stars up to the selected one
            } else {
                star.style.color = '#ccc'; // Reset color for stars after the selected one
            }
        });

        ratingInput.value = rating; // Set the rating value in the hidden input field
    }

    function updateRating() {
        const ratingInput = document.getElementById('rating');
        const selectedRating = document.querySelector('.leave-review .rating input:checked');
        if (selectedRating) {
            ratingInput.value = selectedRating.value;
        }
    }
}
