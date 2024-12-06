package quickbites.qubit.domain.guest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import quickbites.qubit.domain.guest.entity.Guest;

import java.util.Optional;
import java.util.UUID;

public interface GuestRepository extends JpaRepository<Guest, UUID> {
    Optional<Guest> findByTelephoneNumber(String telephoneNumber);
}
