package quickbites.qubit.domain.security.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import quickbites.qubit.domain.guest.entity.Guest;
import quickbites.qubit.domain.user.entity.Role;

import java.util.ArrayList;
import java.util.Collection;

@RequiredArgsConstructor
public class GuestDetails implements CustomUserDetails{

    private final Guest guest;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(guest.getRole().getValue()));
        return authorities;
    }

    @Override
    public String getId() {
        return guest.getId().toString();
    }

    @Override
    public boolean hasRole(Role role) {
        return role.equals(Role.USER_GUEST);
    }

    @Override
    public String getPassword() {
        return guest.getPassword();
    }

    @Override
    public String getUsername() {
        return guest.getTelephoneNumber(); // 따로 게스트 번호를 넣든지 해야할수도?
    }
}
