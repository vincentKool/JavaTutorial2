package tutorial.persistence.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable=false)
    @NotNull
    @Size(min=1)
    private String name;

    @Column(nullable=false)
    @NotNull
    @DecimalMin(value="0")
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
