package com.fitflow.api.invitation;

import com.fitflow.api.auth.User;
import com.fitflow.api.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Invitation extends BaseEntity {
    private String email;
    private String token;
    private String otp;
    private boolean accepted;
    private boolean expired;
    private String role = "ROLE_TRAINEE";
    private String name;
    private String surname;
    private String password;
    private String phone;
    @OneToOne
    private User user;
}
