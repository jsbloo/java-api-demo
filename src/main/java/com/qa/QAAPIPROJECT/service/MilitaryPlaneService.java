package com.qa.QAAPIPROJECT.service;

import com.qa.QAAPIPROJECT.dto.MilitaryPlaneDTO;
import com.qa.QAAPIPROJECT.exceptions.InvalidPlaneException;
import com.qa.QAAPIPROJECT.exceptions.PlaneNotFoundException;
import com.qa.QAAPIPROJECT.model.MilitaryPlane;
import com.qa.QAAPIPROJECT.repository.MilitaryPlaneRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class MilitaryPlaneService {

    private MilitaryPlaneRepository repo;
    private ModelMapper mapper;

    @Autowired
    public MilitaryPlaneService(MilitaryPlaneRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    private MilitaryPlaneDTO mapToDto(MilitaryPlane mp){
        return this.mapper.map(mp, MilitaryPlaneDTO.class);
    }

    public void addPlane(List<MilitaryPlane> plane) {
        for (MilitaryPlane mp:
             plane) {
            try{
            repo.save(mp);}catch (Exception e){throw new InvalidPlaneException();
            }
        }
    }

    public void update(long id, MilitaryPlane plane){
        if(plane.getId()!=id){
            plane.setId(id);
        }
        repo.findById(id).orElseThrow(PlaneNotFoundException::new);
        try{repo.save(plane);}catch (Exception e){throw new InvalidPlaneException();}
    }

    public List<MilitaryPlaneDTO> getAll(){
        return this.repo.findAll()
                .stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public MilitaryPlaneDTO readById(long id){
        MilitaryPlane found = repo.findById(id).orElseThrow(PlaneNotFoundException::new);
        return mapToDto(found);
    }

    public void delete(long id){
        try{repo.deleteById(id);}catch (Exception e){
            throw new PlaneNotFoundException();
        }
    }

    public List<MilitaryPlaneDTO> readByName(String name){
        try{
        return repo.findPlaneByModelName(name)
                .stream().map(this::mapToDto).collect(Collectors.toList());}
        catch (Exception e){
            throw new PlaneNotFoundException();
        }
    }

    public List<MilitaryPlaneDTO> readByNationalOrigin(String nation) {
        try{
        return repo.findPlaneByNationalOrigin(nation)
                .stream().map(this::mapToDto).collect(Collectors.toList());}
        catch (Exception e){
            throw new PlaneNotFoundException();
        }
    }
}
