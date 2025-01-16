package ma.formations.commandeservice.repository;

import ma.formations.commandeservice.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@RepositoryRestResource
public interface CommandeRepository extends JpaRepository<Commande, Long> {
    @Query("SELECT c FROM Commande c WHERE c.date >= :date")
    List<Commande> findCommandesLastDays(@Param("date") LocalDate date);
}
