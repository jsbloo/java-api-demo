package com.qa.QAAPIPROJECT.dto;

import com.qa.QAAPIPROJECT.model.Plane;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
public class MilitaryPlaneDTO extends Plane {
    public MilitaryPlaneDTO(String modelName, String nationalOrigin,
                            String introductionDate, int numberBuilt,
                            List<String> primaryUsers, String description) {
        super(modelName, nationalOrigin, introductionDate, numberBuilt, primaryUsers, description);
    }

    private List<String> armament;

    private int attackPower;

    private int maneuverability;

    private double topSpeed;
}
