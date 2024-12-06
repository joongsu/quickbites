package quickbites.qubit.domain.security.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import quickbites.qubit.domain.owner.entity.Owner;
import quickbites.qubit.domain.user.entity.Role;

import java.util.ArrayList;
import java.util.Collection;

@RequiredArgsConstructor
public class OwnerDetails implements CustomUserDetails {

    private final Owner owner;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(owner.getRole().getValue()));
        return authorities;
    }


    @Override
    public String getId() {
        return owner.getId().toString();
    }

    @Override
    public boolean hasRole(Role role) {
        return role.equals(owner.getRole());
    }

    @Override
    public String getPassword() {
        return owner.getPassword();
    }

    @Override
    public String getUsername() {
        return owner.getOwnerId();
    }
}
