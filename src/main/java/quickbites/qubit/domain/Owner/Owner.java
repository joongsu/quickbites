package quickbites.qubit.domain.Owner;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import quickbites.qubit.domain.Store.Store;
import quickbites.qubit.domain.User.Role;

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

    private String name;
    private String telephoneNumber;

    @OneToMany(mappedBy = "owner")
    List<Store> storeList = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    Role role;

    @Builder
    public Owner(String name, String telephoneNumber) {
        this.name = name;
        this.telephoneNumber = telephoneNumber;
    }
}
