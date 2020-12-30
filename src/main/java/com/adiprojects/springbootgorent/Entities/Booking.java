package com.adiprojects.springbootgorent.Entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "booking")
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_booking")
    private long id;

//    @ManyToOne
//    @JoinColumn(name = "id_client")
//    private Client client;

    @Column(name = "check_in")
    private Date checkIn;

    @Column(name = "check_out")
    private Date checkOut;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_host")
    private Host host;

    @ManyToOne
    @JoinColumn(name = "id_apartment")
    private Apartment apartment;

}
