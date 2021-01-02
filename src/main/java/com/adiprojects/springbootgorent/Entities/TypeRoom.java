package com.adiprojects.springbootgorent.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "type_room")
@Getter
@Setter

public class TypeRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_room")
    private Long id;

    @Column(name = "type_name")
    private String typeName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeRoom")
    @JsonIgnore
    private Set<Apartment> apartments;

}
