package com.fitflow.api;

import com.fitflow.api.invitation.Invitation;
import com.fitflow.api.invitation.InvitationService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "My API", version = "v1", description = "Documentation of My API"))
public class ApiApplication {

    @Autowired
    private InvitationService invitationService;

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

  /*  @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        invitationService.sendInvitationEmail("romankiewicz.j@gmail.com", "Test", "Test");
    }
*/
}

