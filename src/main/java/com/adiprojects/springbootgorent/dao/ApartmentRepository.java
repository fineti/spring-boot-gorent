package com.adiprojects.springbootgorent.dao;

import com.adiprojects.springbootgorent.Entities.Apartment;
import com.adiprojects.springbootgorent.Entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Set;

@CrossOrigin("http://localhost:4200")
public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
    Apartment findApartmentById(Long id);

    //List<Apartment> findDistinctByFacilitiesIdIn(List<Long> facilities);
    List<Apartment> findByCountryContaining(String country);
    List<Apartment> findByCityContaining(String country);
    List<Apartment> findDistinctByFacilitiesNameIn(List<String> facilities);
    List<Apartment> findDistinctByAmenitiesNameIn(List<String> amenities);
    List<Apartment> findByAddressContaining(String address);
    List<Apartment> findBySmokingAllowed(Boolean smokingAllowed);
    List<Apartment> findByPetFriendly(Boolean petFriendly);
    List<Apartment> findByNrPersonGreaterThanEqual(Integer nrPerson);
    List<Apartment> findByPriceLessThanEqual(Float price);
    List<Apartment> findByTypeRoomTypeName(String typeRoom);
}
