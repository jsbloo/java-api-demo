package com.qa.QAAPIPROJECT.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public abstract class PlaneDTO {

    private long id;

    private String modelName;

    private String nationalOrigin;

    private String introductionDate;

    private int numberBuilt;

    private List<String> primaryUsers;

    private String description;

    public PlaneDTO(){
        super();
    }

}
