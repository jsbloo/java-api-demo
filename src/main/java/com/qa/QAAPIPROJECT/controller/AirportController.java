package com.qa.QAAPIPROJECT.controller;

import com.qa.QAAPIPROJECT.dto.AirportDTO;
import com.qa.QAAPIPROJECT.dto.MilitaryPlaneDTO;
import com.qa.QAAPIPROJECT.model.Airport;
import com.qa.QAAPIPROJECT.service.AirportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AirportController {

    private AirportService service;

    public AirportController(AirportService service1){this.service = service1;}

    @PostMapping("/createAirport")
    public ResponseEntity<String> create(@RequestBody List<Airport> airport){
        service.addAirport(airport);
        return new ResponseEntity<>("New Airport created!", HttpStatus.CREATED);
    }

    @GetMapping("/readAllAirport")
    public ResponseEntity<List<AirportDTO>> read() {
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }

    @GetMapping("/readByAirportCode/{apc}")
    public ResponseEntity<AirportDTO> readyByAirportCode(@PathVariable String apc){
        return new ResponseEntity<>(service.readByAirportCode(apc), HttpStatus.FOUND);
    }

    @PutMapping("/updateAirport/{apc}")
    public ResponseEntity<String> update(@PathVariable String apc, @RequestBody Airport ap){
        service.update(apc,ap);
        return new ResponseEntity<>("Airport " + apc + " Updated", HttpStatus.OK);
    }
}
