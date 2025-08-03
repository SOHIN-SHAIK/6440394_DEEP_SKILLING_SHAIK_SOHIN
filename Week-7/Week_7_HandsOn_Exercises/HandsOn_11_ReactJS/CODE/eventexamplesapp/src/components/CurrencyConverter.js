import React, { useState } from 'react';

function CurrencyConverter() {
  const [rupees, setRupees] = useState('');
  const [euro, setEuro] = useState('');

  const handleSubmit = () => {
    const conversionRate = 0.011; // Approx: 1 INR = 0.011 EUR
    setEuro((rupees * conversionRate).toFixed(2));
  };

  return (
    <div>
      <h2>Currency Converter</h2>
      <label>Enter amount in ₹ Rupees: </label>
      <input
        type="number"
        value={rupees}
        onChange={(e) => setRupees(e.target.value)}
      />
      <button onClick={handleSubmit}>Convert</button>

      {euro && (
        <h3>Converted Value in € Euro: {euro}</h3>
      )}
    </div>
  );
}

export default CurrencyConverter;
