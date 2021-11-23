package com.qa.QAAPIPROJECT.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@ToString
@EqualsAndHashCode
@Getter
@Setter
public abstract class Plane {
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

    @Column
    @ElementCollection
    private List<String> primaryUsers;

    @Column (columnDefinition = "TEXT")
    private String description;


    public Plane(String modelName, String nationalOrigin, String introductionDate,
                 int numberBuilt, List<String> primaryUsers, String description) {
        this.modelName = modelName;
        this.nationalOrigin = nationalOrigin;
        this.introductionDate = introductionDate;
        this.numberBuilt = numberBuilt;
        this.primaryUsers = primaryUsers;
        this.description = description;
    }

    public Plane(){}
}

