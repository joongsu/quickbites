package quickbites.qubit.domain.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import quickbites.qubit.domain.guest.entity.Guest;
import quickbites.qubit.domain.guest.repository.GuestRepository;
import quickbites.qubit.domain.owner.entity.Owner;
import quickbites.qubit.domain.owner.repository.OwnerRepository;
import quickbites.qubit.domain.security.dto.AppUserDetails;
import quickbites.qubit.domain.security.dto.GuestDetails;
import quickbites.qubit.domain.security.dto.OwnerDetails;
import quickbites.qubit.domain.user.entity.User;
import quickbites.qubit.domain.user.repository.UserRepository;
import quickbites.qubit.global.exception.CustomException;
import quickbites.qubit.global.response.error.ErrorType;


@Service
@RequiredArgsConstructor
public class MyAppUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final GuestRepository guestRepository;
    private final OwnerRepository ownerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String role = username.split(" ")[0];
        String id = username.split(" ")[1];

        switch (role) {
            case "USER" -> {
                User user = userRepository.findByUserId(id)
                        .orElseThrow(() -> new CustomException(ErrorType.NOT_FOUND));

                return new AppUserDetails(user);
            }
            case "USER_GUEST" -> {
                Guest guest = guestRepository.findByTelephoneNumber(id)
                        .orElseThrow(() -> new CustomException(ErrorType.NOT_FOUND));

                return new GuestDetails(guest);
            }
            case "OWNER" -> {

                Owner owner = ownerRepository.findByOwnerId(id)
                        .orElseThrow(() -> new CustomException(ErrorType.OWNER_NOT_FOUND));

                return new OwnerDetails(owner);
            }
        }

        return null;
    }
}
