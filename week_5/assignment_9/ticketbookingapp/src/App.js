import React from 'react';
import './App.css';

function GuestPage() {
  const flights = [
    { id: "AI101", from: "Mumbai", to: "Delhi", time: "06:00 AM", price: "₹5,500" },
    { id: "6E202", from: "Bangalore", to: "Chennai", time: "08:30 AM", price: "₹3,200" },
    { id: "SG303", from: "Delhi", to: "Goa", time: "11:00 AM", price: "₹6,800" },
  ];

  return (
    <div className="page">
      <h2>Welcome, Guest!</h2>
      <p>Browse available flights:</p>
      <div className="flight-list">
        {flights.map((flight) => (
          <div key={flight.id} className="flight-card">
            <h3>{flight.from} → {flight.to}</h3>
            <p>Flight: {flight.id}</p>
            <p>Time: {flight.time}</p>
            <p>Price: {flight.price}</p>
          </div>
        ))}
      </div>
      <p className="login-prompt">Please login to book tickets.</p>
    </div>
  );
}

function UserPage({ onLogout }) {
  const flights = [
    { id: "AI101", from: "Mumbai", to: "Delhi", time: "06:00 AM", price: "₹5,500" },
    { id: "6E202", from: "Bangalore", to: "Chennai", time: "08:30 AM", price: "₹3,200" },
    { id: "SG303", from: "Delhi", to: "Goa", time: "11:00 AM", price: "₹6,800" },
  ];

  return (
    <div className="page">
      <h2>Welcome, User!</h2>
      <p>Book your tickets:</p>
      <div className="flight-list">
        {flights.map((flight) => (
          <div key={flight.id} className="flight-card bookable">
            <h3>{flight.from} → {flight.to}</h3>
            <p>Flight: {flight.id}</p>
            <p>Time: {flight.time}</p>
            <p>Price: {flight.price}</p>
            <button className="book-btn" onClick={() => alert(`Booked ${flight.id}!`)}>
              Book Now
            </button>
          </div>
        ))}
      </div>
      <button className="auth-btn logout" onClick={onLogout}>Logout</button>
    </div>
  );
}

function App() {
  const [isLoggedIn, setIsLoggedIn] = React.useState(false);

  return (
    <div className="App">
      <h1>Flight Ticket Booking</h1>
      {isLoggedIn ? (
        <UserPage onLogout={() => setIsLoggedIn(false)} />
      ) : (
        <>
          <GuestPage />
          <button className="auth-btn login" onClick={() => setIsLoggedIn(true)}>Login</button>
        </>
      )}
    </div>
  );
}

export default App;
