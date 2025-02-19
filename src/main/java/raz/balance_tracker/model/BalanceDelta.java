//package raz.balance_tracker.model;
//
//public record BalanceDelta (BalanceSnapshot previous, BalanceSnapshot current) {
//
//    public BalanceSnapshot delta(){
//        float amountDelta = current.balance() - previous().balance();
//        BalanceSnapshot delta = new BalanceSnapshot(amountDelta, current.createdDate());
//        return delta;
//    }
//}
