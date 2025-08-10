import React from 'react';
import './App.css';
import CalculateScore from './Components/CalculateScore';

function App() {
  return (
    <div>
      <CalculateScore
        Name="Steeve"
        School="DNV Public School"
        Total={284}
        goal={300}   // change this to whatever the goal marks are
      />
    </div>
  );
}

export default App;
