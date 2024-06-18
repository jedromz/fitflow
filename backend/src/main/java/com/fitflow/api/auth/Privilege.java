package com.fitflow.api.auth;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Collection;

@Entity
@Getter
@Table(name = "privileges")
public class Privilege {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "privileges", fetch = FetchType.EAGER)
    private Collection<Role> roles;
}