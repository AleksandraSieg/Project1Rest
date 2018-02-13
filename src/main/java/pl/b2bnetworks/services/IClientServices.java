package pl.b2bnetworks.services;

import pl.b2bnetworks.domain.Client;

import java.util.List;

public interface IClientServices {

    List<Client> findAll();
    Client save(Client client);
    Client findOne(Long id);
    void delete(Long id);
}
