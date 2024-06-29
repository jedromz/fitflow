package com.fitflow.api.invitation;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InvitationService {

    private final InvitationRepository invitationRepository;
    private final JavaMailSender mailSender;

    public void sendInvitationEmail(String toEmail, String name, String surname) {
        String subject = "Invitation to join FitFlow as a Trainee";
        String token = UUID.randomUUID().toString();
        String otp = generateOTP();
        String invitationLink = "http://localhost:3000/sign-in?token=" + token;

        String body = String.format("Hello %s %s,\n\nYou are invited to join FitFlow as a Trainee. Please click the link below to sign up:\n%s\n\nYour one-time password (OTP) is: %s\n\nBest regards,\nFitFlow Team",
                name, surname, invitationLink, otp);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("fromemail@gmail.com");
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
        System.out.println("Mail sent...");

        Invitation invitation = new Invitation();
        invitation.setEmail(toEmail);
        invitation.setToken(token);
        invitation.setOtp(otp);
        invitation.setAccepted(false);
        invitation.setExpired(false);
        invitation.setRole("ROLE_TRAINEE");
        invitation.setName(name);
        invitation.setSurname(surname);

        invitationRepository.save(invitation);
    }

    private String generateOTP() {
        SecureRandom random = new SecureRandom();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }
}
