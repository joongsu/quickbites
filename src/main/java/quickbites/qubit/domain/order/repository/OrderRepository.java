package quickbites.qubit.domain.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import quickbites.qubit.domain.order.entity.Order;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}
