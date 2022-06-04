package com.example.demo.service.impl;

import com.example.demo.entity.Certificate;
import com.example.demo.entity.Employee;
import com.example.demo.repository.CertificateRepository;
import com.example.demo.service.CertificateService;
import com.example.demo.service.dto.PilotsAndNumberOfAirplanesTheyCanFlyDto;
import com.example.demo.service.dto.PilotsWhoCanFlyMoreThan3TypesOfPlanesAndItsMaxRangeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CertificateServiceImpl implements CertificateService {
    @Autowired
    CertificateRepository certificateRepository;

    @Override
    public Certificate saveCertificate(Certificate certificate) {
        return certificateRepository.save(certificate);
    }


    @Override
    public List<Certificate> findAllThePilotsWhoCanFlyATypeOfAirplane(String airplaneType) {
        return certificateRepository.findAllThePilotsWhoCanFlyATypeOfAirplane(airplaneType);
    }

    // 10.	Cho biết các nhân viên có thể lái máy bay có mã số 747.
    @Override
    public List<Employee> findEmployeeByAirplaneAirplaneId(Integer airplaneId) {
        List<Employee> listOfEmployeesWhoCanFlyAnAirplane = new ArrayList<>();
        for (Certificate certificate : certificateRepository.findEmployeeByAirplaneId(airplaneId)
        ) {
            listOfEmployeesWhoCanFlyAnAirplane.add(certificate.getEmployee());
        }
        return listOfEmployeesWhoCanFlyAnAirplane;
    }

    //11.	Cho biết mã số của các loại máy bay mà nhân viên có họ Nguyễn có thể lái.
    @Override
    public List<Certificate> findAirplaneByEmployeeNameContaining(String name) {
        return certificateRepository.findAirplaneByEmployeeNameContaining(name);
    }

    //12.	Cho biết mã số của các phi công vừa lái được Boeing vừa lái được Airbus.
    @Override
    public List<Integer> findAllThePilotsWhoCanFlyTwoTypesOfAirplanes(String firstType, String secondType) {
        return certificateRepository.findAllThePilotsWhoCanFlyTwoTypesOfAirplanes(firstType, secondType);
    }

    //15.
    @Override
    public List<Certificate> findPilotsByAirplaneTypeContaining(String airplaneType) {
        return certificateRepository.findPilotsByAirplaneTypeContaining(airplaneType);
    }


    // -- 22. Cho biết mã số của các phi công chỉ lái được 3 loại máy bay
    @Override
    public List<String> findListOfPilotsWhoCanOnlyFly3TypesOfPlanes() {
        return certificateRepository.findListOfPilotsWhoCanOnlyFly3TypesOfPlanes();
    }

    // -- 23. Với mỗi phi công có thể lái nhiều hơn 3 loại máy bay,
    //-- cho biết mã số phi công và tầm bay lớn nhất của các loại máy bay
    //-- mà phi công đó có thể lái.
//    @Override
//    public List<PilotsWhoCanFlyMoreThan3TypesOfPlanesAndItsMaxRangeDto> findListOfPilotsWhoCanFlyMoreThan3TypesOfPlanesAndTheirMaximumRange()
//    {
//        return certificateRepository.findListOfPilotsWhoCanFlyMoreThan3TypesOfPlanesAndTheirMaximumRange();
//    }

    @Override
    public List<PilotsWhoCanFlyMoreThan3TypesOfPlanesAndItsMaxRangeDto> findPilotsCanFly3TypesOfPlanesAndItsMaxRange() {
        return certificateRepository.findPilotsCanFly3TypesOfPlanesAndItsMaxRange();
    }


    //-- 24. Với mỗi phi công cho biết mã số phi công
    //-- và tổng số loại máy bay mà phi công đó có thể lái.

    public List<PilotsAndNumberOfAirplanesTheyCanFlyDto> findPilotsAndNumberOfAirplanesTheyCanFly() {
        return certificateRepository.findPilotsAndNumberOfAirplanesTheyCanFly();
    }


}
