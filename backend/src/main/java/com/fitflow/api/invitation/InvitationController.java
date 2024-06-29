package com.fitflow.api.invitation;

import kotlin.RequiresOptIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InvitationController {

    private final InvitationRepository invitationRepository;

    @PostMapping("/api/auth/signin")
    public ResponseEntity<?> signInWithToken(@RequestBody SignInRequest signInRequest) {
        String token = signInRequest.getToken();
        String otp = signInRequest.getOtp();
        if (isValid(token, otp)) {
            return ResponseEntity.ok(new AuthResponse("OK"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid OTP");
        }
    }

    private boolean isValid(String token, String otp) {
        Invitation invitation = invitationRepository.findByToken(token)
                .orElseThrow();
        if (invitation != null && invitation.getOtp().equals(otp) && !invitation.isExpired() && !invitation.isAccepted()) {
            invitation.setAccepted(true);
            invitationRepository.save(invitation);
            return true;
        }
        return false;
    }
}
