package com.adiprojects.springbootgorent.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Inheritance(
        strategy = InheritanceType.JOINED
)
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private long id;

    @ManyToOne
    @JoinColumn(name = "type_user", nullable = false)
    private TypeUser typeUser;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "gender")
    private String gender;

    @Column(name = "profile_picture_url")
    private String profilePictureUrl;
}
