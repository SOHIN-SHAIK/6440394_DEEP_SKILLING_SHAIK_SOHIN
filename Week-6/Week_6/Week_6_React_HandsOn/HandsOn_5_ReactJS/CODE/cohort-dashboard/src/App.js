import React from 'react';
import './App.css';
import CohortDetails from './components/CohortDetails';

function App() {
  // Sample data modeled on the lab screenshot
  const cohorts = [
    {
      name: 'INTADMDF10 - .NET FSD',
      status: 'scheduled',
      startDate: '22-Feb-2022',
      coach: 'Aathma',
      trainer: 'Jojo Jose'
    },
    {
      name: 'ADM2IJF014 - Java FSD',
      status: 'ongoing',
      startDate: '10-Sep-2021',
      coach: 'Apoony',      // adjust to exact spelling from your doc if different
      trainer: 'Elsa Smith' // adjust if needed
    },
    {
      name: 'CDBJF1Z025 - Java FSD',
      status: 'ongoing',
      startDate: '24-Dec-2021',
      coach: 'Aathma',
      trainer: 'John Doe'
    }
  ];

  return (
    <div className="App">
      <h1>Cohorts Details</h1>
      {cohorts.map(c => (
        <CohortDetails
          key={c.name}
          name={c.name}
          status={c.status}
          startDate={c.startDate}
          coach={c.coach}
          trainer={c.trainer}
        />
      ))}
    </div>
  );
}

export default App;
