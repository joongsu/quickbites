package quickbites.qubit.domain.owner.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import quickbites.qubit.domain.store.entity.Store;
import quickbites.qubit.domain.user.entity.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static lombok.AccessLevel.*;

@Entity
@NoArgsConstructor(access = PROTECTED)
@Getter
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String ownerId;
    private String password;
    private String name;
    private String telephoneNumber;

    @OneToMany(mappedBy = "owner")
    List<Store> storeList = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    Role role;

    @Builder
    public Owner(
            String ownerId,
            String password,
            String name,
            String telephoneNumber,
            Role role
            ) {
        this.ownerId = ownerId;
        this.password = password;
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.role = role;
    }
}
