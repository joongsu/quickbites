package quickbites.qubit.domain.security.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import quickbites.qubit.domain.user.entity.Role;
import quickbites.qubit.domain.user.entity.User;

import java.util.ArrayList;
import java.util.Collection;

@RequiredArgsConstructor
public class AppUserDetails implements CustomUserDetails{

    private final User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(user.getRole().getValue()));
        return authorities;
    }

    @Override
    public String getId() {
        return user.getId().toString();
    }

    @Override
    public boolean hasRole(Role role) {
        return role.equals(user.getRole());
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }
}
