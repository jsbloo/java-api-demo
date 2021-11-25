package com.qa.QAAPIPROJECT.service;

import com.qa.QAAPIPROJECT.dto.AirportDTO;
import com.qa.QAAPIPROJECT.dto.MilitaryPlaneDTO;
import com.qa.QAAPIPROJECT.exceptions.AirportNotFoundException;
import com.qa.QAAPIPROJECT.exceptions.InvalidAirportException;
import com.qa.QAAPIPROJECT.exceptions.PlaneNotFoundException;
import com.qa.QAAPIPROJECT.model.Airport;
import com.qa.QAAPIPROJECT.model.MilitaryPlane;
import com.qa.QAAPIPROJECT.repository.AirportRepository;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AirportService {

    private AirportRepository repo;
    private ModelMapper mapper;

    @Autowired
    public AirportService(AirportRepository repo, ModelMapper mapper){
        this.repo = repo;
        this.mapper = mapper;
    }

    private AirportDTO mapToDto(Airport ap){
        return this.mapper.map(ap, AirportDTO.class);
    }

    public boolean addAirport(List<Airport> airport){
        for (Airport ap:
             airport) {
            try{
                this.repo.save(ap);
            }catch (Exception e){throw new IllegalArgumentException();}
        }
        return true;
    }

    public List<AirportDTO> getAll(){
        return this.repo.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public AirportDTO readByAirportCode(String apc){
        Airport found = repo.findById(apc).orElseThrow(AirportNotFoundException::new);
        return mapToDto(found);
    }

    public Airport update(String apc, Airport ap) {
        if(!Objects.equals(ap.getAirportCode(), apc)) {
            ap.setAirportCode(apc);
        }
        repo.findById(apc).orElseThrow(AirportNotFoundException::new);
        try{return repo.save(ap);}catch(Exception e){throw new InvalidAirportException();}
    }
}

