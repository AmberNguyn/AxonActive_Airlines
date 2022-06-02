package com.example.demo.service.impl;

import com.example.demo.entity.Airplane;
import com.example.demo.repository.AirplaneRepository;
import com.example.demo.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return airplaneRepository.findAirplaneByFlyingDistanceGreaterThan(flyingDistance);
    }

    //7.	Có bao nhiêu loại máy báy Boeing.
    public int findHowManyAirplaneByAirplaneTypeContaining(String typeOfAirplane)
    {
        return airplaneRepository.findAirplaneByAirplaneTypeContaining(typeOfAirplane).size();
    }


}
