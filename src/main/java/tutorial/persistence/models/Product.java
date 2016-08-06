// Product.java
package tutorial.persistence.models;

import java.math.BigDecimal;

public class Product {

    private final long id;
    private final String name;
    private final BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.id = -1;
        this.name = name;
        this.price = price;
    }

    public Product(long id, String name, BigDecimal price) {
        this.id = id;
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

}