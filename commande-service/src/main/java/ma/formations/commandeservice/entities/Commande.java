package ma.formations.commandeservice.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.formations.commandeservice.model.Product;

import java.time.LocalDate;

@Entity
@AllArgsConstructor @Getter @Setter @Builder
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private int quantite;
    private LocalDate date;
    private double montant;
    @Transient
    private Product product;
    private Long productId;



    public Commande() {
    }

    public Commande(String description, int quantite, LocalDate date, double montant,Long productId) {
        this.description = description;
        this.quantite = quantite;
        this.date = date;
        this.montant = montant;
        this.productId = productId;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {this.montant = montant;}

    public Long getProductId() {return productId;}
    public void setProductId(Long productId) {this.productId = productId;}


    public static CommandeBuilder builder() {
        return new CommandeBuilder();
    }

    public static class CommandeBuilder {
        private String description;
        private int quantite;
        private LocalDate date;
        private double montant;
        private Long productId;

        public CommandeBuilder description(String description) {
            this.description = description;
            return this;
        }

        public CommandeBuilder quantite(int quantite) {
            this.quantite = quantite;
            return this;
        }

        public CommandeBuilder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public CommandeBuilder montant(double montant) {
            this.montant = montant;
            return this;
        }
        public CommandeBuilder productId(Long productId) {
            this.productId = productId;
            return this;
        }


        public Commande build() {
            return new Commande(description, quantite, date, montant,productId);
        }
    }
}

