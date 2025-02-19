import React, { useState } from 'react';
import BalanceSnapshotComp from "./BalanceSnapshotComp";

const FetchDataComp = ()  => {
    console.log("FetchDataComp");

    const [balanceSnapshot, setBalanceSnapshot] = useState(0);

    const handleSnapshotUpdate = (newSnapshot) => {
        console.log("New SnapshotUpdate:",newSnapshot);
        setBalanceSnapshot(newSnapshot);
    }

    return(
        <div className="container">
            <h1>FetchDataComp</h1>
            <BalanceSnapshotComp balance={balanceSnapshot}  onBalanceChange={handleSnapshotUpdate} />
        </div>
    );
}
export default FetchDataComp;
