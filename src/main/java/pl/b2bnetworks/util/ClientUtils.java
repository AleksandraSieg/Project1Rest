package pl.b2bnetworks.util;

import pl.b2bnetworks.domain.Client;

import java.util.List;

public class ClientUtils {

    public double dailyIncome(List<Client> clients) {
        double sum = 0;

        for (Client client : clients) {
            sum = sum + client.getOrder();
        }

        return sum;
    }
}
