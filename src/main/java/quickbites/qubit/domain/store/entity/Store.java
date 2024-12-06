package quickbites.qubit.domain.store.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import quickbites.qubit.domain.menu.entity.Menu;
import quickbites.qubit.domain.owner.entity.Owner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static lombok.AccessLevel.*;

@Entity
@NoArgsConstructor(access = PROTECTED)
public class Store {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    String name;
    String address;
    String telephoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OWNER_ID")
    Owner owner;    // 가게 점주

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Menu> menuList = new ArrayList<>();

    public Store(String name, Owner owner) {
        this.name = name;
        this.owner = owner;
    }
}
