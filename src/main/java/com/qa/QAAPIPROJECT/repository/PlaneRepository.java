package com.qa.QAAPIPROJECT.repository;

import com.qa.QAAPIPROJECT.model.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface PlaneRepository extends JpaRepository<Plane, Long> {
     List<Plane> findPlaneByModelName(String name);
     List<Plane> findPlaneByNationalOrigin(String nation);
}
