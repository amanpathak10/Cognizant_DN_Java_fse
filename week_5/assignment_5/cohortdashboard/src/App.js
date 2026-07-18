import React from 'react';
import './App.css';
import CohortDetails from './Components/CohortDetails';

function App() {
  const cohorts = [
    { name: "Java FSE", status: "ongoing", startDate: "Jan 2025", endDate: "Jun 2025" },
    { name: "React Dev", status: "completed", startDate: "Mar 2024", endDate: "Sep 2024" },
    { name: "Python Full Stack", status: "ongoing", startDate: "Feb 2025", endDate: "Jul 2025" },
    { name: "DevOps", status: "completed", startDate: "Oct 2023", endDate: "Apr 2024" },
  ];

  return (
    <div className="App">
      <h1>My Academy - Cohort Dashboard</h1>
      <div className="cohorts-container">
        {cohorts.map((cohort, index) => (
          <CohortDetails key={index} cohort={cohort} />
        ))}
      </div>
    </div>
  );
}

export default App;
