// ProductList.java
package tutorial.persistence.models;

import java.util.List;

public class ProductList {

    private final long id;
    private final String name;
    private List<Product> products;

    public ProductList(String name) {
        this.id = -1;
        this.name = name;
    }

    public ProductList(long id, String name) {
        this.id = id;
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

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}