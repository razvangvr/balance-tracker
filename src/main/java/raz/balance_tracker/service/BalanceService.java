package raz.balance_tracker.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import raz.balance_tracker.api.generated.models.BalanceSnapshotDTO;
import raz.balance_tracker.repository.ISnapshotRepository;

@RequiredArgsConstructor
@Service
public class BalanceService {

    private final ISnapshotRepository snapshotRepository;

    public void saveSnapshot(BalanceSnapshotDTO balanceSnapshotDTO) {
    }
}
