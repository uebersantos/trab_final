package com.testes.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testes.controllers.HardDiskController;
import com.testes.entity.HardDisk;
import com.testes.repository.HardDiskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@WebMvcTest(HardDiskController.class)
public class HardDiskControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private HardDiskRepository hardDiskRepository;

    private HardDisk sampleHardDisk;

    @BeforeEach
    void setUp() {
        sampleHardDisk = new HardDisk("ABC123", "Seagate", 100.0, 5, 1);
    }

    @Test
    void testAddHardDisk() throws Exception {
        when(hardDiskRepository.save(any(HardDisk.class))).thenReturn(sampleHardDisk);

        mockMvc.perform(MockMvcRequestBuilders.post("/hard-disks")
                        .content(objectMapper.writeValueAsString(sampleHardDisk))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.serialNumber").value("ABC123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.manufacturer").value("Seagate"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(100.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.quantity").value(5))
                .andExpect(MockMvcResultMatchers.jsonPath("$.capacity").value(1));

        verify(hardDiskRepository, times(1)).save(any(HardDisk.class));
    }

    @Test
    void testUpdateHardDisk() throws Exception {
        when(hardDiskRepository.findById(1L)).thenReturn(Optional.of(sampleHardDisk));
        when(hardDiskRepository.save(any(HardDisk.class))).thenReturn(sampleHardDisk);

        HardDisk updatedHardDisk = new HardDisk("XYZ789", "Western Digital", 120.0, 8, 2);

        mockMvc.perform(MockMvcRequestBuilders.put("/hard-disks/1")
                        .content(objectMapper.writeValueAsString(updatedHardDisk))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.serialNumber").value("XYZ789"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.manufacturer").value("Western Digital"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(120.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.quantity").value(8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.capacity").value(2));

        verify(hardDiskRepository, times(1)).findById(1L);
        verify(hardDiskRepository, times(1)).save(any(HardDisk.class));
    }

    @Test
    void testGetAllHardDisks() throws Exception {
        List<HardDisk> hardDisks = Arrays.asList(
                new HardDisk("ABC123", "Seagate", 100.0, 5, 1),
                new HardDisk("XYZ789", "Western Digital", 120.0, 8, 2)
        );

        when(hardDiskRepository.findAll()).thenReturn(hardDisks);

        mockMvc.perform(MockMvcRequestBuilders.get("/hard-disks"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].serialNumber").value("ABC123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].serialNumber").value("XYZ789"));

        verify(hardDiskRepository, times(1)).findAll();
    }

    @Test
    void testGetHardDiskById() throws Exception {
        when(hardDiskRepository.findById(1L)).thenReturn(Optional.of(sampleHardDisk));

        mockMvc.perform(MockMvcRequestBuilders.get("/hard-disks/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.serialNumber").value("ABC123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.manufacturer").value("Seagate"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(100.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.quantity").value(5))
                .andExpect(MockMvcResultMatchers.jsonPath("$.capacity").value(1));

        verify(hardDiskRepository, times(1)).findById(1L);
    }
}
