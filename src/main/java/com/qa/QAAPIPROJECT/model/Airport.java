package com.qa.QAAPIPROJECT.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Airport {

    @Id
    private String airportCode;

    @Column
    private String country;

    @Column
    private String city;

    @Column
    private double longitude;

    @Column
    private double latitude;

    @OneToMany(mappedBy = "airport")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<MilitaryPlane> militaryPlanes = new ArrayList<>();

    public Airport(String airportCode, String country, String city,
                   double longitude, double latitude, List<MilitaryPlane> militaryPlanes) {
        this.airportCode = airportCode;
        this.country = country;
        this.city = city;
        this.longitude = longitude;
        this.latitude = latitude;
        this.militaryPlanes = militaryPlanes;
    }

    public Airport(){

    }
}
