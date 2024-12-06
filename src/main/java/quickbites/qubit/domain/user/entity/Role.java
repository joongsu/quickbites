package quickbites.qubit.domain.user.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {


    USER("ROLE_USER"),
    USER_GUEST("ROLE_USER_GUEST"),
    ADMIN("ROLE_ADMIN"),
    OWNER("ROLE_OWNER");

    private final String value;
}

