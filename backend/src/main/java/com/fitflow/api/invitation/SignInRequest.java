package com.fitflow.api.invitation;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInRequest {
    private String token;
    private String otp;
}
