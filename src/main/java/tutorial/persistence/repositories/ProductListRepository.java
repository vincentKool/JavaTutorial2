package tutorial.persistence.repositories;

import org.springframework.data.repository.CrudRepository;
import tutorial.persistence.models.ProductList;

import java.util.List;

public interface ProductListRepository extends CrudRepository<ProductList, Long> {

    List<ProductList> findByProductsIsNotNull();
}
