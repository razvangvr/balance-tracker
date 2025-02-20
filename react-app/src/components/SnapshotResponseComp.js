import React from "react";

const SnapshotResponseComp = ({snapshotDelta})  => {
    console.log("OnePropertyCmp");
    return(
        <div>
            {snapshotDelta && <h3 className="alert alert-info"> {snapshotDelta.balance}</h3>}
        </div>
    );
}
export default SnapshotResponseComp;
