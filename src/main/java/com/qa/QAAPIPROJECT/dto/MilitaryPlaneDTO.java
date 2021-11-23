package com.qa.QAAPIPROJECT.dto;

import com.qa.QAAPIPROJECT.model.Plane;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
public class MilitaryPlaneDTO extends Plane  {

    public MilitaryPlaneDTO(String modelName, String nationalOrigin, String introductionDate,
                            int numberBuilt, List<String> primaryUsers, String description,
                            List<String> armament, int attackPower, int maneuverability,
                            double topSpeed) {
        super(modelName, nationalOrigin, introductionDate, numberBuilt, primaryUsers, description);
        this.armament = armament;
        this.attackPower = attackPower;
        this.maneuverability = maneuverability;
        this.topSpeed = topSpeed;
    }

    public MilitaryPlaneDTO(List<String> armament, int attackPower, int maneuverability,
                            double topSpeed) {
        this.armament = armament;
        this.attackPower = attackPower;
        this.maneuverability = maneuverability;
        this.topSpeed = topSpeed;
    }

    private List<String> armament;

    private int attackPower;

    private int maneuverability;

    private double topSpeed;

    public MilitaryPlaneDTO(){
        super();
    }
}
