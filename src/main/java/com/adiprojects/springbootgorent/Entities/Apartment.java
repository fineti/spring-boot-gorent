package com.adiprojects.springbootgorent.Entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "apartment")
@Data
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_apartment")
    private long id;

    @ManyToOne
    @JoinColumn(name = "type_room", nullable = false)
    private TypeRoom typeRoom;

    @ManyToMany
    @JoinTable(
            name = "apartment_amenity",
            joinColumns = @JoinColumn(name = "id_apartment"),
            inverseJoinColumns = @JoinColumn(name = "id_amenity"))
    private Set<Amenity> amenities;

    @ManyToMany
    @JoinTable(
            name = "apartment_facility",
            joinColumns = @JoinColumn(name = "id_apartment"),
            inverseJoinColumns = @JoinColumn(name = "id_facility"))
    private Set<Facility> facilities;

    @ManyToOne
    @JoinColumn(name = "host")
    private Host host;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private Set<Booking> booking;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "nr_person")
    private int nrPerson;

    @Column(name = "pet_friendly")
    private boolean petFriendly;

    @Column(name = "available")
    private boolean available;

    @Column(name = "smoking_allowed")
    private boolean smokingAllowed;

    @Column(name = "price")
    private float price;

    @Column(name = "size")
    private int size;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;

    @UpdateTimestamp
    @Column(name = "last_updated")
    private Date lastUpdated;
}
