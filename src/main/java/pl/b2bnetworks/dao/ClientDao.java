package pl.b2bnetworks.dao;

import org.springframework.data.repository.CrudRepository;
import pl.b2bnetworks.domain.Client;

public interface ClientDao extends CrudRepository<Client, Long> {
}
