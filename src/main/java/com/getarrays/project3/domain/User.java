package com.getarrays.project3.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String userId;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String profileImageUrl;
    private Date lastLoginDate; //the last login date
    private Date lastLoginDateDisplay; //the actual date shown when they logged in
    private Date joinDate;
    private String[] roles; //ROLE_USER, ROLE_ADMIN. it holds the roles of the actual users
    private String[] authorities;
    private boolean isActive;
    private boolean isNotLocked;
}
