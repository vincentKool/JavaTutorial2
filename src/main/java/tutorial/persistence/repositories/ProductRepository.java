package tutorial.persistence.repositories;

import org.springframework.data.repository.CrudRepository;
import tutorial.persistence.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
