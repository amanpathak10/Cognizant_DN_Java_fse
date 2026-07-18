import React from 'react';
import '../Stylesheets/mystyle.css';

function CalculateScore({ name, school, total, goal }) {
    const average = total / goal;

    return (
        <div className="score-container">
            <h2>Student Score Calculator</h2>
            <div className="student-info">
                <p><strong>Name:</strong> {name}</p>
                <p><strong>School:</strong> {school}</p>
                <p><strong>Total Score:</strong> {total}</p>
                <p><strong>Goal:</strong> {goal}</p>
                <p className="average-score"><strong>Average Score:</strong> {average.toFixed(2)}</p>
            </div>
        </div>
    );
}

export default CalculateScore;
