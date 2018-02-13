package pl.b2bnetworks.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.b2bnetworks.dao.ClientDao;
import pl.b2bnetworks.domain.Client;

import java.util.List;

@Service
public class ClientServicesImpl implements IClientServices{

    @Autowired
    private ClientDao clientDao;

    @Override
    public List<Client> findAll() {
        return (List<Client>)clientDao.findAll();
    }

    @Override
    public Client save(Client client) {
        return clientDao.save(client);
    }

    @Override
    public Client findOne(Long id) {
        return clientDao.findOne(id);
    }

    @Override
    public void delete(Long id) {
        clientDao.delete(id);
    }
}
