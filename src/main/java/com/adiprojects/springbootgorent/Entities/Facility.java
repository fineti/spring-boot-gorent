package com.adiprojects.springbootgorent.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "facility")
@Getter
@Setter
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_facility")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "icon_type")
    private String iconType;

    @ManyToMany (mappedBy = "facilities")
    private Set<Apartment> apartments;
}
