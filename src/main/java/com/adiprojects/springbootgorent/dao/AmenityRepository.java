package com.adiprojects.springbootgorent.dao;

import com.adiprojects.springbootgorent.Entities.Amenity;
import com.adiprojects.springbootgorent.Entities.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("http://localhost:4200")
public interface AmenityRepository extends JpaRepository<Amenity, Long> {
    List<Amenity> findByApartments(Apartment apartment);
}
