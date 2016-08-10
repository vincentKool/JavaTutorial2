package tutorial.persistence.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProductList {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable=false)
    private String name;

    @ManyToMany
    @JsonManagedReference
    private List<Product> products;

    public ProductList() {}

    public ProductList(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return products;
    }

}
