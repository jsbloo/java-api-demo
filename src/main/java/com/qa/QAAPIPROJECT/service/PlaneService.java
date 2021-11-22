package com.qa.QAAPIPROJECT.service;

import com.qa.QAAPIPROJECT.dto.PlaneDTO;
import com.qa.QAAPIPROJECT.model.Plane;
import com.qa.QAAPIPROJECT.repository.PlaneRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaneService {

    private PlaneRepository repo;
    private ModelMapper mapper;

    @Autowired
    public PlaneService(PlaneRepository repo, ModelMapper mapper) {
        super();
        this.repo = repo;
        this.mapper = mapper;
    }

    private PlaneDTO mapToDto(Plane plane){
        return this.mapper.map(plane, PlaneDTO.class);
    }

    public void update(long id, Plane plane){
        if(plane.getId()!=id){
            plane.setId(id);
        }
        if(plane.getNationalOrigin()==null){
            plane.setNationalOrigin(repo.getById(id).getNationalOrigin());
        }
        if(plane.getModelName()==null){
            plane.setModelName(repo.getById(id).getModelName());
        }
        if(plane.getIntroductionDate()==null){
            plane.setIntroductionDate(repo.getById(id).getIntroductionDate());
        }

        repo.save(plane);
    }

    public void addPlane(List<Plane> plane){
        for (Plane p:
             plane) {
            repo.save(p);
        }
    }

    public List<PlaneDTO> getAll(){
        return this.repo.findAll()
                .stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public PlaneDTO readById(long id){
        return mapToDto(repo.findById(id)
                .stream().findFirst().orElse(null));
    }

    public void delete(long id){
        repo.deleteById(id);
    }

    public List<PlaneDTO> readByName(String name){
        return repo.findPlaneByModelName(name)
                .stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public List<PlaneDTO> readByNationalOrigin(String nation) {
        return repo.findPlaneByNationalOrigin(nation)
                .stream().map(this::mapToDto).collect(Collectors.toList());
    }
}
