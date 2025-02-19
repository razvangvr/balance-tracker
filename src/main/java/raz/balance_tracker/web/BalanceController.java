package raz.balance_tracker.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import raz.balance_tracker.api.generated.controllers.BalanceApi;
import raz.balance_tracker.api.generated.models.BalanceSnapshotDTO;
import raz.balance_tracker.service.BalanceService;

@RestController
@Slf4j
@RequiredArgsConstructor
public class BalanceController implements BalanceApi {

    private final BalanceService balanceService;

    @Override
    public ResponseEntity<Void> saveBalanceSnapshot(BalanceSnapshotDTO balanceSnapshotDTO) {


        log.info("Saving balance snapshot: {}", balanceSnapshotDTO);
        System.out.println(balanceSnapshotDTO);

        balanceService.saveSnapshot(balanceSnapshotDTO);

        return ResponseEntity.ok().build();
    }
}
