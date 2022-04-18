package fa.training.srumanagementg4.repository;

import fa.training.srumanagementg4.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email);
    Boolean existsByAccount(String account);
    Boolean existsByEmail(String email);

    @Query("select u from Users u where u.account = ?1")
    Users getByAccount(String account);
}
