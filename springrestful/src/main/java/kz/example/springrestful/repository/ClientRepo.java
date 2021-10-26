package kz.example.springrestful.repository;

import kz.example.springrestful.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends CrudRepository<Client, Long> {

    Client findByIin(String iin);
}
