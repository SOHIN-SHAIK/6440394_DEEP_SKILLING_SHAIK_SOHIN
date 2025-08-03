import React, { useState } from 'react';
import './App.css';

function App() {
  const [count, setCount] = useState(5);
  const [amount, setAmount] = useState('');
  const [currency, setCurrency] = useState('');

  const increment = () => setCount(count + 1);
  const decrement = () => setCount(count - 1);
  const sayWelcome = () => alert('welcome');
  const sayHello = () => alert('Hello! Member1');

  const handleSubmit = (e) => {
    e.preventDefault();
    alert(`Converting ${amount} to ${currency}`);
  };

  return (
    <div className="App">
      <div style={{ textAlign: 'left' }}>
        <p>{count}</p>
        <button onClick={increment}>Increment</button>
        <button onClick={decrement}>Decrement</button>
        <br /><br />
        <button onClick={sayWelcome}>Say welcome</button>
        <button onClick={sayHello}>Click on me</button>
      </div>

      <h1 className="heading">Currency Convertor!!!</h1>
      <form onSubmit={handleSubmit}>
        <label>Amount: </label>
        <input
          type="text"
          value={amount}
          onChange={(e) => setAmount(e.target.value)}
        />
        <br /><br />
        <label>Currency: </label>
        <textarea
          value={currency}
          onChange={(e) => setCurrency(e.target.value)}
        />
        <br /><br />
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

export default App;
