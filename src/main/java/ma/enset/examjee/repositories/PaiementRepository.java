package ma.enset.examjee.repositories;

import ma.enset.examjee.entities.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {

}