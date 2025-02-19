package raz.balance_tracker.repository;

import raz.balance_tracker.model.BalanceSnapshot;

public interface ISnapshotRepository {
    BalanceSnapshot save(BalanceSnapshot balanceSnapshot);

    /**
     * as I'm Saving this Current BalanceSnapshot
     * Get the Last/Previous BalanceSnapshot, RIGHT BEFORE THIS ONE!
     * */
    BalanceSnapshot getPrevious();

}
