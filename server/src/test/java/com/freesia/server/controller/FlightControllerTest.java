package com.freesia.server.controller;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.freesia.server.models.Flight;
import com.freesia.server.models.Ship;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class FlightControllerTest {

    @Autowired
    private MockMvc mockMvc;
    ObjectMapper mapper = JsonMapper.builder()
            .addModule(new JavaTimeModule())
            .build();

    @Test
    public void getAllFlightsTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .get("/flights"))
                .andExpect(status()
                        .isOk())
                .andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        List<Flight> flight = mapper.readValue(contentAsString, new TypeReference<>() {
        });
        assertEquals(12, flight.size());
    }
}

