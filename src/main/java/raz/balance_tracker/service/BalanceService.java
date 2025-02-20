package raz.balance_tracker.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import raz.balance_tracker.api.generated.models.BalanceDeltaDTO;
import raz.balance_tracker.model.BalanceSnapshot;
import raz.balance_tracker.repository.ISnapshotRepository;
import raz.balance_tracker.web.BalanceController;

@RequiredArgsConstructor
@Service
public class BalanceService {

    private final ISnapshotRepository snapshotRepository;

    public BalanceDeltaDTO saveSnapshot(BalanceSnapshot balanceSnapshot) {

        BalanceSnapshot prev = snapshotRepository.getPrevious();

        BalanceSnapshot currentSaved = snapshotRepository.save(balanceSnapshot);


        float amountDelta = currentSaved.balance() - prev.balance();

        BalanceDeltaDTO delta = new BalanceDeltaDTO()
                .balance(amountDelta)
                .previous(BalanceController.toDTO( prev))
                .current(BalanceController.toDTO(currentSaved));


        return delta;
    }

    private BalanceSnapshot delta(BalanceSnapshot prev, BalanceSnapshot current){
        float amountDelta = current.balance() - prev.balance();
        BalanceSnapshot delta = new BalanceSnapshot(amountDelta, current.createdDate());
        return delta;
    }
}
