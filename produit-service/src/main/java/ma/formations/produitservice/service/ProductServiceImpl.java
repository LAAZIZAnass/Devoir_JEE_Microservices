package ma.formations.produitservice.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import ma.formations.produitservice.model.Product;
import ma.formations.produitservice.model.Product;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    private static List<Product> productRepo = new ArrayList<>();

    static {
        productRepo.add(new Product(1L, "PC PORTABLE HP"));
        productRepo.add(new Product(2L, "TV LG 32p"));
        productRepo.add(new Product(3L, "TV Sony 49p"));
        productRepo.add(new Product(4L, "Camera Sony"));
        productRepo.add(new Product(5L, "PC PORTABLE HP"));
        productRepo.add(new Product(6L, "TV LG 32p"));
        productRepo.add(new Product(7L, "TV Sony 49p"));
        productRepo.add(new Product(8L, "Camera Sony"));
        productRepo.add(new Product(9L, "PC PORTABLE HP"));
        productRepo.add(new Product(10L, "TV LG 32p"));
        productRepo.add(new Product(11L, "TV Sony 49p"));
        productRepo.add(new Product(12L, "Camera Sony"));
    }

    // Application du CircuitBreaker et TimeLimiter avec un délai de timeout
    @Override
    @CircuitBreaker(name = "productService", fallbackMethod = "fallbackGetAllProducts")
    @TimeLimiter(name = "productService", fallbackMethod = "fallbackGetAllProducts") // Timeout de 3 secondes
    public List<Product> getAll() {
        long startTime = System.currentTimeMillis(); // Enregistrer l'heure de début
        try {
            // Simuler un délai de 5 secondes pour provoquer un timeout
            System.out.println("Démarrage de la simulation de délai...");
            Thread.sleep(5000);
            long endTime = System.currentTimeMillis(); // Enregistrer l'heure de fin
            System.out.println("Délai simulé : " + (endTime - startTime) + "ms"); // Afficher le temps écoulé
            return productRepo;
        } catch (InterruptedException e) {
            long endTime = System.currentTimeMillis(); // Enregistrer l'heure de fin
            System.out.println("Délai interrompu, temps écoulé : " + (endTime - startTime) + "ms");
            return fallbackGetAllProducts(e);
        }
    }

    // Méthode fallback en cas de timeout ou d'échec
    public List<Product> fallbackGetAllProducts(Throwable t) {
        System.out.println("Fallback déclenché : " + t.getMessage());
        return Collections.emptyList();
    }

    @Override
    public Product getById(Long id) {
        if (productRepo == null || productRepo.isEmpty()) {
            System.out.println("Le produit n'existe pas : " + id);
            return null;
        }
        for (Product product : productRepo) {
            if (id.equals(product.getId())) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(Long id, Product product) {
        Product productFound = getById(id);
        if (productFound == null) {
            System.out.println("Produit non trouvé pour mise à jour : " + id);
            return;
        }
        productRepo.remove(productFound);
        product.setId(id);
        productRepo.add(product);
        System.out.println("Produit mis à jour : " + product);
    }

    @Override
    public void delete(Long id) {
        Product productFound = getById(id);
        if (productFound == null) {
            System.out.println("Produit non trouvé pour suppression : " + id);
            return;
        }
        productRepo.remove(productFound);
        System.out.println("Produit supprimé : " + productFound);
    }

    @Override
    public void create(Product product) {
        productRepo.add(product);
        System.out.println("Produit créé : " + product);
    }
}
