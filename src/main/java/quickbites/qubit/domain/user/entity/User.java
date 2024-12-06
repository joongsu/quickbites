package quickbites.qubit.domain.user.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    private String name;

    //private String providerUserInfo;
    private String userId;
    @Enumerated(EnumType.STRING)
    private Role role;

    private String email;

    @Builder
    public User(String name, String userId, String email) {
        this.name = name;
        this.userId = userId;
        //this.providerUserInfo = provider + " " + providerId;
        this.email = email;
        this.role = Role.USER;
    }

}
