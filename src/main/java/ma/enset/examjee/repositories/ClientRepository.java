package ma.enset.examjee.repositories;

import ma.enset.examjee.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client, Long> {
}