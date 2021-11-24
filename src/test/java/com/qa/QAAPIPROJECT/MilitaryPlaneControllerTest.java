package com.qa.QAAPIPROJECT;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.QAAPIPROJECT.model.MilitaryPlane;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles(profiles = "test")
public class MilitaryPlaneControllerTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    private ObjectMapper jsonifier;

    @Test
    public void TestCreate() throws Exception{
        List<String> pu = new ArrayList<>();
        List<String> arm = new ArrayList<>();
        MilitaryPlane mp1 = new MilitaryPlane
                ("Corsair","USA","1940, March",
                        4000,pu,"definition",arm,60,
                        30,440.0);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
                .request(HttpMethod.POST,"/createMp");//empty RequestEntity
        mockRequest.contentType(MediaType.APPLICATION_JSON);//type JSON
        mockRequest.content(this.jsonifier.writeValueAsString(mp1));//content of request
        mockRequest.accept(MediaType.APPLICATION_JSON);//expect JSON type

        ResultMatcher matchStatus = MockMvcResultMatchers.status().isCreated();//expected status
        ResultMatcher matchContent = MockMvcResultMatchers.content().string("New MilitaryPlane created!");//expected content

        this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);//perform request,expect given
    }
}
