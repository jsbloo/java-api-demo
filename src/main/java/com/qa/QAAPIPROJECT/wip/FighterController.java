//package com.qa.QAAPIPROJECT.controller;
//
//import com.qa.QAAPIPROJECT.entities.Fighter;
//import com.qa.QAAPIPROJECT.model.Plane;
//import com.qa.QAAPIPROJECT.service.FighterService;
//import com.qa.QAAPIPROJECT.service.PlaneService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//public class FighterController extends PlaneController{
//
//    private FighterService service;
//
//    @PostMapping("/createPlanes")
//    public String create(@RequestBody List<Plane> plane){
//        service.addPlane(plane);
//        return "Plane added";
//    }
//
//    @GetMapping("/readAll")
//    public List<Plane> read(){
//        return service.getAll();
//    }
//
//    @GetMapping("readById/{id}")
//    public Optional<Plane> readById(@PathVariable long id){
//        return service.readById(id);
//    }
//
//    @PutMapping("/updatePlane/{id}")
//    public String update(@PathVariable  long id, @RequestBody Fighter fighter){
//        service.update(id,fighter);
//        return "Plane updated";
//    }
//
//    @PutMapping("deletePlane/{id}")
//    public String delete(@PathVariable long id){
//        service.delete(id);
//        return "Plane deleted";
//    }
//
//    @GetMapping("readByName/{name}")
//    public List<Plane> readByName(@PathVariable String name){
//        return service.readByName(name);
//    }
//
//    @GetMapping("readByCountry/{country}")
//    public List<Plane> readByCountryOfOrigin(@PathVariable String country){ return service.readByCountryOfOrigin(country);}
//}
