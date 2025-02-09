package com.adiprojects.springbootgorent.dao;

import com.adiprojects.springbootgorent.Entities.TypeRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface TypeRoomRepository extends JpaRepository<TypeRoom, Long> {
}
