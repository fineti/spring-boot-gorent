package com.adiprojects.springbootgorent.dao;

import com.adiprojects.springbootgorent.Entities.Apartment;
import com.adiprojects.springbootgorent.Entities.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("http://localhost:4200")
public interface FacilityRepository extends JpaRepository<Facility, Long> {
    List<Facility> findByApartments(Apartment apartment);
}
