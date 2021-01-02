package com.adiprojects.springbootgorent.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "amenity")
@Getter
@Setter
public class Amenity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_amenity")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "icon_type")
    private String iconType;

    @ManyToMany(mappedBy = "amenities")
    @JsonIgnore
    private Set<Apartment> apartments;
}
