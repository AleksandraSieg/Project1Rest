package pl.b2bnetworks.util;

import org.junit.Test;
import pl.b2bnetworks.domain.Client;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ClientUtilsTest {
    private ClientUtils clientUtils = new ClientUtils();

    @Test
    public void dailyIncome() throws Exception {
        List<Client> clients = Arrays.asList(new Client().builder().positionFromMenu(30.20).build(),
                new Client().builder().positionFromMenu(40.20).build(),
                new Client().builder().positionFromMenu(60.20).build());

        assertEquals(130.60, clientUtils.dailyIncome(clients), 0.01);
    }

}