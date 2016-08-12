package tutorial.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tutorial.persistence.models.Product;
import tutorial.persistence.repositories.ProductRepository;
import tutorial.services.youtube.YoutubeService;
import tutorial.services.youtube.api.YoutubeVideo;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ProductController extends ApiController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    YoutubeService youtubeService;

    @RequestMapping(value="/products", method=RequestMethod.GET)
    public List<Product> showAll() {
        return (List<Product>) productRepository.findAll();
    }

    @RequestMapping(value="/products/{productId}", method=RequestMethod.GET)
    public Product show(@PathVariable("productId") long productId) {
        return productRepository.findOne(productId);
    }

    @RequestMapping(value="/products/{productId}/youtube", method=RequestMethod.GET)
    public List<YoutubeVideo> getYoutubeVideos(@PathVariable("productId")
                                                       long productId) {
        Product product = productRepository.findOne(productId);

        return youtubeService.searchVideos(product.getName());
    }

    @RequestMapping(value="/products", method = RequestMethod.POST)
    public void insert(@RequestParam("name") String name,
                       @RequestParam("price") BigDecimal price) {
        Product product = new Product(name, price);
        productRepository.save(product);
    }
}
