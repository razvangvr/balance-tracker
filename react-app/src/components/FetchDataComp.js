import React, { useState } from 'react';
import axios from 'axios';
import BalanceSnapshotComp from "./BalanceSnapshotComp";
import 'bootstrap/dist/css/bootstrap.min.css';

const FetchDataComp = ()  => {
    console.log("FetchDataComp");

    const [balanceSnapshot, setBalanceSnapshot] = useState(0);

    const [message, setMessage] = useState('');

    const handleSnapshotUpdate = (newSnapshot) => {
        console.log("New SnapshotUpdate:",newSnapshot);
        postBalance(newSnapshot);
        setBalanceSnapshot(newSnapshot);
    }

    const postBalance = async (newBalance) => {
        try {
            const response = await axios.post('http://localhost:8002/balance/snapshot', {
                balance: parseFloat(newBalance),
                date: new Date().toISOString()
            });

            if (response.status === 201) {
                setMessage('Balance snapshot saved successfully');
            }
        } catch (error) {
            setMessage('Error saving balance: ' + error.message);
        }
    };

    return(
        <div className="container">
            <h1>FetchDataComp</h1>
            <BalanceSnapshotComp balance={balanceSnapshot}  onBalanceChange={handleSnapshotUpdate} />
            {message && <div className="alert alert-info">{message}</div>}
        </div>
    );
}
export default FetchDataComp;
