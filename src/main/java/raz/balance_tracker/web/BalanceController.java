package raz.balance_tracker.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import raz.balance_tracker.api.generated.controllers.BalanceApi;
import raz.balance_tracker.api.generated.models.BalanceSnapshotDTO;
import raz.balance_tracker.model.BalanceSnapshot;
import raz.balance_tracker.service.BalanceService;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

@RestController
@Slf4j
@RequiredArgsConstructor
public class BalanceController implements BalanceApi {

    private final BalanceService balanceService;

    @Override
    public ResponseEntity<BalanceSnapshotDTO> saveBalanceSnapshot(BalanceSnapshotDTO balanceSnapshotDTO) {


        log.info("Saving balance snapshot: {}", balanceSnapshotDTO);
        System.out.println(balanceSnapshotDTO);

        var balanceSnapshot = fromDTO(balanceSnapshotDTO);
        BalanceSnapshot delta = balanceService.saveSnapshot(balanceSnapshot);

        return ResponseEntity.ok(toDTO(delta));
    }

    BalanceSnapshot fromDTO(BalanceSnapshotDTO balanceSnapshotDTO){
        ZonedDateTime now = ZonedDateTime.now();
        return new BalanceSnapshot(balanceSnapshotDTO.getBalance(), now);
    }

    BalanceSnapshotDTO toDTO(BalanceSnapshot balanceSnapshot){
        OffsetDateTime created = balanceSnapshot.createdDate().toOffsetDateTime();

        BalanceSnapshotDTO snapshotDTO = new BalanceSnapshotDTO()
                .date(created)
                .balance(balanceSnapshot.balance());

        return snapshotDTO;
    }
}
