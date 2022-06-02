package com.example.demo.repository;

import com.example.demo.entity.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Integer> {
    //Cho biết các loại máy bay có tầm bay lớn hơn 10,000km.
    List<Airplane> findAirplaneByFlyingDistanceGreaterThan(Integer flyingDistance);

    //7.	Có bao nhiêu loại máy báy Boeing.
    List<Airplane> findAirplaneByAirplaneTypeContaining(String typeOfAirplane);
}
