package com.qa.QAAPIPROJECT.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@Entity
public class MilitaryPlane{

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @Column
    private String modelName;

    @NotNull
    @Column
    private String nationalOrigin;

    @NotNull
    @Column
    private String introductionDate;

    @Column
    private int numberBuilt;

    @NotNull
    @Column
    @ElementCollection
    private List<String> primaryUsers;

    @Column (columnDefinition = "TEXT")
    private String description;

    @Column
    @ElementCollection
    private List<String> armament;

    @Column
    private int attackPower;

    @Column
    private int maneuverability;

    @Column
    private double topSpeed;

    public MilitaryPlane(String modelName, String nationalOrigin, String introductionDate,
                         int numberBuilt, List<String> primaryUsers, String description,
                         List<String> armament, int attackPower, int maneuverability, double topSpeed) {
        this.modelName = modelName;
        this.nationalOrigin = nationalOrigin;
        this.introductionDate = introductionDate;
        this.numberBuilt = numberBuilt;
        this.primaryUsers = primaryUsers;
        this.description = description;
        this.armament = armament;
        this.attackPower = attackPower;
        this.maneuverability = maneuverability;
        this.topSpeed = topSpeed;
    }

    public MilitaryPlane(){

    }
}