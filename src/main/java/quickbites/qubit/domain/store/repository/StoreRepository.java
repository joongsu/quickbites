package quickbites.qubit.domain.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import quickbites.qubit.domain.store.entity.Store;

import java.util.UUID;

public interface StoreRepository extends JpaRepository<Store, UUID> {
}
