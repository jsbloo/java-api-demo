package com.qa.QAAPIPROJECT.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@Entity
public class MilitaryPlane extends Plane{

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
                         List<String> armament, int attackPower, int maneuverability,
                         double topSpeed) {
        super(modelName, nationalOrigin, introductionDate, numberBuilt, primaryUsers, description);
        this.armament = armament;
        this.attackPower = attackPower;
        this.maneuverability = maneuverability;
        this.topSpeed = topSpeed;
    }

}
