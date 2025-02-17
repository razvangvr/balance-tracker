package raz.balance_tracker.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import raz.balance_tracker.api.generated.models.BalanceSnapshotDTO;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class BalanceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testSaveBalanceSnapshot() throws Exception {
        BalanceSnapshotDTO balanceSnapshotDTO = new BalanceSnapshotDTO().balance(12748.98F);
        // Set properties of balanceSnapshotDTO as needed

        mockMvc.perform(post("/balance/snapshot")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(balanceSnapshotDTO)))
                .andExpect(status().isOk());
    }
}
