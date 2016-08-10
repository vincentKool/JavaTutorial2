package tutorial.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tutorial.persistence.models.ProductList;
import tutorial.persistence.repositories.ProductListRepository;

import java.util.List;

@RestController
public class ProductListController extends ApiController {

    @Autowired
    ProductListRepository productListRepository;

    @RequestMapping(value="/lists", method= RequestMethod.GET)
    public List<ProductList> showAll() {
        return (List<ProductList>) productListRepository.findAll();
    }

    @RequestMapping(value="/lists/{productListId}", method=RequestMethod.GET)
    public ProductList show(@PathVariable("productListId") long productListId) {
        return productListRepository.findOne(productListId);
    }

}
