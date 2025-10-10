package com.sprint.hospital_management.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sprint.hospital_management.entity.Physician;
import com.sprint.hospital_management.repository.AffiliatedWithRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AffiliatedWithController.class)
public class AffiliatedWithControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AffiliatedWithRepository affiliatedWithRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreatePhysician() throws Exception {
        Physician physician = new Physician();
        physician.setId(1);
        physician.setName("Dr. Mehta");
        physician.setPrimaryAffiliation(true);

        Mockito.when(affiliatedWithRepository.save(Mockito.any())).thenReturn(physician);

        mockMvc.perform(post("/api/affiliated_with")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(physician)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Dr. Mehta"))
                .andExpect(jsonPath("$.primaryAffiliation").value(true));
    }

    @Test
    public void testGetAllPhysicians() throws Exception {
        Physician p1 = new Physician();
        p1.setId(1);
        p1.setName("Dr. A");

        Physician p2 = new Physician();
        p2.setId(2);
        p2.setName("Dr. B");

        Mockito.when(affiliatedWithRepository.findAll()).thenReturn(Arrays.asList(p1, p2));

        mockMvc.perform(get("/api/affiliated_with"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    public void testGetPhysicianById() throws Exception {
        Physician physician = new Physician();
        physician.setId(1);
        physician.setName("Dr. A");

        Mockito.when(affiliatedWithRepository.findById(1)).thenReturn(Optional.of(physician));

        mockMvc.perform(get("/api/affiliated_with/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Dr. A"));
    }

    @Test
    public void testUpdatePrimaryAffiliation() throws Exception {
        Physician physician = new Physician();
        physician.setId(1);
        physician.setName("Dr. A");
        physician.setPrimaryAffiliation(false);

        Mockito.when(affiliatedWithRepository.findById(1)).thenReturn(Optional.of(physician));
        Mockito.when(affiliatedWithRepository.save(Mockito.any())).thenReturn(physician);

        mockMvc.perform(put("/api/affiliated_with/primary/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("true"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }
}