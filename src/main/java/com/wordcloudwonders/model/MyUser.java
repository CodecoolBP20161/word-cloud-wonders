package com.wordcloudwonders.model;

import com.wordcloudwonders.security.Role;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@ToString(exclude = "password")
@Entity
public class MyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Role role;

}
