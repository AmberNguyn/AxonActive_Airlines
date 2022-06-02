package com.example.demo.service;

import com.example.demo.entity.Airplane;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AirplaneService {

    Airplane saveAirplane(Airplane airplane);




    //Cho biết các loại máy bay có tầm bay lớn hơn 10,000km.
    public List<Airplane> findAirplaneByFlyingDistanceGreaterThan(Integer flyingDistance);

    //7.	Có bao nhiêu loại máy báy Boeing.
    public int findHowManyAirplaneByAirplaneTypeContaining(String typeOfAirplane);

    //13.	Cho biết các loại máy bay có thể thực hiện chuyến bay VN280.
    List<String> findAirplaneThatCanSatisfyACertainFlight(@Param("flightID") String flightId);
}
