package com.adiprojects.springbootgorent.controllers;

import com.adiprojects.springbootgorent.Entities.ApartmentReview;
import com.adiprojects.springbootgorent.Entities.ApartmentReviewDTO;
import com.adiprojects.springbootgorent.Entities.Booking;
import com.adiprojects.springbootgorent.Entities.BookingDTO;
import com.adiprojects.springbootgorent.dao.ApartmentRepository;
import com.adiprojects.springbootgorent.dao.ApartmentReviewRepository;
import com.adiprojects.springbootgorent.dao.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "api/apartmentReviews/")
public class ApartmentReviewController {
    @Autowired
    private ApartmentReviewRepository apartmentReviewRepository;

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ApartmentRepository apartmentRepository;

    @PostMapping("/save")
    public ApartmentReview save(@RequestBody ApartmentReviewDTO apartmentReviewDTO) {
        ApartmentReview ar = new ApartmentReview();
        ar.setRating(apartmentReviewDTO.rating);
        ar.setDescription(apartmentReviewDTO.description);
        ar.setAuthor(this.clientRepository.findClientById(apartmentReviewDTO.clientId));
        ar.setApartment(this.apartmentRepository.findApartmentById(apartmentReviewDTO.apartmentId));
        try {
            ApartmentReview response = this.apartmentReviewRepository.save(ar);
            return response;
        }
        catch(Exception e) {
            System.out.println("Ceva nu merge");
        }
        return null;
    }
}
