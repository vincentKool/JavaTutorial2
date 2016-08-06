package tutorial.api.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tutorial.persistence.models.Product;
import tutorial.persistence.models.ProductList;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductListController extends ApiController {

    @RequestMapping(value="/lists", method= RequestMethod.GET)
    public List<ProductList> showAll() {
        List<ProductList> productLists = new ArrayList<>();

        for (int i = 1; i < 4; i++) {
            ProductList productList = new ProductList(i, "Tech Goodies (" + i + ")"
            );

            List<Product> products = new ArrayList<>();
            products.add(new Product(1, "Macbook Air", new BigDecimal("999.95")));
            products.add(new Product(2, "Microsoft Surface 3", new BigDecimal("449"
            )));
            productList.setProducts(products);

            productLists.add(productList);
        }

        return productLists;
    }

    @RequestMapping(value="/lists/{productListId}", method=RequestMethod.GET)
    public ProductList show(@PathVariable("productListId") long productListId) {
        ProductList productList = new ProductList(productListId, "Tech Goodies (" + productListId + ")");

        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Macbook Air", new BigDecimal("999.95")));
        products.add(new Product(2, "Microsoft Surface 3", new BigDecimal("449")));
        productList.setProducts(products);

        return productList;
    }

}