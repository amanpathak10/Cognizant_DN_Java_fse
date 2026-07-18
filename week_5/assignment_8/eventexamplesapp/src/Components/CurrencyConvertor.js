import React from 'react';

function CurrencyConvertor() {
    const [rupees, setRupees] = React.useState('');
    const [euros, setEuros] = React.useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        const rupeeValue = parseFloat(rupees);
        if (!isNaN(rupeeValue)) {
            const euroValue = rupeeValue * 0.011;
            setEuros(euroValue.toFixed(2));
        }
    };

    return (
        <div className="event-section">
            <h2>Currency Convertor</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="number"
                    placeholder="Enter in Rupees"
                    value={rupees}
                    onChange={(e) => setRupees(e.target.value)}
                    className="currency-input"
                />
                <button type="submit" className="btn">Convert</button>
            </form>
            {euros && (
                <p className="result">₹{rupees} = €{euros}</p>
            )}
        </div>
    );
}

export default CurrencyConvertor;
