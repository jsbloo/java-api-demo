package com.qa.QAAPIPROJECT.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
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
}
