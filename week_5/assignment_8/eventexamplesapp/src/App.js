import React from 'react';
import './App.css';
import CurrencyConvertor from './Components/CurrencyConvertor';

function App() {
  const [count, setCount] = React.useState(0);

  const handleIncrement = () => {
    setCount(count + 1);
    sayHello();
  };

  const handleDecrement = () => {
    setCount(count - 1);
  };

  const sayHello = () => {
    alert('Hello! Counter value is: ' + (count + 1));
  };

  const handleWelcome = (message) => {
    alert(message);
  };

  const handleSyntheticEvent = () => {
    alert('I was clicked');
  };

  return (
    <div className="App">
      <h1>Event Examples App</h1>

      <div className="event-section">
        <h2>Counter</h2>
        <p className="counter-value">Count: {count}</p>
        <button className="btn" onClick={handleIncrement}>Increment</button>
        <button className="btn" onClick={handleDecrement}>Decrement</button>
      </div>

      <div className="event-section">
        <h2>Welcome Message</h2>
        <button className="btn" onClick={() => handleWelcome('welcome')}>
          Say Welcome
        </button>
      </div>

      <div className="event-section">
        <h2>Synthetic Event</h2>
        <button className="btn" onClick={handleSyntheticEvent}>
          Click Me
        </button>
      </div>

      <CurrencyConvertor />
    </div>
  );
}

export default App;
