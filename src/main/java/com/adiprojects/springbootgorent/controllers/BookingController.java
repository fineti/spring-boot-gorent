package com.adiprojects.springbootgorent.controllers;

import com.adiprojects.springbootgorent.Entities.Booking;
import com.adiprojects.springbootgorent.Entities.BookingDTO;
import com.adiprojects.springbootgorent.Entities.Host;
import com.adiprojects.springbootgorent.dao.ApartmentRepository;
import com.adiprojects.springbootgorent.dao.BookingRepository;
import com.adiprojects.springbootgorent.dao.ClientRepository;
import com.adiprojects.springbootgorent.dao.HostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "api/bookings")
public class BookingController {

    @Autowired
    public BookingRepository bookingRepository;

    @Autowired
    public HostRepository hostRepository;

    @Autowired
    public ClientRepository clientRepository;

    @Autowired
    public ApartmentRepository apartmentRepository;

    @GetMapping("/")
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable("id") long id) {
        return bookingRepository.findBookingById(id);
    }

    @PostMapping("/save")
    public Booking save(@RequestBody BookingDTO bookingDTO) {
        Booking b = new Booking();
        b.setCheckIn(bookingDTO.checkIn);
        b.setCheckOut(bookingDTO.checkOut);
        b.setHost(this.hostRepository.findHostById(bookingDTO.hostId));
        b.setClient(this.clientRepository.findClientById(bookingDTO.clientId));
        b.setApartment(this.apartmentRepository.findApartmentById(bookingDTO.apartmentId));
        try {
            Booking response = this.bookingRepository.save(b);
            return response;
        }
        catch(Exception e) {
            System.out.println("Ceva nu merge");
        }
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable("id") long id, @RequestBody Booking booking) {
        Optional<Booking> bookingData = bookingRepository.findById(id);

        if (bookingData.isPresent()) {
            Booking _booking = bookingData.get();
            _booking.setApartment(booking.getApartment());
            _booking.setCheckIn(booking.getCheckIn());
            _booking.setCheckOut(booking.getCheckOut());
            _booking.setClient(booking.getClient());
            _booking.setHost(booking.getHost());

            return new ResponseEntity<>(bookingRepository.save(_booking), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Booking> deleteBooking(@PathVariable("id") long id) {
        try {
            bookingRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
