package tutorial.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tutorial.persistence.models.Product;
import tutorial.persistence.repositories.ProductRepository;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ProductController extends ApiController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value="/products", method=RequestMethod.GET)
    public List<Product> showAll() {
        return (List<Product>) productRepository.findAll();
    }

    @RequestMapping(value="/products/{productId}", method=RequestMethod.GET)
    public Product show(@PathVariable("productId") long productId) {
        return productRepository.findOne(productId);
    }

}
