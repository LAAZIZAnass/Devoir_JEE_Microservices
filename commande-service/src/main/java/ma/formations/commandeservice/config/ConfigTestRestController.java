package ma.formations.commandeservice.config;

import ma.formations.commandeservice.entities.Commande;
import ma.formations.commandeservice.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RefreshScope
public class ConfigTestRestController {
    @Value("${mes-config-ms.commandes-last}")
    private int commandesLast ;


    @Autowired
    private CommandeRepository commandeRepository;

    @GetMapping("/recentes")
    public List<Commande> getCommandes() {
        LocalDate dateLimite = LocalDate.now().minusDays(commandesLast);
        return commandeRepository.findCommandesLastDays(dateLimite);
    }

}
