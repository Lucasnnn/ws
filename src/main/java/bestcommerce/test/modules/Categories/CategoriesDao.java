package bestcommerce.test.modules.Categories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesDao extends JpaRepository<Categories, Long> {
    @Query(value = "SELECT * FROM categories c where c.customer_id = ?1", nativeQuery = true)
    List<Categories> findAllByCustomer(Long customerId);
}
