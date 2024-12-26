package quickbites.qubit.domain.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import quickbites.qubit.domain.owner.entity.Owner;
import quickbites.qubit.domain.user.entity.Role;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OwnerSignupReq extends SignupReq{
    private String ownerId;


    public static Owner toEntity(OwnerSignupReq ownerSignupReq, String encodedPassword) {
        return Owner.builder()
                .ownerId(ownerSignupReq.getOwnerId())
                .name(ownerSignupReq.getName())
                .telephoneNumber(ownerSignupReq.getTelephoneNumber())
                .password(encodedPassword)
                .role(Role.OWNER)
                .build();
    }
}
