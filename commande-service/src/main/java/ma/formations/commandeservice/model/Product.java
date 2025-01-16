package ma.formations.commandeservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


public class Product {

    private Long id ;
    private String name;

    public String getName() {
        return name;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
