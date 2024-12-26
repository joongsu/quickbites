package quickbites.qubit.domain.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignupReq {
    private String name;
    private String telephoneNumber;
    private String password;
}
