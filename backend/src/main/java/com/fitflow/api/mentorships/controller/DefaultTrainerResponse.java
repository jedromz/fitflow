package com.fitflow.api.mentorships.controller;

import com.fitflow.api.mentorships.model.Trainer;

public class DefaultTrainerResponse implements TrainerResponse {

    private Long id;
    private String name;
    private String email;
    private String phone;

    // Constructor with all fields
    public DefaultTrainerResponse(Long id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    // Constructor from Trainer entity
    public DefaultTrainerResponse(Trainer trainer) {
        this.id = trainer.getId();
        this.name = trainer.getName();
        this.email = trainer.getEmail();
        this.phone = trainer.getPhone();
    }

    // Default constructor
    public DefaultTrainerResponse() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    // Setter methods (optional, if needed)
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
