package raz.balance_tracker.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import raz.balance_tracker.model.BalanceSnapshot;
import raz.balance_tracker.repository.ISnapshotRepository;

@RequiredArgsConstructor
@Service
public class BalanceService {

    private final ISnapshotRepository snapshotRepository;

    public BalanceSnapshot saveSnapshot(BalanceSnapshot balanceSnapshot) {

        BalanceSnapshot currentSaved = snapshotRepository.save(balanceSnapshot);

        BalanceSnapshot prev = snapshotRepository.getPrevious();

        BalanceSnapshot balanceDelta = delta(prev, currentSaved);

        return balanceDelta;
    }

    private BalanceSnapshot delta(BalanceSnapshot prev, BalanceSnapshot current){
        float amountDelta = current.balance() - prev.balance();
        BalanceSnapshot delta = new BalanceSnapshot(amountDelta, current.createdDate());
        return delta;
    }
}
