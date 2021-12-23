package com.freesia.server.controller;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.freesia.server.models.Flight;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class FlightControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper = JsonMapper.builder()
            .addModule(new JavaTimeModule())
            .build();


    @Test
    @WithMockUser(username = "erika", password = "123456", roles = {"ADMIN"})
    public void getAllFlightsTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .get("/flights"))
                .andExpect(status()
                        .isOk())
                .andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        List<Flight> flightsList = objectMapper.readValue(contentAsString, new TypeReference<>() {
        });
        assertEquals(12, flightsList.size());
    }

    @Test
    @WithMockUser(username = "erika", password = "123456", roles = {"ADMIN"})
    public void getFlight1DeparturePlace() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .get("/flights/1"))
                .andExpect(status()
                        .isOk())
                .andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        Flight flight = objectMapper.readValue(contentAsString, new TypeReference<>() {
        });
        assertEquals( "Tallinn", flight.getDeparturePlace());
    }

    @Test
    @WithMockUser(username = "erika", password = "123456", roles = {"ADMIN"})
    public void getFlight1DestinationPlace() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .get("/flights/1"))
                .andExpect(status()
                        .isOk())
                .andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        Flight flight = objectMapper.readValue(contentAsString, new TypeReference<>() {
        });
        assertEquals("Moon", flight.getDestinationPlace());
    }

    @Test
    @WithMockUser(username = "erika", password = "123456", roles = {"ADMIN"})
    public void getFlight4DepartureTime() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .get("/flights/4"))
                .andExpect(status()
                        .isOk())
                .andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        Flight flight = objectMapper.readValue(contentAsString, new TypeReference<>() {
        });
        LocalDateTime date5 = LocalDateTime.of(2025, Month.DECEMBER, 19, 0, 0);
        assertEquals(date5, flight.getDepartureTime());
    }

    @Test
    @WithMockUser(username = "erika", password = "123456", roles = {"ADMIN"})
    public void getFlight4ArrivalTime() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .get("/flights/4"))
                .andExpect(status()
                        .isOk())
                .andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        Flight flight = objectMapper.readValue(contentAsString, new TypeReference<>() {
        });
        LocalDateTime date55 = LocalDateTime.of(2025, Month.DECEMBER, 19, 5, 40);
        assertEquals(date55, flight.getArrivalTime());
    }


}

