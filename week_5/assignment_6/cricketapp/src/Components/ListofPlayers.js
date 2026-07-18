import React from 'react';

function ListofPlayers() {
    const players = [
        { name: "Virat Kohli", score: 120 },
        { name: "Rohit Sharma", score: 85 },
        { name: "Jasprit Bumrah", score: 15 },
        { name: "KL Rahul", score: 95 },
        { name: "Ravindra Jadeja", score: 45 },
        { name: "Shubman Gill", score: 110 },
        { name: "Rishabh Pant", score: 65 },
        { name: "Hardik Pandya", score: 55 },
        { name: "Mohammed Shami", score: 10 },
        { name: "Yuzvendra Chahal", score: 8 },
        { name: "Suryakumar Yadav", score: 130 }
    ];

    const lowScorers = players.filter(player => player.score < 70);

    return (
        <div className="player-list">
            <h2>All Players</h2>
            {players.map((player, index) => (
                <div key={index} className="player-item">
                    <span className="player-name">{player.name}</span>
                    <span className="player-score">{player.score}</span>
                </div>
            ))}

            <h2>Players with Score Below 70</h2>
            {lowScorers.map((player, index) => (
                <div key={index} className="player-item">
                    <span className="player-name">{player.name}</span>
                    <span className="low-score">{player.score}</span>
                </div>
            ))}
        </div>
    );
}

export default ListofPlayers;
