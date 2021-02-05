package com.example.unittestssample.controllers;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.unittestssample.services.SampleRestService;

@WebMvcTest(controllers = SampleRestController.class)
public class SampleRestControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @MockBean
    protected SampleRestService sampleRestService;

    @DisplayName(value = "Retrieves list of Sample Rest and expect 2XX status")
    @Test
    void getAll_ThenShouldReturnListOfSampleRest() throws Exception {

        mockMvc.perform(
                get("/sample-rest-controller"))
               .andExpect(status().is2xxSuccessful());

    }

    @DisplayName(value = "Retrieves a Sample Rest by ID and expect 2XX status")
    @Test
    void getById_ThenShouldReturnSampleRest() throws Exception {

        mockMvc.perform(
                get("/sample-rest-controller/5"))
               .andExpect(status().is2xxSuccessful());

    }

}
