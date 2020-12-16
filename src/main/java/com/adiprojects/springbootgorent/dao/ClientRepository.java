package com.adiprojects.springbootgorent.dao;

import com.adiprojects.springbootgorent.Entities.Apartment;
import com.adiprojects.springbootgorent.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface ClientRepository extends JpaRepository<Client, Long> {

}
