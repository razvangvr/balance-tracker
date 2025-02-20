import React, { useState } from 'react';
import axios from 'axios';
import BalanceSnapshotComp from "./BalanceSnapshotComp";
import 'bootstrap/dist/css/bootstrap.min.css';
import SnapshotResponseComp from "./SnapshotResponseComp";

const FetchDataComp = ()  => {
    console.log("FetchDataComp");

    const [balanceSnapshot, setBalanceSnapshot] = useState(0);

    const [message, setMessage] = useState('');

    const [snapshotResponse, setSnapshotResponse] = useState(null);

    const handleSnapshotInputted = (newSnapshot) => {
        console.log("New Snapshot Inputted:",newSnapshot);

        setBalanceSnapshot(newSnapshot);
    }

    const handSnapshotSaved = async () => {
        await postBalance(balanceSnapshot);
    }

    const postBalance = async (newBalance) => {
        console.log("POST newBalanceSnapShot")
        try {
            const response = await axios.post('http://localhost:8002/balance/snapshot', {
                balance: parseFloat(newBalance),
                date: new Date().toISOString()
            });

            if (response.status === 200) {
                setMessage('Balance snapshot saved successfully');
                setSnapshotResponse(response.data);
            }
        } catch (error) {
            setMessage('Error saving balance: ' + error.message);
        }
    };

    return(
        <div className="container">
            <h1>FetchDataComp</h1>
            <BalanceSnapshotComp balance={balanceSnapshot}
                                 onBalanceChange={handleSnapshotInputted}
                                 onSave={handSnapshotSaved}
            />
            {message && <div className="alert alert-info">{message}</div>}
            <SnapshotResponseComp snapshotDelta={snapshotResponse}/>
        </div>
    );
}
export default FetchDataComp;
