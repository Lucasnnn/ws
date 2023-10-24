package bestcommerce.test.modules.Stores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoresDao extends JpaRepository<Stores, Long> {
}
