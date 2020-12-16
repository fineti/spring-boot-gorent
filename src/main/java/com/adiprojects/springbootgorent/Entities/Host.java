package com.adiprojects.springbootgorent.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "host")
@Getter
@Setter
public class Host extends User {

    @Column(name = "verified")
    private boolean verified;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "host")
    private Set<Apartment> apartments;
}
