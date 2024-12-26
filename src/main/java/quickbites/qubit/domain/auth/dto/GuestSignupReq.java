package quickbites.qubit.domain.auth.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import quickbites.qubit.domain.guest.entity.Guest;
import quickbites.qubit.domain.user.entity.Role;

@Getter
@NoArgsConstructor
public class GuestSignupReq extends SignupReq{


    public static Guest toEntity(GuestSignupReq guestSignupReq, String encodedPassword) {
        return Guest.builder()
                .name(guestSignupReq.getName())
                .telephoneNumber(guestSignupReq.getTelephoneNumber())
                .password(encodedPassword)
                .role(Role.USER_GUEST)
                .build();
    }
}
