package com.qa.QAAPIPROJECT;

import com.qa.QAAPIPROJECT.repository.MilitaryPlaneRepository;
import com.qa.QAAPIPROJECT.service.MilitaryPlaneService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MilitaryPlaneServiceUnitTest {

    @Autowired
    private MilitaryPlaneService service;

    @MockBean
    private MilitaryPlaneRepository repo;


    @Test
    void testCreate(){
        Mockito.when(this.repo.save(TestingConstants.mp1)).thenReturn(TestingConstants.mp1Saved);
        Assertions.assertThat(this.service.addPlane(TestingConstants.mp1List)).isTrue();
        Mockito.verify(this.repo, Mockito.times(1)).save(TestingConstants.mp1);
    }

    @Test
    void testUpdate(){
        final long id = TestingConstants.mp1Saved.getId();

        Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(TestingConstants.mp1Saved));
        Mockito.when(this.repo.save(TestingConstants.mp2)).thenReturn(TestingConstants.mp2);
        Assertions.assertThat(this.service.update(id,TestingConstants.mp2)).isEqualTo(TestingConstants.mp2);
        Mockito.verify(this.repo, Mockito.times(1)).findById(id);
        Mockito.verify(this.repo, Mockito.times(1)).save(TestingConstants.mp2);
    }

    @Test
    void readById(){
        final long id = TestingConstants.mp1Saved.getId();

        Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(TestingConstants.mp1Saved));
        Assertions.assertThat(this.service.readById(id)).isEqualTo(TestingConstants.mp1SavedDTO);
        Mockito.verify(this.repo, Mockito.times(1)).findById(id);
    }

    @Test
    void readAll(){
        Mockito.when(this.repo.findAll()).thenReturn(TestingConstants.mp1List);
        Assertions.assertThat(this.service.getAll()).isEqualTo(TestingConstants.mpDtos);
        Mockito.verify(this.repo, Mockito.times(1)).findAll();
    }

    @Test
    void testDelete(){
        final long id = 1L;
        Assertions.assertThat(this.service.delete(id)).isTrue();
        Mockito.verify(this.repo, Mockito.times(1)).deleteById(id);
    }

    @Test
    void readByName(){
        final String name = TestingConstants.mp1Saved.getModelName();
        Mockito.when(this.repo.findPlaneByModelName(name)).thenReturn(TestingConstants.mp1List);
        Assertions.assertThat(this.service.readByName(name)).isEqualTo(TestingConstants.mpDtos);
        Mockito.verify(this.repo,Mockito.times(1)).findPlaneByModelName(name);
    }

    @Test
    void readByNationalOrigin(){
        final String nationalOrigin = TestingConstants.mp1Saved.getNationalOrigin();
        Mockito.when(this.repo.findPlaneByNationalOrigin(nationalOrigin)).thenReturn(TestingConstants.mp1List);
        Assertions.assertThat(this.service.readByNationalOrigin(nationalOrigin)).isEqualTo(TestingConstants.mpDtos);
        Mockito.verify(this.repo,Mockito.times(1)).findPlaneByNationalOrigin(nationalOrigin);
    }
}
