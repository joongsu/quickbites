package quickbites.qubit.domain.Order;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;
import quickbites.qubit.domain.OrderMenu.OrderMenu;
import quickbites.qubit.domain.Store.Store;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static lombok.AccessLevel.*;

@Entity
@NoArgsConstructor(access = PROTECTED)
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Integer orderNumber;

    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(mappedBy = "order")
    List<OrderMenu> orderMenuList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STORE_ID")
    Store store;

    @Builder
    public Order(Integer orderNumber, LocalDateTime createdAt, Store store, OrderStatus status) {
        this.orderNumber = orderNumber;
        this.createdAt = createdAt;
        this.store = store;
        this.status = status;
    }
}
