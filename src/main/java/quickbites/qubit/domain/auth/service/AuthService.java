package quickbites.qubit.domain.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RestController;
import quickbites.qubit.domain.auth.dto.GuestSignupReq;
import quickbites.qubit.domain.auth.dto.OwnerSignupReq;
import quickbites.qubit.domain.guest.entity.Guest;
import quickbites.qubit.domain.guest.repository.GuestRepository;
import quickbites.qubit.domain.owner.entity.Owner;
import quickbites.qubit.domain.owner.repository.OwnerRepository;
import quickbites.qubit.global.exception.CustomException;
import quickbites.qubit.global.response.error.ErrorType;


@RestController
@RequiredArgsConstructor
public class AuthService {
    private final GuestRepository guestRepository;
    private final OwnerRepository ownerRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void signupForGuest(GuestSignupReq guestSignupReq) {
        if(guestRepository.existsByName(guestSignupReq.getName()))
            throw new CustomException(ErrorType.ALREADY_EXISTS_GUEST);
        Guest guest = GuestSignupReq.toEntity(guestSignupReq, bCryptPasswordEncoder.encode(guestSignupReq.getPassword()));
        guestRepository.save(guest);
    }

    public void signupForOwner(OwnerSignupReq ownerSignupReq) {
        if(ownerRepository.existsByOwnerId(ownerSignupReq.getOwnerId()))
            throw new CustomException(ErrorType.ALREADY_EXISTS_Owner);
        Owner owner = OwnerSignupReq.toEntity(ownerSignupReq, bCryptPasswordEncoder.encode(ownerSignupReq.getPassword()));
        ownerRepository.save(owner);
    }
}
