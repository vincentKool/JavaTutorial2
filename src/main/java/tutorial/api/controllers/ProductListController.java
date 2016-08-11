package tutorial.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tutorial.persistence.models.Product;
import tutorial.persistence.models.ProductList;
import tutorial.persistence.repositories.ProductListRepository;
import tutorial.persistence.repositories.ProductRepository;

import java.util.List;

@RestController
public class ProductListController extends ApiController {

    @Autowired
    ProductListRepository productListRepository;
    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value="/lists", method= RequestMethod.GET)
    public List<ProductList> showAll() {
        return (List<ProductList>) productListRepository.findAll();
    }

    @RequestMapping(value="/lists/{productListId}", method=RequestMethod.GET)
    public ProductList show(@PathVariable("productListId") long productListId) {
        return productListRepository.findOne(productListId);
    }

    @RequestMapping(value = "/lists", method = RequestMethod.POST)
    public void insert(@RequestParam("name") String name) {
        ProductList productList = new ProductList(name);
        productListRepository.save(productList);
    }

    @RequestMapping(path = "/lists/{listId}/products", method = RequestMethod.POST)
    public void addProduct(@PathVariable("listId") long listId,
                           @RequestParam("productId") long productId) throws IllegalArgumentException {
        ProductList productList = productListRepository.findOne(listId);
        Product product = productRepository.findOne(productId);

        if(product == null) throw new IllegalArgumentException("The product with productId: "+productId+ " does not exist");
        if(productList == null) throw new IllegalArgumentException("The productList with listId: "+listId + " does not exist");

        productList.getProducts().add(product);
        productListRepository.save(productList);
    }
}
