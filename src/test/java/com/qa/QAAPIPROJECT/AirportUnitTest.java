package com.qa.QAAPIPROJECT;

import com.qa.QAAPIPROJECT.model.Airport;
import com.qa.QAAPIPROJECT.repository.AirportRepository;
import com.qa.QAAPIPROJECT.repository.MilitaryPlaneRepository;
import com.qa.QAAPIPROJECT.service.AirportService;
import com.qa.QAAPIPROJECT.service.MilitaryPlaneService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AirportUnitTest {

    @Autowired
    private AirportService service;

    @MockBean
    private AirportRepository repo;

    @Test
    void testCreate(){
        Mockito.when(this.repo.save(TestingConstants.ap3)).thenReturn(TestingConstants.ap3);
        Assertions.assertThat(this.service.addAirport(TestingConstants.aps)).isTrue();
        Mockito.verify(this.repo, Mockito.times(1)).save(TestingConstants.ap3);
    }

    @Test
    void testUpdate(){
        final String apc = TestingConstants.ap3.getAirportCode();

        Mockito.when(this.repo.findById(apc)).thenReturn(Optional.of(TestingConstants.ap3));
        Mockito.when(this.repo.save(TestingConstants.ap3)).thenReturn(TestingConstants.ap3);
        Assertions.assertThat(this.service.update(apc,TestingConstants.ap3)).isEqualTo(TestingConstants.ap3);
        Mockito.verify(this.repo, Mockito.times(1)).findById(apc);
        Mockito.verify(this.repo, Mockito.times(1)).save(TestingConstants.ap3);
    }

    @Test
    void readById(){
        final String apc = TestingConstants.ap3.getAirportCode();

        Mockito.when(this.repo.findById(apc)).thenReturn(Optional.of(TestingConstants.ap3));
        Assertions.assertThat(this.service.readByAirportCode(apc)).isEqualTo(TestingConstants.ap1);
        Mockito.verify(this.repo, Mockito.times(1)).findById(apc);
    }

    @Test
    void readAll(){
        Mockito.when(this.repo.findAll()).thenReturn(TestingConstants.aps);
        Assertions.assertThat(this.service.getAll()).isEqualTo(TestingConstants.apsDTO);
        Mockito.verify(this.repo, Mockito.times(1)).findAll();
    }

}
