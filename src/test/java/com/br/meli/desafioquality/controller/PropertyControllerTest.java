package com.br.meli.desafioquality.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnPropertySize() throws Exception {
        String request = "{\"propName\": \"A name\", \"propDistrict\": \"Liberdade\", \"rooms\": ["
                + createRoom("oneRoom", 10.0, 10.0) + "," +
                createRoom("anotherRoom", 5.0, 5.0) +
                "]}";

        this.mockMvc.perform(post("/property/size").contentType(MediaType.APPLICATION_JSON).content(request))
                .andExpect(jsonPath("$.propertySize").value(125))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnPropertyValue() throws Exception {
        String request = "{\"propName\": \"A name\", \"propDistrict\": \"Liberdade\", \"rooms\": ["
                + createRoom("oneRoom", 10.0, 10.0) + "," +
                createRoom("anotherRoom", 5.0, 5.0) +
                "]}";

        this.mockMvc.perform(post("/property/value").contentType(MediaType.APPLICATION_JSON).content(request))
                .andExpect(jsonPath("$.propertyValue").value(12500.0))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnBiggestRoom() throws Exception {
        String request = "{\"propName\": \"A name\", \"propDistrict\": \"Liberdade\", \"rooms\": ["
                + createRoom("biggestRoom", 10.0, 10.0) + "," +
                createRoom("anotherRoom", 5.0, 5.0) +
                "]}";

        this.mockMvc.perform(post("/property/biggestRoom").contentType(MediaType.APPLICATION_JSON).content(request))
                .andExpect(jsonPath("$.name").value("biggestRoom"))
                .andExpect(jsonPath("$.size").value("100.0"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnRoomsSize() throws Exception {
        String request = "{\"propName\": \"A name\", \"propDistrict\": \"Liberdade\", \"rooms\": ["
                + createRoom("oneRoom", 10.0, 10.0) + "," +
                createRoom("anotherRoom", 5.0, 5.0) +
                "]}";

        this.mockMvc.perform(post("/property/rooms/size").contentType(MediaType.APPLICATION_JSON).content(request))
                .andDo(print())
                .andExpect(jsonPath("$.[0].roomSize").value(100.0))
                .andExpect(jsonPath("$.[1].roomSize").value(25.0))
                .andExpect(status().isOk());
    }

    private String createRoom(String name, Double width, Double length) {
        return "{\"roomName\": \"" + name + "\", \"roomWidth\": " + width + ", \"roomLength\": " + length + "}";
    }


}
