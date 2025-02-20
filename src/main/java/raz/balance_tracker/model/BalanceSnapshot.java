package raz.balance_tracker.model;

import java.time.ZonedDateTime;

public record BalanceSnapshot(float balance, ZonedDateTime createdDate) implements Comparable<BalanceSnapshot> {

    @Override
    public int compareTo(BalanceSnapshot other) {
        return this.createdDate.compareTo(other.createdDate);
    }
}
