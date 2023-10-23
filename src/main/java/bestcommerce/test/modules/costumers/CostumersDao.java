package bestcommerce.test.modules.costumers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostumersDao extends JpaRepository<Costumers, Long> {
}
