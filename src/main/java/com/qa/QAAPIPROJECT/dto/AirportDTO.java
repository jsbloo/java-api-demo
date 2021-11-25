package com.qa.QAAPIPROJECT.dto;

import com.qa.QAAPIPROJECT.model.MilitaryPlane;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class AirportDTO {

    private String airportCode;

    private String country;

    private String city;

    private double longitude;

    private double latitude;

    private List<MilitaryPlane> militaryPlanes = new ArrayList<>();

    public AirportDTO(String airportCode, String country, String city,
                      double longitude, double latitude, List<MilitaryPlane> militaryPlanes) {
        this.airportCode = airportCode;
        this.country = country;
        this.city = city;
        this.longitude = longitude;
        this.latitude = latitude;
        this.militaryPlanes = militaryPlanes;
    }

    public AirportDTO(){
        super();
    }

}
