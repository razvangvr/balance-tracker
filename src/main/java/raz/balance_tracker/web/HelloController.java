package raz.balance_tracker.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import raz.balance_tracker.api.generated.controllers.GreetingApi;
import raz.balance_tracker.api.generated.models.GreetingDTO;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
public class HelloController implements GreetingApi {

    @Override
    public ResponseEntity<List<GreetingDTO>> getGreetings() {
        GreetingDTO a = new GreetingDTO().content("a").id(UUID.randomUUID()).companyId("1");
        List<GreetingDTO> greetings = List.of(a);
        return ResponseEntity.ok(greetings);
    }
}
