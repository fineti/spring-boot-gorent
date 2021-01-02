package com.adiprojects.springbootgorent.controllers;

import com.adiprojects.springbootgorent.Entities.Amenity;
import com.adiprojects.springbootgorent.Entities.Apartment;
import com.adiprojects.springbootgorent.Entities.Booking;
import com.adiprojects.springbootgorent.dao.AmenityRepository;
import com.adiprojects.springbootgorent.dao.ApartmentRepository;
import com.adiprojects.springbootgorent.dao.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.nimbus.State;
import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "api/apartments/")
public class ApartmentController {

    @Autowired
    public ApartmentRepository apartmentRepository;

    @Autowired
    public AmenityRepository amenityRepository;
    @Autowired
    public FacilityRepository facilityRepository;

    @GetMapping("/")
    public List<Apartment> getAllApartments() {
        return apartmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Apartment getBookingById(@PathVariable("id") long id) {
        return apartmentRepository.findApartmentById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Apartment> createApartment(@RequestBody Apartment apartment) {
        try {
            Apartment _apartment = apartmentRepository
                    .save(apartment);
            return new ResponseEntity<>(_apartment, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Apartment> updateApartment(@PathVariable("id") long id, @RequestBody Apartment apartment) {
        Optional<Apartment> apartmentData = apartmentRepository.findById(id);

        if (apartmentData.isPresent()) {
            Apartment _apartment = apartmentData.get();
            _apartment.setAddress(apartment.getAddress());
            _apartment.setAmenities(apartment.getAmenities());
            _apartment.setCity(apartment.getCity());
            _apartment.setCountry(apartment.getCountry());
            _apartment.setDescription(apartment.getDescription());
            _apartment.setNrPerson(apartment.getNrPerson());
            _apartment.setLastUpdated(new Date());
            _apartment.setPrice(apartment.getPrice());
            _apartment.setPetFriendly(apartment.isPetFriendly());
            _apartment.setSmokingAllowed(apartment.isSmokingAllowed());
            return new ResponseEntity<>(apartmentRepository.save(_apartment), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Apartment> deleteApartment(@PathVariable("id") long id) {
        try {
            apartmentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @GetMapping("/search")
    public List<Apartment> getFilteredApartments(@RequestParam(value = "country", required = false) String country, @RequestParam(value = "city", required = false) String city,
                                                 @RequestParam(value = "facility", required = false) List<String> facility, @RequestParam(value = "amenity", required = false) List<String> amenity,
                                                 @RequestParam(value = "address", required = false) String address, @RequestParam(value = "smokingAllowed", required = false) Boolean smokingAllowed,
                                                 @RequestParam(value = "petFriendly", required = false) Boolean petFriendly, @RequestParam(value = "nrPerson", required = false) Integer nrPerson,
                                                 @RequestParam(value = "price", required = false) Float price, @RequestParam(value = "typeRoom", required = false) String typeRoom ) {
        final List<Apartment> countryFilteredList = country != null ? apartmentRepository.findByCountryContaining(country) : null;
        final List<Apartment> cityFilteredList = city != null ? apartmentRepository.findByCityContaining(city) : null;
        final List<Apartment> facilityFilteredList = facility != null ? apartmentRepository.findDistinctByFacilitiesNameIn(facility) : null;
        final List<Apartment> amenityFilteredList = amenity != null ? apartmentRepository.findDistinctByAmenitiesNameIn(amenity) : null;
        final List<Apartment> addressFilteredList = address != null ? apartmentRepository.findByAddressContaining(address) : null;
        final List<Apartment> smokingAllowedFilteredList = smokingAllowed != null ? apartmentRepository.findBySmokingAllowed(smokingAllowed) : null;
        final List<Apartment> petFriendlyFilteredList = smokingAllowed != null ? apartmentRepository.findByPetFriendly(petFriendly) : null;
        final List<Apartment> nrPersonFilteredList = nrPerson != null ? apartmentRepository.findByNrPersonGreaterThanEqual(nrPerson): null;
        final List<Apartment> priceFilteredList = smokingAllowed != null ? apartmentRepository.findByPriceLessThanEqual(price) : null;
        final List<Apartment> typeRoomFilteredList = smokingAllowed != null ? apartmentRepository.findByTypeRoomTypeName(typeRoom): null;


        return apartmentRepository.findAll().stream()
                .filter(
                    apartment -> {
                        if(countryFilteredList != null)
                            return countryFilteredList.contains(apartment);
                        else return true;
                    })
                .filter(
                    apartment -> {
                        if (cityFilteredList != null)
                            return cityFilteredList.contains(apartment);
                        else return true;
                    })
                .filter(
                        apartment -> {
                            if(facilityFilteredList == null) return true;
                            List<String> apartmentFacilities = facilityRepository.findByApartments(apartment).stream().map(facility2 -> facility2.getName()).collect(Collectors.toList());
                            for (String sFacility : facility) {
                                if(!apartmentFacilities.contains(sFacility))
                                    return false;
                            }
                            return true;
                        })
                .filter(
                        apartment -> {
                            if(amenityFilteredList == null) return true;
                            List<String> apartmentAmenities = amenityRepository.findByApartments(apartment).stream().map(amenity2 -> amenity2.getName()).collect(Collectors.toList());
                            for (String sAmenity : amenity) {
                                if(!apartmentAmenities.contains(sAmenity))
                                    return false;
                            }
                            return true;
                        })
                .filter(
                        apartment -> {
                            if (addressFilteredList != null)
                                return addressFilteredList.contains(apartment);
                            else return true;
                        })
                .filter(
                        apartment -> {
                            if (smokingAllowedFilteredList != null)
                                return smokingAllowedFilteredList.contains(apartment);
                            else return true;
                        })
                .filter(
                        apartment -> {
                            if (petFriendlyFilteredList != null)
                                return petFriendlyFilteredList.contains(apartment);
                            else return true;
                        })
                .filter(
                        apartment -> {
                            if (nrPersonFilteredList != null)
                                return nrPersonFilteredList.contains(apartment);
                            else return true;
                        })
                .filter(
                        apartment -> {
                            if (priceFilteredList != null)
                                return priceFilteredList.contains(apartment);
                            else return true;
                        })
                .filter(
                        apartment -> {
                            if (typeRoomFilteredList != null)
                                return typeRoomFilteredList.contains(apartment);
                            else return true;
                        })
                .collect(Collectors.toList());

    }

//    @GetMapping("search/{facilities}")
//    public List<Apartment> search(@RequestParam(value = "facilities", required = false) List<String> facilities) {
//        if (facilities != null) {
//            return this.apartmentRepository.findDistinctByFacilitiesNameIn(facilities);
//        } else {
//            return this.apartmentRepository.findAll();
//        }
//    }

//    @GetMapping("search/{country}")
//    public List<Apartment> search(@RequestParam(value = "country", required = false) String country) {
//        if (country != null) {
//            return this.apartmentRepository.findApartmentsByCountry(country);
//        } else {
//            return this.apartmentRepository.findAll();
//        }
//    }
}
