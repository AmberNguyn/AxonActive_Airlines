package com.example.demo.api;


import com.example.demo.entity.Flight;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(FlightResource.PATH)
public class FlightResource {
    public static final String PATH = "/api/flight";
    @Autowired
    private FlightService flightService;

    @GetMapping
    public ResponseEntity<List<Flight>> getAll() {
        List<Flight> flightList = flightService.getAll();
        return ResponseEntity.ok(flightList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> findFlightById(@PathVariable(value = "id") String flightId)
            throws ResourceNotFoundException {
        Flight flight = flightService.findFlightById(flightId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Id not found")
                );
        return ResponseEntity.ok(flight);
    }

    @PostMapping
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        Flight flightCreate = flightService.saveFlight(flight);
        return ResponseEntity.created(URI.create(FlightResource.PATH + "/" + flightCreate.getFlightID())).body(flightCreate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable(value = "id") String flightId)
            throws ResourceNotFoundException {
        Flight flight = flightService.findFlightById(flightId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Id not found")
                );
        flightService.deleteFlight(flightId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Flight> updateFlight(@PathVariable(value = "id") String flightId,
                                               @RequestBody Flight flight) throws ResourceNotFoundException
    {
        Flight flightUpdate = flightService.findFlightById(flightId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Flight not found")
                );
        flightUpdate.setArrivalGate(flight.getArrivalGate());
        flightUpdate.setDepartureGate(flight.getDepartureGate());
        flightUpdate.setArrivalTime(flight.getArrivalTime());
        flightUpdate.setDistance(flight.getDistance());
        flightUpdate.setDepartureTime(flight.getDepartureTime());
        flightUpdate.setCost(flight.getCost());

        Flight savedFlight = flightService.saveFlight(flightUpdate);
        return ResponseEntity.ok(savedFlight);
    }
}
