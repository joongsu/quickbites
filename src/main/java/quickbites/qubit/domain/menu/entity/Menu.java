package quickbites.qubit.domain.menu.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;
import quickbites.qubit.domain.ordermenu.entity.OrderMenu;
import quickbites.qubit.domain.store.entity.Store;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@Entity
@NoArgsConstructor(access = PROTECTED)
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;    // 메뉴명
    private int price;  // 메뉴 가격
    private int quantity; // 해당 메뉴의 수량
    private int dailyLimit; // 하루에 판매 가능한 최대 수량 , 추후에 동시에 신청하는 경우 문제 발생 가능성 있음

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STORE_ID")
    Store store;

    @OneToMany(mappedBy = "menu")
    List<OrderMenu> orderMenuList = new ArrayList<>();

    @Builder
    public Menu(String name, int price, int quantity, int dailyLimit) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.dailyLimit = dailyLimit;
    }
}
