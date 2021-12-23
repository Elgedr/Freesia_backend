package com.freesia.server.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freesia.server.models.Ship;
import com.freesia.server.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ShipsControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    @WithMockUser(username = "erika", password = "123456", roles = {"ADMIN"})
    public void getAllShipsTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .get("/ships"))
                .andExpect(status()
                        .isOk())
                .andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        List<Ship> ship = objectMapper.readValue(contentAsString, new TypeReference<>() {
        });
        assertEquals(8, ship.size());
    }

    @Test
    @WithMockUser(username = "erika", password = "123456", roles = {"ADMIN"})
    public void shipById() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .get("/ships/3"))
                .andExpect(status()
                        .isOk())
                .andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        Ship ship = objectMapper.readValue(contentAsString, new TypeReference<>() {
        });
        assertEquals("COV-2019", ship.getName());

    }

    @Test
    @WithMockUser(username = "erika", password = "123456", roles = {"ADMIN"})
    public void getShipByNumberOfPlaces() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .get("/ships/1"))
                .andExpect(status()
                        .isOk())
                .andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        Ship ship = objectMapper.readValue(contentAsString, new TypeReference<>() {
        });
        assertEquals(3, ship.getNumOfPlaces());
    }

    @Test
    @WithMockUser(username = "erika", password = "123456", roles = {"ADMIN"})
    public void getShipByNumberOfAvailablePlaces() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .get("/ships/2"))
                .andExpect(status()
                        .isOk())
                .andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        Ship ship = objectMapper.readValue(contentAsString, new TypeReference<>() {
        });
        assertEquals(3, ship.getNumOfAvailablePlaces());
    }
}