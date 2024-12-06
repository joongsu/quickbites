package quickbites.qubit.domain.guest.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import quickbites.qubit.domain.user.entity.Role;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    String name;
    String telephoneNumber;
    String password;

    @Enumerated(EnumType.STRING)
    Role role;

    @Builder
    public Guest(String telephoneNumber, String password, String name) {
        this.telephoneNumber = telephoneNumber;
        this.password = password;
        this.name = name;
    }
}
