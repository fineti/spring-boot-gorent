package com.adiprojects.springbootgorent.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "type_user")
@Getter
@Setter
public class TypeUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_user")
    private long id;

    @Column(name = "type_name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeUser")
    private Set<User> users;

}
