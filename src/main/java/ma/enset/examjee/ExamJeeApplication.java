package ma.enset.examjee;

import ma.enset.examjee.entities.Client;
import ma.enset.examjee.entities.ContratAutomobile;
import ma.enset.examjee.entities.ContratHabitation;
import ma.enset.examjee.entities.Paiement;
import ma.enset.examjee.enums.StatutContrat;
import ma.enset.examjee.enums.TypeLogement;
import ma.enset.examjee.enums.TypePaiement;
import ma.enset.examjee.repositories.ClientRepository;
import ma.enset.examjee.repositories.ContratRepository;
import ma.enset.examjee.repositories.PaiementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class ExamJeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamJeeApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ClientRepository clientRepo,
                            ContratRepository contratRepo,
                            PaiementRepository paiementRepo) {
        return args -> {
            Stream.of("Hassan","Amal","Ahmed").forEach(nom -> {
                Client client = new Client();
                client.setNom(nom);
                client.setEmail(nom.toLowerCase() + "@gmail.com");
                clientRepo.save(client);
            });

            Client client1 = clientRepo.findAll().get(0);
            ContratAutomobile c1 = new ContratAutomobile();
            c1.setClient(client1);
            c1.setDateSouscription(new Date());
            c1.setStatut(StatutContrat.EN_COURS);
            c1.setMontantCotisation(1200.50);
            c1.setMatricule("80-A-123");
            c1.setMarque("Renault");
            c1.setModele("C15");
            contratRepo.save(c1);

            ContratHabitation c2 = new ContratHabitation();
            c2.setClient(client1);
            c2.setDateSouscription(new Date());
            c2.setStatut(StatutContrat.VALIDE);
            c2.setMontantCotisation(800);
            c2.setTypeLogement(TypeLogement.MAISON);
            c2.setAdresse("Hay rbaa kdim Midelt");
            contratRepo.save(c2);

            Paiement p1 = new Paiement();
            p1.setContrat(c1);
            p1.setDate(new Date());
            p1.setMontant(100.00);
            p1.setType(TypePaiement.MENSUALITE);
            paiementRepo.save(p1);
        };
    }

}
