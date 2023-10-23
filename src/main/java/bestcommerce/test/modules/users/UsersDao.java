package bestcommerce.test.modules.users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDao extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email);
}
