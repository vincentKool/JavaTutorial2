package tutorial.api.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tutorial.persistence.models.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController extends ApiController {

    @RequestMapping(value="/products", method=RequestMethod.GET)
    public List<Product> showAll() {
        List<Product> products = new ArrayList<>();

        products.add(new Product(1, "Macbook Air", new BigDecimal("999.95")));
        products.add(new Product(2, "Microsoft Surface 3", new BigDecimal("449")));
        products.add(new Product(3, "Chromebook Pixel C", new BigDecimal("595.50"))
        );

        return products;
    }

    @RequestMapping(value="/products/{productId}", method=RequestMethod.GET)
    public Product show(@PathVariable("productId") long productId) {
        return new Product(productId, "Macbook Air", new BigDecimal("999.95"));
    }

}