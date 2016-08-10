package tutorial.persistence.repositories;

import org.springframework.data.repository.CrudRepository;
import tutorial.persistence.models.ProductList;

public interface ProductListRepository extends CrudRepository<ProductList, Long> {

}
