package com.qa.QAAPIPROJECT;

import com.qa.QAAPIPROJECT.dto.MilitaryPlaneDTO;
import com.qa.QAAPIPROJECT.model.MilitaryPlane;

import java.util.ArrayList;
import java.util.List;

public abstract class TestingConstants {
    public static final List<String> pu = new ArrayList<>();
    public static final List<String> arm = new ArrayList<>();
    public static final MilitaryPlane mp1 = new MilitaryPlane
            ("Corsair","USA","1940, March",
                    4000,pu,"definition",arm,60,
                    30,440.0);
    public static final MilitaryPlane mp1Saved = new MilitaryPlane
            (1L,"Corsair","USA","1940, March",
                    4000,pu,"definition",arm,60,
                    30,440.0);
    public static final MilitaryPlane mp2 = new MilitaryPlane
            ("hi-plane","iraq","1999",
            1,pu, "cool plane",arm,1,
            2,55.1);
    public static final List<MilitaryPlane> mp1List = new ArrayList<>(List.of(mp1));
    public static final MilitaryPlaneDTO mp1SavedDTO = new MilitaryPlaneDTO
            (1L,"Corsair","USA","1940, March",
                    4000,pu,"definition",arm,60,
                    30,440.0);
    public static final List<MilitaryPlaneDTO> mpDtos = new ArrayList<>(List.of(mp1SavedDTO));
    public static final MilitaryPlane mp3 = new MilitaryPlane("tin29","USA","1921",
            20,pu,"another plane",arm,20,20,200.1);
    public static final MilitaryPlane mp4 = new MilitaryPlane("spaceship","India",
            "1959", 100,pu,"description",arm,100,
            100,99999.0);
    public static final List<MilitaryPlane> allMps = new ArrayList<>(List.of(mp2,mp3,mp4));
}
