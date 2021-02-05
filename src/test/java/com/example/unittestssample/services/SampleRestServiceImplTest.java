package com.example.unittestssample.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.unittestssample.model.SampleRest;
import com.example.unittestssample.repositories.SampleRestRepository;

@ExtendWith(SpringExtension.class)
class SampleRestServiceImplTest {

    @InjectMocks
    private SampleRestServiceImpl sampleRestService;

    @Mock
    private SampleRestRepository sampleRestRepository;

    @Test
    void getAll_WhenIsValidIsTrue_ThenShouldReturnListOfSampleRest() {
        doReturn(Lists.newArrayList(SampleRest.builder().value("first").build(), SampleRest.builder().value("second").build())).when(sampleRestRepository).findAll();
        List<SampleRest> listOfString = sampleRestService.getAll(true);
        assertNotNull(listOfString);
        assertFalse(listOfString.isEmpty());

        listOfString.forEach(s -> assertTrue(s instanceof SampleRest));

        assertTrue(listOfString.size() == 2);

        assertEquals("first", listOfString.get(0).getValue());
        assertEquals("second", listOfString.get(1).getValue());

    }

    @Test
    void getAll_WhenIsValidIsFalse_ThenShouldReturnListOfSampleRestWithInvalid() {
        doReturn(Lists.newArrayList(SampleRest.builder().value("invalid"))).when(sampleRestRepository).findAll();
        List<SampleRest> listOfString = sampleRestService.getAll(false);
        assertNotNull(listOfString);
        assertFalse(listOfString.isEmpty());

        listOfString.forEach(s -> assertTrue(s instanceof SampleRest));

        assertTrue(listOfString.size() == 1);

        assertEquals("invalid", listOfString.get(0).getValue());

    }

    @Test
    void getById_ThenShouldReturnSampleRest() {
        doReturn(Optional.of(SampleRest.builder().value("first").build())).when(sampleRestRepository).findById(any());
        SampleRest returnedValue = sampleRestService.getById(any());
        assertNotNull(returnedValue);
        assertFalse(returnedValue.getValue().isEmpty());
        assertEquals("first", returnedValue.getValue());
    }

    @Test
    void getById_WhenSampleRestNotFound_ThenShouldThrowRuntimeException() {
        doReturn(Optional.empty()).when(sampleRestRepository).findById(any());
        Assertions.assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> sampleRestService.getById(any()));
    }
}