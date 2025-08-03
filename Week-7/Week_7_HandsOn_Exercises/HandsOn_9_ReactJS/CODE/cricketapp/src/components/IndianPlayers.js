import React from "react";

function IndianPlayers() {
  const IndianTeam = [
    "First: Sachin1",
    "Second: Dhoni2",
    "Third: Virat3",
    "Fourth: Rohit4",
    "Fifth: Yuvaraj5",
    "Sixth: Raina6"
  ];

  const oddPlayers = IndianTeam.filter((_, i) => i % 2 === 0);
  const evenPlayers = IndianTeam.filter((_, i) => i % 2 !== 0);

  const mergedPlayers = [
    "Mr. First Player",
    "Mr. Second Player",
    "Mr. Third Player",
    "Mr. Fourth Player",
    "Mr. Fifth Player",
    "Mr. Sixth Player"
  ];

  const listStyle = { color: "#555", paddingLeft: "20px" };
  const hrStyle = { border: "none", borderTop: "1px solid grey", margin: "10px 0" };

  return (
    <div style={{ textAlign: "left", padding: "20px", fontFamily: "Arial, sans-serif" }}>
      <h1>Odd Players</h1>
      <ul style={listStyle}>
        {oddPlayers.map((p, index) => <li key={index}>{p}</li>)}
      </ul>
      <hr style={hrStyle} />

      <h1>Even Players</h1>
      <ul style={listStyle}>
        {evenPlayers.map((p, index) => <li key={index}>{p}</li>)}
      </ul>
      <hr style={hrStyle} />

      <h1>List of Indian Players Merged:</h1>
      <ul style={listStyle}>
        {mergedPlayers.map((p, index) => <li key={index}>{p}</li>)}
      </ul>
      <hr style={hrStyle} />
    </div>
  );
}

export default IndianPlayers;
