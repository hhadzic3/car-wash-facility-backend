package com.example.carwashfacility.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private boolean active;

    public enum Role {
        ROLE_USER, ROLE_ADMIN
    }

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "number_of_washes")
    private Integer numberOdWashes;
}
