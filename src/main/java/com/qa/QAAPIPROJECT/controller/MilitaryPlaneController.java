package com.qa.QAAPIPROJECT.controller;

import com.qa.QAAPIPROJECT.dto.MilitaryPlaneDTO;
import com.qa.QAAPIPROJECT.dto.PlaneDTO;
import com.qa.QAAPIPROJECT.model.MilitaryPlane;
import com.qa.QAAPIPROJECT.model.Plane;
import com.qa.QAAPIPROJECT.service.MilitaryPlaneService;
import com.qa.QAAPIPROJECT.service.PlaneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MilitaryPlaneController{

    private MilitaryPlaneService service;

    public MilitaryPlaneController(MilitaryPlaneService service1) {
        this.service = service1;
    }

    @PostMapping("/createMp")
    public String create(@RequestBody List<MilitaryPlane> plane) {
        service.addPlane(plane);
        return "mp added";
    }

    @GetMapping("/readAllMp")
    public List<MilitaryPlaneDTO> read() {
        return service.getAll();
    }

    @GetMapping("readByIdMp/{id}")
    public MilitaryPlaneDTO readById(@PathVariable long id) {
        return service.readById(id);
    }

    @PutMapping("/updateMp/{id}")
    public String update(@PathVariable long id, @RequestBody MilitaryPlane plane) {
        service.update(id, plane);
        return "MP updated" + id;
    }

    @PutMapping("deleteMp/{id}")
    public String delete(@PathVariable long id) {
        service.delete(id);
        return "deleted "+ id;
    }

    @GetMapping("readByNameMp/{name}")
    public List<MilitaryPlaneDTO> readByName(@PathVariable String name) {
        return service.readByName(name);
    }

    @GetMapping("readByNationalOriginMp/{nation}")
    public List<MilitaryPlaneDTO> readByByNationalOrigin(@PathVariable String nation) {
        return service.readByNationalOrigin(nation);
    }
}
