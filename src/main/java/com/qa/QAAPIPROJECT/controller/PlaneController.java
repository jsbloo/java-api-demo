package com.qa.QAAPIPROJECT.controller;

import com.qa.QAAPIPROJECT.dto.PlaneDTO;
import com.qa.QAAPIPROJECT.service.PlaneService;
import com.qa.QAAPIPROJECT.model.Plane;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PlaneController {

    private PlaneService service;

    public PlaneController(PlaneService service) {
        this.service = service;
    }

    @PostMapping("/createPlanes")
    public String create(@RequestBody List<Plane> plane){
        service.addPlane(plane);
        return "Plane added";
    }

    @GetMapping("/readAll")
    public List<PlaneDTO> read(){
        return service.getAll();
    }

    @GetMapping("readById/{id}")
    public PlaneDTO readById(@PathVariable long id){
        return service.readById(id);
    }

    @PutMapping("/updatePlane/{id}")
    public String update(@PathVariable  long id, @RequestBody Plane plane){
        service.update(id,plane);
        return "Plane updated";
    }

    @PutMapping("deletePlane/{id}")
    public String delete(@PathVariable long id){
        service.delete(id);
        return "Plane deleted";
    }

    @GetMapping("readByName/{name}")
    public List<PlaneDTO> readByName(@PathVariable String name){
        return service.readByName(name);
    }

    @GetMapping("readByNationalOrigin/{nation}")
    public List<PlaneDTO> readByByNationalOrigin(@PathVariable String nation){
        return service.readByNationalOrigin(nation);}
}
