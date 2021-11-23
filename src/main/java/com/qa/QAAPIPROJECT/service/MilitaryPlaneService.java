package com.qa.QAAPIPROJECT.service;

import com.qa.QAAPIPROJECT.dto.MilitaryPlaneDTO;
import com.qa.QAAPIPROJECT.dto.PlaneDTO;
import com.qa.QAAPIPROJECT.model.MilitaryPlane;
import com.qa.QAAPIPROJECT.model.Plane;
import com.qa.QAAPIPROJECT.repository.MilitaryPlaneRepository;
import com.qa.QAAPIPROJECT.repository.PlaneRepository;
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
            repo.save(mp);
        }
    }

    public void update(long id, MilitaryPlane plane){

        MilitaryPlane currentMp = repo.getById(id);

        if(plane.getId()!=id){
            plane.setId(id);
        }
        if(plane.getNationalOrigin()==null){
            plane.setNationalOrigin(currentMp.getNationalOrigin());
        }
        if(plane.getModelName()==null){
            plane.setModelName(currentMp.getModelName());
        }
        if(plane.getIntroductionDate()==null){
            plane.setIntroductionDate(currentMp.getIntroductionDate());
        }
        if(plane.getArmament()==null){
            plane.setArmament(currentMp.getArmament());
        }
        if(plane.getAttackPower()==0){//this causes a bug, should change
            plane.setAttackPower(currentMp.getAttackPower());
        }
        if(plane.getManeuverability()==0){
            plane.setManeuverability(currentMp.getManeuverability());
        }
        if(plane.getTopSpeed()==0){
            plane.setTopSpeed(currentMp.getTopSpeed());
        }

        repo.save(plane);
    }

    public List<MilitaryPlaneDTO> getAll(){
        return this.repo.findAll()
                .stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public MilitaryPlaneDTO readById(long id){
        return mapToDto(repo.findById(id)
                .stream().findFirst().orElse(null));
    }

    public void delete(long id){
        repo.deleteById(id);
    }

    public List<MilitaryPlaneDTO> readByName(String name){
        return repo.findPlaneByModelName(name)
                .stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public List<MilitaryPlaneDTO> readByNationalOrigin(String nation) {
        return repo.findPlaneByNationalOrigin(nation)
                .stream().map(this::mapToDto).collect(Collectors.toList());
    }
}
