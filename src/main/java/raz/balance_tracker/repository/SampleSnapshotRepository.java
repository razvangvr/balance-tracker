package raz.balance_tracker.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import raz.balance_tracker.model.BalanceSnapshot;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component
@Slf4j
public class SampleSnapshotRepository implements ISnapshotRepository {


    public static final int BALANCE_T0 = 1000;//Initial Balance, Origin Balance
    private final BalanceSnapshot t0;

    private BalanceSnapshot previous;//tn_1

    private BalanceSnapshot latestSnapshot;


    public SampleSnapshotRepository() {
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2025, 1, 1, 0, 0, 0, 0, ZoneId.systemDefault());
        t0 = new BalanceSnapshot(BALANCE_T0, zonedDateTime);

        //For simplicity il initializez si pe  Tn-1 tot cu T0, adica cu Origin
        /**
         * Ca sa nu ma complic cu daca nu am T-1 si se apeleaza saveSnapshot, atunci
         * */
//        previous = t0;
        //Sau mai bine NU!
        /**
         * M-am razgandit, la Primul SnapShot Salvat,
         * T-1 o sa fie Latest,
         * si Diferenta o sa fie 0
         * */
    }

    @Override
    public BalanceSnapshot save(BalanceSnapshot balanceSnapshot) {

        latestSnapshot = balanceSnapshot;

        if (previous == null) {
            previous = balanceSnapshot;
            log.info("Initializing Tn-1 with:{}", balanceSnapshot.balance());
        }


        return latestSnapshot;
    }

    @Override
    public BalanceSnapshot getPrevious() {
        return previous;
    }
}
