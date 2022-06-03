package com.example.demo.service.impl;

import com.example.demo.entity.Airplane;
import com.example.demo.repository.AirplaneRepository;
import com.example.demo.service.AirplaneService;
import com.example.demo.service.dto.AirplaneDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirplaneServiceImpl implements AirplaneService {
    @Autowired
    AirplaneRepository airplaneRepository;

    @Override
    public Airplane saveAirplane(Airplane airplane)
    {
        return airplaneRepository.save(airplane);
    }

    //Cho biết các loại máy bay có tầm bay lớn hơn 10,000km.
    @Override
    public List<Airplane> findAirplaneByFlyingDistanceGreaterThan(Integer flyingDistance) {
        return airplaneRepository.findAirplaneByRangeGreaterThan(flyingDistance);
    }

    //7.	Có bao nhiêu loại máy báy Boeing.
    public int findHowManyAirplaneByTypeContaining(String typeOfAirplane)
    {
        return airplaneRepository.findAirplaneByTypeContaining(typeOfAirplane).size();
    }

    //13.	Cho biết các loại máy bay có thể thực hiện chuyến bay VN280.
    public List<String> findAirplaneThatCanSatisfyACertainFlight(@Param("flightID") String flightId)
    {
        return airplaneRepository.findAirplaneThatCanSatisfyACertainFlight(flightId);
    }

    //-- 16. Với mỗi loại máy bay có phi công lái cho biết mã số,
    //-- loại máy báy và tổng số phi công có thể lái loại máy bay đó.

    public List<AirplaneDto> listOfAirplaneIdAndAirplaneTypeAndNumberOfPilotsWhoCanFlyThem()
    {
        return airplaneRepository.listOfAirplaneIdAndAirplaneTypeAndNumberOfPilotsWhoCanFlyThem();
    }


}
