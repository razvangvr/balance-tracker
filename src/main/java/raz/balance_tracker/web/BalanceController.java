package raz.balance_tracker.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import raz.balance_tracker.api.generated.controllers.BalanceApi;
import raz.balance_tracker.api.generated.models.BalanceSnapshotDTO;

@RestController
@Slf4j
public class BalanceController implements BalanceApi {

    @Override
    public ResponseEntity<Void> saveBalanceSnapshot(BalanceSnapshotDTO balanceSnapshotDTO) {


//        log.info("Saving balance snapshot: {}", balanceSnapshotDTO);
        System.out.println(balanceSnapshotDTO);

        return ResponseEntity.ok().build();
    }
}
