package com.adiprojects.springbootgorent.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Set<Apartment> apartments;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "host")
    @JsonIgnore
    private Set<Booking> booking;
}
