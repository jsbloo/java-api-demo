package com.qa.QAAPIPROJECT;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.QAAPIPROJECT.repository.AirportRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:test-script2-data.sql"})
@ActiveProfiles(profiles = "test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class AirportControllerTest {

    @Autowired
    private AirportRepository repo;

    @Autowired
    private MockMvc mock;

    @Autowired
    private ObjectMapper jsonifier;

    @Test
    void TestCreate() throws Exception{
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
                .request(HttpMethod.POST,"/createAirport");
        mockRequest.contentType(MediaType.APPLICATION_JSON);
        mockRequest.content(this.jsonifier.writeValueAsString(TestingConstants.ap1));
        mockRequest.accept(MediaType.APPLICATION_JSON);

        ResultMatcher matchStatus = MockMvcResultMatchers.status().isCreated();
        ResultMatcher matchContent = MockMvcResultMatchers.content().string("New Airport created!");
         this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
    }

    @Test
    void TestReadAll() throws Exception{
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
                .request(HttpMethod.GET,"/readAllAirport");//empty RequestEntity
        mockRequest.contentType(MediaType.APPLICATION_JSON);//type JSON
        mockRequest.accept(MediaType.APPLICATION_JSON);//expect JSON type

        ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();//expected status
        ResultMatcher matchContent = MockMvcResultMatchers.content()//expected content
                .json(this.jsonifier.writeValueAsString(TestingConstants.apsDTO));
        this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
    }

    @Test
    void TestReadById() throws Exception {
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
                .request(HttpMethod.GET, "/readByAirportCode/LHR");//empty RequestEntity
        mockRequest.contentType(MediaType.APPLICATION_JSON);//type JSON
        mockRequest.accept(MediaType.APPLICATION_JSON);//expect JSON type

        ResultMatcher matchStatus = MockMvcResultMatchers.status().isFound();//expected status
        ResultMatcher matchContent = MockMvcResultMatchers.content()
                .json(jsonifier.writeValueAsString(TestingConstants.ap1));//expected content

        this.mock.perform(mockRequest).andExpect(matchContent).andExpect(matchStatus);
    }

    @Test
    void TestUpdate() throws Exception{
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
                .request(HttpMethod.PUT,"/updateAirport/LHR");//empty RequestEntity
        mockRequest.contentType(MediaType.APPLICATION_JSON);//type JSON
        mockRequest.content(this.jsonifier.writeValueAsString(TestingConstants.ap2));
        mockRequest.accept(MediaType.APPLICATION_JSON);//expect JSON type

        ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();//expected status
        ResultMatcher matchContent = MockMvcResultMatchers.content().string("Airport LHR Updated");//expected content
        this.mock.perform(mockRequest).andExpect(matchContent).andExpect(matchStatus);
    }

    @Test
    void TestDelete() throws Exception{
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
                .request(HttpMethod.PUT,"/deleteAirport/LHR");//empty RequestEntity
        mockRequest.contentType(MediaType.APPLICATION_JSON);//type JSON
        mockRequest.accept(MediaType.APPLICATION_JSON);//expect JSON type

        ResultMatcher matchStatus = MockMvcResultMatchers.status().isAccepted();//expected status
        ResultMatcher matchContent = MockMvcResultMatchers.content().string("deleted LHR");//expected content

        this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);//perform request,expect given
    }

}
