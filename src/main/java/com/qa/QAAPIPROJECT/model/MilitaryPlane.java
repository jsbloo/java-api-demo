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
    long id;

    @NotNull
    @Column
    private String modelName;

    @NotNull
    @Column
    private String nationalOrigin;

    @NotNull
    @Column
    private String introductionDate;

    @NotNull
    @Column
    private int numberBuilt;

    @NotNull
    @Column
    @ElementCollection
    private List<String> primaryUsers;

    @NotNull
    @Column (columnDefinition = "TEXT")
    private String description;

    @NotNull
    @Column
    @ElementCollection
    private List<String> armament;

    @NotNull
    @Column
    private int attackPower;

    @NotNull
    @Column
    private int maneuverability;

    @NotNull
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