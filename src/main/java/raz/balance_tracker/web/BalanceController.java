package raz.balance_tracker.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import raz.balance_tracker.api.generated.controllers.BalanceApi;
import raz.balance_tracker.api.generated.models.BalanceDeltaDTO;
import raz.balance_tracker.api.generated.models.BalanceSnapshotDTO;
import raz.balance_tracker.model.BalanceSnapshot;
import raz.balance_tracker.service.BalanceService;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
/**
 * Access to XMLHttpRequest at 'http://localhost:8002/balance/snapshot' from origin 'http://localhost:3000' has been blocked by CORS policy: Response to preflight request doesn't pass access control check: No 'Access-Control-Allow-Origin' header is present on the requested resource.
 * */

public class BalanceController implements BalanceApi {

    private final BalanceService balanceService;

    @Override
    public ResponseEntity<BalanceDeltaDTO> saveBalanceSnapshot(BalanceSnapshotDTO balanceSnapshotDTO) {


        log.info("Saving balance snapshot: {}", balanceSnapshotDTO);

        var balanceSnapshot = fromDTO(balanceSnapshotDTO);

        var delta = balanceService.saveSnapshot(balanceSnapshot);

        return ResponseEntity.ok(delta);
    }

    BalanceSnapshot fromDTO(BalanceSnapshotDTO balanceSnapshotDTO){
        ZonedDateTime now = ZonedDateTime.now();
        return new BalanceSnapshot(balanceSnapshotDTO.getBalance(), now);
    }

    public  static  BalanceSnapshotDTO toDTO(BalanceSnapshot balanceSnapshot){
        OffsetDateTime created = balanceSnapshot.createdDate().toOffsetDateTime();

        BalanceSnapshotDTO snapshotDTO = new BalanceSnapshotDTO()
                .date(created)
                .balance(balanceSnapshot.balance());

        return snapshotDTO;
    }
}
