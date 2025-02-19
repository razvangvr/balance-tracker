package raz.balance_tracker.model;

import java.time.ZonedDateTime;

public record BalanceSnapshot(float balance, ZonedDateTime createdDate) {
}
