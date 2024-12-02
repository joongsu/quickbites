package quickbites.qubit.domain.OrderMenu;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import quickbites.qubit.domain.Menu.Menu;
import quickbites.qubit.domain.Order.Order;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MENU_ID")
    Menu menu;

    @Builder
    public OrderMenu(Order order, Menu menu){
        this.order = order;
        this.menu = menu;
    }
}
