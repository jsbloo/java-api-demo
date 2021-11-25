package com.qa.QAAPIPROJECT.repository;

import com.qa.QAAPIPROJECT.model.Airport;
import com.qa.QAAPIPROJECT.model.MilitaryPlane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AirportRepository extends JpaRepository<Airport, String> {
}