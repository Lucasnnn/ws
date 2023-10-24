package bestcommerce.test.modules.Customers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersDao extends JpaRepository<Customers, Long> {
    @Query(value = "SELECT * FROM customers u WHERE u.domain = ?1", nativeQuery = true)
    Customers findByDomain(String domain);
}
