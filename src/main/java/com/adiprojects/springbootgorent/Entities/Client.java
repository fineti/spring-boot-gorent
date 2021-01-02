package com.adiprojects.springbootgorent.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "client")
@Getter
@Setter
public class Client extends User {

    @Column(name = "enable_notifications")
    private boolean enableNotifications;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    @JsonIgnore
    private Set<Booking> booking;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    @JsonIgnore
    private Set<ApartmentReview> apartmentReviews;
}
