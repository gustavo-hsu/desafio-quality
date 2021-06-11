package com.br.meli.desafioquality;

import org.junit.jupiter.api.Test;
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
    void shouldReturnHouseTotalSize() throws Exception {
        String request = "{\"propName\": \"A name\", \"propDistrict\": \"Liberdade\", \"rooms\": ["
                + createRoom("oneRoom", 10.0, 10.0) + "," +
                createRoom("anotherRoom", 5.0, 5.0) +
                "]}";

        this.mockMvc.perform(post("/property/size").contentType(MediaType.APPLICATION_JSON).content(request))
                .andExpect(jsonPath("$.propertySize").value(125))
                .andExpect(status().isOk());
    }

    private String createRoom(String name, Double width, Double length) {
        return "{\"roomName\": \"" + name + "\", \"roomWidth\": " + width + ", \"roomLength\": " + length + "}";
    }
}
