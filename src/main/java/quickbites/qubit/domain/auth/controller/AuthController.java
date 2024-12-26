package quickbites.qubit.domain.auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import quickbites.qubit.domain.auth.dto.GuestSignupReq;
import quickbites.qubit.domain.auth.dto.OwnerSignupReq;
import quickbites.qubit.domain.auth.service.AuthService;
import quickbites.qubit.global.response.success.SuccessRes;
import quickbites.qubit.global.response.success.SuccessType;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup/guest")
    public ResponseEntity<?> signup(@RequestBody GuestSignupReq guestSignupReq) {
        authService.signupForGuest(guestSignupReq);
        return ResponseEntity
                .status(SuccessType.OK.getStatus())
                .body(SuccessRes.from(SuccessType.OK));
    }

    @PostMapping("/signup/owner")
    public ResponseEntity<?> signup(@RequestBody OwnerSignupReq ownerSignupReq) {
        authService.signupForOwner(ownerSignupReq);
        return ResponseEntity
                .status(SuccessType.OK.getStatus())
                .body(SuccessRes.from(SuccessType.OK));
    }
}
