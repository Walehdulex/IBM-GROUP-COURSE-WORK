// leaderboard.js

function renderLeaderboard(users) {
    const leaderboardTable = document.querySelector('.leaderboard tbody');
    leaderboardTable.innerHTML = ''; // Clear the existing table content

    users.forEach((user, index) => {
        const row = document.createElement('tr');
        const rankCell = document.createElement('td');
        const usernameCell = document.createElement('td');
        const coursesCompletedCell = document.createElement('td');

        rankCell.textContent = index + 1;
        usernameCell.textContent = user.username;
        coursesCompletedCell.textContent = user.coursesCompleted;

        row.appendChild(rankCell);
        row.appendChild(usernameCell);
        row.appendChild(coursesCompletedCell);

        // Add badge or title based on the user's position
        if (index === 0) {
            row.classList.add('gold-badge'); // 1st place
        } else if (index === 1) {
            row.classList.add('silver-badge'); // 2nd place
        } else if (index === 2) {
            row.classList.add('bronze-badge'); // 3rd place
        } else if (index === 3) {
            row.classList.add('purple-badge'); // 4th place
        } else if (index === 4) {
            row.classList.add('green-badge'); // 5th place
        } else if ((index + 1) % 10 === 0) {
            row.classList.add('blue-badge'); // Every 10th place starting from 10th
        }

        leaderboardTable.appendChild(row);
    });
}