package ma.formations.commandeservice.health;

import ma.formations.commandeservice.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CommandeHealthIndicator implements HealthIndicator {

    @Autowired
    private CommandeRepository commandeRepository;

    @Override
    public Health health() {
        long count = commandeRepository.count();

        if (count > 0) {
            return Health.up().withDetail("message", "Commandes disponibles: " + count).build();
        } else {
            return Health.down().withDetail("message", "Aucune commande disponible").build();
        }
    }
}
