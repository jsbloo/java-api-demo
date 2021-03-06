package com.qa.QAAPIPROJECT.repository;

import com.qa.QAAPIPROJECT.model.MilitaryPlane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MilitaryPlaneRepository extends JpaRepository<MilitaryPlane, Long> {
    List<MilitaryPlane> findPlaneByModelName(String name);
    List<MilitaryPlane> findPlaneByNationalOrigin(String nation);
}

