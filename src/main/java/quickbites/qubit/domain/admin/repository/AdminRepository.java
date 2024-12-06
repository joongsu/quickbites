package quickbites.qubit.domain.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import quickbites.qubit.domain.admin.entity.Admin;

import java.util.UUID;

public interface AdminRepository extends JpaRepository<Admin, UUID> {
}
