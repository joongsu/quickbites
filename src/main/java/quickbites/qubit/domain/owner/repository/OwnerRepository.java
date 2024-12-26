package quickbites.qubit.domain.owner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import quickbites.qubit.domain.owner.entity.Owner;

import java.util.Optional;
import java.util.UUID;

public interface OwnerRepository extends JpaRepository<Owner, UUID> {
    Optional<Owner> findByOwnerId(String OwnerId);
    boolean existsByOwnerId(String ownerId);

}
