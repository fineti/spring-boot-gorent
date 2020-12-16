package com.adiprojects.springbootgorent.dao;

import com.adiprojects.springbootgorent.Entities.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface HostRepository extends JpaRepository<Host, Long> {
}
