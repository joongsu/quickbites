package quickbites.qubit.domain.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import quickbites.qubit.domain.menu.entity.Menu;


public interface MenuRepository extends JpaRepository<Menu, Long> {
}
