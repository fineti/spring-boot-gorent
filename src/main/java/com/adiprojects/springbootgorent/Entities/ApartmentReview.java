package com.adiprojects.springbootgorent.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "review_apartment")
@Getter
@Setter
public class ApartmentReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_review_apartment")
    private long id;

    @Column(name = "description")
    private String description;

    @Column(name = "rating")
    private float rating;

    @ManyToOne
    @JoinColumn(name = "id_apartment")
    @JsonIgnore
    private Apartment apartment;

    @ManyToOne
    @JoinColumn(name = "id_client")
    @JsonIgnore
    private Client author;

}
