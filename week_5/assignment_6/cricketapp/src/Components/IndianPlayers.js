import React from 'react';

function IndianPlayers() {
    const T20players = ["Virat Kohli", "Rohit Sharma", "KL Rahul", "Hardik Pandya", "Rishabh Pant"];
    const RanjiTrophyPlayers = ["Shubman Gill", "Suryakumar Yadav", "Ravindra Jadeja", "Jasprit Bumrah", "Mohammed Shami"];

    const mergedPlayers = [...T20players, ...RanjiTrophyPlayers];

    const [first, second, third, fourth, fifth, ...rest] = T20players;
    const oddTeamPlayers = [first, third, fifth];
    const evenTeamPlayers = [second, fourth, ...rest];

    return (
        <div className="player-list">
            <h2>Indian Players - Destructuring</h2>

            <h3>Odd Team Players (from T20)</h3>
            {oddTeamPlayers.map((player, index) => (
                <div key={index} className="player-item">
                    <span className="player-name">{player}</span>
                </div>
            ))}

            <h3>Even Team Players (from T20)</h3>
            {evenTeamPlayers.map((player, index) => (
                <div key={index} className="player-item">
                    <span className="player-name">{player}</span>
                </div>
            ))}

            <h3>Merged Players (T20 + Ranji Trophy)</h3>
            {mergedPlayers.map((player, index) => (
                <div key={index} className="player-item">
                    <span className="player-name">{player}</span>
                </div>
            ))}
        </div>
    );
}

export default IndianPlayers;
