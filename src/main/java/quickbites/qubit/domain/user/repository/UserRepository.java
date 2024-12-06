package quickbites.qubit.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import quickbites.qubit.domain.user.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUserId(String userId);
}
