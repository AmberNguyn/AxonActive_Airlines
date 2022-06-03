package com.example.demo.service;

import com.example.demo.entity.Airplane;
import com.example.demo.service.dto.AirplaneDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AirplaneService {

    Airplane saveAirplane(Airplane airplane);




    //Cho biết các loại máy bay có tầm bay lớn hơn 10,000km.
    public List<Airplane> findAirplaneByFlyingDistanceGreaterThan(Integer flyingDistance);

    //7.	Có bao nhiêu loại máy báy Boeing.
    public int findHowManyAirplaneByTypeContaining(String typeOfAirplane);

    //13.	Cho biết các loại máy bay có thể thực hiện chuyến bay VN280.
    List<String> findAirplaneThatCanSatisfyACertainFlight(@Param("flightID") String flightId);

    //-- 16. Với mỗi loại máy bay có phi công lái cho biết mã số,
    //-- loại máy báy và tổng số phi công có thể lái loại máy bay đó.

    public List<AirplaneDto> listOfAirplaneIdAndAirplaneTypeAndNumberOfPilotsWhoCanFlyThem();
}
