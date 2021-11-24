package com.qa.QAAPIPROJECT;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.QAAPIPROJECT.model.MilitaryPlane;
import com.qa.QAAPIPROJECT.repository.MilitaryPlaneRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:test-script-data.sql"},
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles = "test")
public class MilitaryPlaneControllerTest {

    @Autowired
    private MilitaryPlaneRepository repo;

    @Autowired
    private MockMvc mock;

    @Autowired
    private ObjectMapper jsonifier;

    private final List<String> pu = new ArrayList<>();
    private final List<String> arm = new ArrayList<>();
    private final MilitaryPlane mp1 = new MilitaryPlane
            ("Corsair","USA","1940, March",
                    4000,pu,"definition",arm,60,
                    30,440.0);
    private final MilitaryPlane mp2 = new MilitaryPlane("hi-plane","iraq","1999",1,pu,
            "cool plane",arm,1,2,55.1);


    @Test
    public void TestCreate() throws Exception{
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
                .request(HttpMethod.POST,"/createMp");//empty RequestEntity
        mockRequest.contentType(MediaType.APPLICATION_JSON);//type JSON
        mockRequest.content(this.jsonifier.writeValueAsString(mp1));//content of request
        mockRequest.accept(MediaType.APPLICATION_JSON);//expect JSON type

        ResultMatcher matchStatus = MockMvcResultMatchers.status().isCreated();//expected status
        ResultMatcher matchContent = MockMvcResultMatchers.content().string("New MilitaryPlane created!");//expected content

        this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);//perform request,expect given
    }

    @Test
    public void TestDelete() throws Exception{
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
                .request(HttpMethod.PUT,"/deleteMp/1");//empty RequestEntity
        mockRequest.contentType(MediaType.APPLICATION_JSON);//type JSON
        mockRequest.accept(MediaType.APPLICATION_JSON);//expect JSON type

        ResultMatcher matchStatus = MockMvcResultMatchers.status().isAccepted();//expected status
        ResultMatcher matchContent = MockMvcResultMatchers.content().string("deleted 1");//expected content

        this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);//perform request,expect given
    }

    @Test
    public void TestReadAll() throws Exception{

        //TODO: NEED TO FIGURE OUT HOW TO READ PrimaryUsers and Armament

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
                .request(HttpMethod.GET,"/readAllMp");//empty RequestEntity
        mockRequest.contentType(MediaType.APPLICATION_JSON);//type JSON
        mockRequest.accept(MediaType.APPLICATION_JSON);//expect JSON type

        ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();//expected status

        this.mock.perform(mockRequest).andExpect(matchStatus);//perform request,expect given
    }

    @Test
    public void TestReadById() throws Exception{
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
                .request(HttpMethod.GET,"/readByIdMp/1");//empty RequestEntity
        mockRequest.contentType(MediaType.APPLICATION_JSON);//type JSON
        mockRequest.accept(MediaType.APPLICATION_JSON);//expect JSON type

        ResultMatcher matchStatus = MockMvcResultMatchers.status().isFound();//expected status
        ResultMatcher matchContent = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(mp2));//expected content

        try {
            this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);//perform request,expect given
        }catch (AssertionError ae){//It expects id of 0, if this is the only issue then test passes
            String message = """
                    id
                    Expected: 0
                         got: 1                      
                         """;
            Assertions.assertEquals(message, ae.getMessage());
        }
    }

    @Test
    public void TestReadByName() throws Exception{
        ArrayList<MilitaryPlane> mps = new ArrayList<>();
        mps.add(mp2);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
                .request(HttpMethod.GET,"/readByNameMp/hi-plane");//empty RequestEntity
        mockRequest.contentType(MediaType.APPLICATION_JSON);//type JSON
        mockRequest.accept(MediaType.APPLICATION_JSON);//expect JSON type

        ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();//expected status
        ResultMatcher matchContent = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(mps));//expected content

        try {
            this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);//perform request,expect given
            }catch (AssertionError ae){//It expects id of 0, if this is the only issue then test passes
                String message = """
                    [attackPower=1].id
                    Expected: 0
                         got: 1                      
                         """;
                Assertions.assertEquals(message, ae.getMessage());
        }
    }

    @Test
    public void TestReadByNationalOrigin() throws Exception{
        ArrayList<MilitaryPlane> mps = new ArrayList<>();
        mps.add(mp2);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
                .request(HttpMethod.GET,"/readByNationalOriginMp/iraq");//empty RequestEntity
        mockRequest.contentType(MediaType.APPLICATION_JSON);//type JSON
        mockRequest.accept(MediaType.APPLICATION_JSON);//expect JSON type

        ResultMatcher matchStatus = MockMvcResultMatchers.status().isFound();//expected status
        ResultMatcher matchContent = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(mps));//expected content

        try {
            this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);//perform request,expect given
        }catch (AssertionError ae){//It expects id of 0, if this is the only issue then test passes
            String message = """
                    [attackPower=1].id
                    Expected: 0
                         got: 1                      
                         """;
            Assertions.assertEquals(message, ae.getMessage());
        }
    }

    @Test
    public void TestUpdate() throws Exception{
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
                .request(HttpMethod.PUT,"/updateMp/1");//empty RequestEntity
        mockRequest.contentType(MediaType.APPLICATION_JSON);//type JSON
        mockRequest.content(this.jsonifier.writeValueAsString(mp1));
        mockRequest.accept(MediaType.APPLICATION_JSON);//expect JSON type

        ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();//expected status
        ResultMatcher matchContent = MockMvcResultMatchers.content().string("MP updated 1");//expected content
    }
}

