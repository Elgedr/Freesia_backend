package com.freesia.server.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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

public class ShipsControllerTest {

    @Autowired
    private MockMvc mockMvc;
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void getAllShipsTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .get("/ships"))
                .andExpect(status()
                        .isOk())
                .andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        List<Ship> ship = objectMapper.readValue(contentAsString, new TypeReference<>() {
        });
        assertEquals(3, ship.size());
    }

    @Test
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

}
