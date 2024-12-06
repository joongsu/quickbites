package quickbites.qubit.domain.ordermenu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import quickbites.qubit.domain.ordermenu.entity.OrderMenu;

import java.util.UUID;

public interface OrderMenuRepository extends JpaRepository<OrderMenu, UUID> {
}
