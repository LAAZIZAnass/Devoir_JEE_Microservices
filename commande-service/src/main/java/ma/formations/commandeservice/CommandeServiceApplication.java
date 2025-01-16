package ma.formations.commandeservice;

import ma.formations.commandeservice.entities.Commande;
import ma.formations.commandeservice.repository.CommandeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class CommandeServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(CommandeServiceApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(CommandeRepository commandeRepository)  {
        return args -> {

            commandeRepository.save(Commande.builder()
                    .description("Commande 1")
                    .quantite(1)
                    .date(LocalDate.now())
                    .montant(12.0)
                    .productId(Long.valueOf(1))
                    .build());

            commandeRepository.save(Commande.builder()
                    .description("commande  2")
                    .quantite(3)
                    .date(LocalDate.now().minusDays(2))
                    .montant(35.5)
                    .productId(Long.valueOf(2))
                    .build());
            commandeRepository.save(Commande.builder()
                    .description("Commande 3")
                    .quantite(1)
                    .date(LocalDate.now())
                    .montant(12.0)
                    .productId(Long.valueOf(3))
                    .build());
            commandeRepository.save(Commande.builder()
                    .description("Commande  4")
                    .quantite(12)
                    .date(LocalDate.now().minusDays(2))
                    .montant(35.5)
                    .productId(Long.valueOf(4))
                    .build());
            commandeRepository.save(Commande.builder()
                    .description("Commande 5")
                    .quantite(1)
                    .date(LocalDate.now())
                    .montant(12.0)
                    .productId(Long.valueOf(5))
                    .build());
            commandeRepository.save(Commande.builder()
                    .description("Commande 6")
                    .quantite(3)
                    .date(LocalDate.now().minusDays(2))
                    .montant(35.5)
                    .productId(Long.valueOf(6))
                    .build());
            commandeRepository.save(Commande.builder()
                    .description("Commande 7")
                    .quantite(1)
                    .date(LocalDate.now())
                    .montant(17.0)
                    .productId(Long.valueOf(7))
                    .build());

            commandeRepository.save(Commande.builder()
                    .description("Commande 8")
                    .quantite(3)
                    .date(LocalDate.now().minusDays(2))
                    .montant(85.5)
                    .build());
            commandeRepository.save(Commande.builder()
                    .description("Commande 9")
                    .quantite(1)
                    .date(LocalDate.now())
                    .montant(12.0)
                    .productId(Long.valueOf(2))
                    .build());
            commandeRepository.save(Commande.builder()
                    .description("commande 10")
                    .quantite(3)
                    .date(LocalDate.now().minusDays(2))
                    .montant(35.5)
                    .productId(Long.valueOf(2))
                    .build());
            commandeRepository.save(Commande.builder()
                    .description("Commande 11")
                    .quantite(1)
                    .date(LocalDate.now())
                    .montant(12.0)
                    .productId(Long.valueOf(1))
                    .build());
            commandeRepository.save(Commande.builder()
                    .description("Commande 12")
                    .quantite(3)
                    .date(LocalDate.now().minusDays(2))
                    .montant(35.5)
                    .productId(Long.valueOf(9))
                    .build());
            commandeRepository.save(Commande.builder()
                    .description("Commande 13")
                    .quantite(2)
                    .date(LocalDate.now().minusDays(11)) // Date d'il y a 11 jours
                    .montant(50.0)
                    .productId(Long.valueOf(3))
                    .build());
            commandeRepository.save(Commande.builder()
                    .description("Commande 14")
                    .quantite(5)
                    .date(LocalDate.now().minusDays(15)) // Date d'il y a 15 jours
                    .montant(75.0)
                    .productId(Long.valueOf(4))
                    .build());
            commandeRepository.findAll().forEach(c -> {
                System.out.println("============================");
                System.out.println(c.getId());
                System.out.println(c.getDescription());
                System.out.println(c.getQuantite());
                System.out.println(c.getDate());
                System.out.println(c.getMontant());
                System.out.println(c.getProductId());
                System.out.println("===============================");
            });


        };
    }


}



