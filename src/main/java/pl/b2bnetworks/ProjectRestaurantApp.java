package pl.b2bnetworks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.b2bnetworks.dao.ClientDao;
import pl.b2bnetworks.domain.Client;

@SpringBootApplication
public class ProjectRestaurantApp implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(ProjectRestaurantApp.class, args);
    }

    @Autowired
    private ClientDao clientDao;

    public void run(String... strings) throws Exception {
        Client client1 = Client.builder().surname("Kowalski").positionFromMenu(50.40).build();
        clientDao.save(client1);
        Client client2 = Client.builder().surname("Nowak").positionFromMenu(90.40).build();
        clientDao.save(client2);
    }
}
