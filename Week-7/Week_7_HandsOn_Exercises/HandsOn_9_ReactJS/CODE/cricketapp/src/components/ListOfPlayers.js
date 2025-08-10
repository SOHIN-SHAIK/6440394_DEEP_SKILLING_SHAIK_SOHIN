import React from "react";

function ListOfPlayers() {
  const players = [
    { name: "Mr. Jack", score: 50 },
    { name: "Mr. Michael", score: 70 },
    { name: "Mr. John", score: 40 },
    { name: "Mr. Ann", score: 61 },
    { name: "Mr. Elisabeth", score: 61 },
    { name: "Mr. Sachin", score: 95 },
    { name: "Mr. Dhoni", score: 100 },
    { name: "Mr. Virat", score: 84 },
    { name: "Mr. Jadeja", score: 64 },
    { name: "Mr. Raina", score: 75 },
    { name: "Mr. Rohit", score: 80 }
  ];

  const below70 = players.filter((p) => p.score < 70);
  const hrStyle = { border: "none", borderTop: "1px solid grey", margin: "10px 0" };

  return (
    <div style={{ textAlign: "left" }}>
      <h1>List of Players</h1>
      <ul>
        {players.map((p, index) => (
          <li key={index}>{p.name} {p.score}</li>
        ))}
      </ul>
      <hr style={hrStyle} />

      <h1>List of Players having Scores Less than 70</h1>
      <ul>
        {below70.map((p, index) => (
          <li key={index}>{p.name} {p.score}</li>
        ))}
      </ul>
      <hr style={hrStyle} />
    </div>
  );
}

// Export statement should always be at the very end
export default ListOfPlayers;
