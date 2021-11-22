//package com.qa.QAAPIPROJECT.entities;
//
//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import java.util.List;
//
//@Setter
//@Getter
//@Entity
//@ToString
//public class Fighter extends Plane{
//
//    @Id
//    @GeneratedValue
//    private long id;
//
//    @NotNull
//    @Column
//    private String armament;
//
//    @NotNull
//    @Column
//    private String payload;
//
//    @NotNull
//    @Column
//    private String primaryUsers;
//
//    @NotNull
//    @Column
//    private String introduction;
//
//    public Fighter(String modelName, String countryOfOrigin, String dateOfFirstProduction, long id, String armament, String payload, String primaryUsers, String introduction) {
//        super(modelName, countryOfOrigin, dateOfFirstProduction);
//        this.id = id;
//        this.armament = armament;
//        this.payload = payload;
//        this.primaryUsers = primaryUsers;
//        this.introduction = introduction;
//    }
//
//    public Fighter(long id, String armament, String payload, String primaryUsers, String introduction) {
//        this.id = id;
//        this.armament = armament;
//        this.payload = payload;
//        this.primaryUsers = primaryUsers;
//        this.introduction = introduction;
//    }
//
//    public Fighter(String modelName, String countryOfOrigin, String dateOfFirstProduction) {
//        super(modelName, countryOfOrigin, dateOfFirstProduction);
//    }
//
//    public Fighter() {}
//}
