package quickbites.qubit.domain.security.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import quickbites.qubit.domain.user.entity.Role;
import quickbites.qubit.global.exception.CustomException;
import quickbites.qubit.global.response.error.ErrorType;

public interface CustomUserDetails extends UserDetails {
    String getId();

    boolean hasRole(Role role);

    default String getSingleAuthority() {
        return getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst()
                .orElseThrow(()-> new CustomException(ErrorType.ROLE_NOT_FOUND));
    }
}
