package tutorial.persistence.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private BigDecimal price;

    @ManyToMany(mappedBy="products")
    @JsonBackReference
    private List<ProductList> lists;

    public Product() {}

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public List<ProductList> getLists() {
        return lists;
    }

}
