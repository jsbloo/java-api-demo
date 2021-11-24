package com.qa.QAAPIPROJECT.controller;

import com.qa.QAAPIPROJECT.dto.MilitaryPlaneDTO;
import com.qa.QAAPIPROJECT.model.MilitaryPlane;
import com.qa.QAAPIPROJECT.service.MilitaryPlaneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MilitaryPlaneController{

    private MilitaryPlaneService service;

    public MilitaryPlaneController(MilitaryPlaneService service1) {
        this.service = service1;
    }

    @PostMapping("/createMp")
    public ResponseEntity<String> create(@RequestBody List<MilitaryPlane> plane) {
        service.addPlane(plane);
        return new ResponseEntity<>("New MilitaryPlane created!",HttpStatus.CREATED);
    }

    @GetMapping("/readAllMp")
    public ResponseEntity<List<MilitaryPlaneDTO>> read() {
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }

    @GetMapping("readByIdMp/{id}")
    public ResponseEntity<MilitaryPlaneDTO> readById(@PathVariable long id) {
        return new ResponseEntity<>(service.readById(id),HttpStatus.FOUND);
    }

    @PutMapping("/updateMp/{id}")
    public ResponseEntity<String> update(@PathVariable long id, @RequestBody MilitaryPlane plane) {
        service.update(id, plane);
        return new ResponseEntity<>("MP updated" + id, HttpStatus.OK);
    }

    @PutMapping("deleteMp/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        service.delete(id);
        return new ResponseEntity<>("deleted "+ id,HttpStatus.FOUND);
    }

    @GetMapping("readByNameMp/{name}")
    public ResponseEntity<List<MilitaryPlaneDTO>> readByName(@PathVariable String name) {
        return new ResponseEntity<>(service.readByName(name), HttpStatus.OK);
    }

    @GetMapping("readByNationalOriginMp/{nation}")
    public ResponseEntity<List<MilitaryPlaneDTO>> readByByNationalOrigin(@PathVariable String nation) {
        return new ResponseEntity<>(service.readByNationalOrigin(nation), HttpStatus.FOUND);
    }
}
