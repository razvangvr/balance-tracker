import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';

const BalanceSnapshotComp = ({ balance, onBalanceChange, onSave }) => {


    const onChangeEvtHandler = (event) => {
        const value = event.target.value;
        if (!isNaN(value) ) {
            onBalanceChange(value);
        }
    };

    return (
        <div className="mb-3">
            <label htmlFor="balance">Enter Balance:</label>
            <input
                type="text"
                id="balance"
                value={balance}
                onChange={onChangeEvtHandler}
                placeholder="Enter a float number"
                className="form-control"
            />
            <button className="btn btn-primary mt-2"  onClick={onSave}>
                Save Balance
            </button>
        </div>
    );
};


export default BalanceSnapshotComp;
