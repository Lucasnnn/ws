package bestcommerce.test.modules.users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDao extends JpaRepository<Users, Long> {
    @Query(value = "SELECT * FROM users u WHERE u.email = ?1 AND u.customer_id = ?2", nativeQuery = true)
    Optional<Users> findUserByEmailAndCustomerId(String email, Long customerId);

    @Query(value = "SELECT * FROM users u WHERE u.token = ?1", nativeQuery = true)
    Optional<Users> findByToken(String token);
}
