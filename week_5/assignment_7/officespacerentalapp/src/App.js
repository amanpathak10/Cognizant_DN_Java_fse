import React from 'react';
import './App.css';

function App() {
  const offices = [
    { name: "CoWork Space A", rent: 55000, address: "123 Business Park, Bangalore" },
    { name: "Tech Hub Office", rent: 75000, address: "456 Innovation Road, Mumbai" },
    { name: "Startup Studio", rent: 45000, address: "789 Creative Lane, Pune" },
    { name: "Executive Suite", rent: 95000, address: "321 Corporate Ave, Delhi" },
    { name: "Green Workspace", rent: 35000, address: "654 Eco Park, Chennai" },
  ];

  return (
    <div className="App">
      <h1>Office Space Rental</h1>
      <img
        src="https://images.unsplash.com/photo-1497366216548-37526070297c?w=600"
        alt="Office Space"
        className="office-image"
      />
      <div className="office-list">
        {offices.map((office, index) => (
          <div key={index} className="office-card">
            <h3>{office.name}</h3>
            <p className="office-address">{office.address}</p>
            <p
              className="office-rent"
              style={{ color: office.rent < 60000 ? 'red' : 'green' }}
            >
              Rent: ₹{office.rent.toLocaleString()}/month
            </p>
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;
