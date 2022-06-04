package com.example.demo.service;

import com.example.demo.entity.Certificate;
import com.example.demo.entity.Employee;
import com.example.demo.service.dto.PilotsAndNumberOfAirplanesTheyCanFlyDto;
import com.example.demo.service.dto.PilotsWhoCanFlyMoreThan3TypesOfPlanesAndItsMaxRangeDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CertificateService {
    Certificate saveCertificate(Certificate certificate);



    //9.	Cho biết mã số của các phi công lái máy báy Boeing.
    public List<Certificate> findAllThePilotsWhoCanFlyATypeOfAirplane(String airplaneType);

    // 10.	Cho biết các nhân viên có thể lái máy bay có mã số 747.
    public List<Employee> findEmployeeByAirplaneAirplaneId(Integer airplaneId);

    //11.	Cho biết mã số của các loại máy bay mà nhân viên có họ Nguyễn có thể lái.
    public List<Certificate> findAirplaneByEmployeeNameContaining(String name);

    //12.	Cho biết mã số của các phi công vừa lái được Boeing vừa lái được Airbus.
    public List<Integer> findAllThePilotsWhoCanFlyTwoTypesOfAirplanes(String firstType, String secondType);

    //15.
    public List<Certificate> findPilotsByAirplaneTypeContaining(String airplaneType);


    // -- 22. Cho biết mã số của các phi công chỉ lái được 3 loại máy bay

    public List<String> findListOfPilotsWhoCanOnlyFly3TypesOfPlanes();

    // -- 23. Với mỗi phi công có thể lái nhiều hơn 3 loại máy bay,
    //-- cho biết mã số phi công và tầm bay lớn nhất của các loại máy bay
    //-- mà phi công đó có thể lái.

    public List<PilotsWhoCanFlyMoreThan3TypesOfPlanesAndItsMaxRangeDto> findPilotsCanFly3TypesOfPlanesAndItsMaxRange();


    //-- 24. Với mỗi phi công cho biết mã số phi công
    //-- và tổng số loại máy bay mà phi công đó có thể lái.


}
