import React from 'react';

const BalanceSnapshotComp = ({ balance, onBalanceChange }) => {


    const onChangeEvtHandler = (event) => {
        const value = event.target.value;
        if (!isNaN(value) ) {
            onBalanceChange(value);
        }
    };

    return (
        <div>
            <label htmlFor="balance">Enter Balance:</label>
            <input
                type="text"
                id="balance"
                value={balance}
                onChange={onChangeEvtHandler}
                placeholder="Enter a float number"
            />
        </div>
    );
};


export default BalanceSnapshotComp;
