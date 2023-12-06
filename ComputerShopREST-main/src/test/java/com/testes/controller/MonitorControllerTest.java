package com.testes.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testes.controllers.MonitorController;
import com.testes.entity.Monitor;
import com.testes.repository.MonitorRepository;
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

import static org.mockito.Mockito.*;

@WebMvcTest(MonitorController.class)
public class MonitorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private MonitorRepository monitorRepository;

    private Monitor sampleMonitor;

    @BeforeEach
    void setUp() {
        sampleMonitor = new Monitor("ABC123", "Dell", 500.0, 3, 24.0);
    }

    @Test
    void testAddMonitor() throws Exception {
        when(monitorRepository.save(any(Monitor.class))).thenReturn(sampleMonitor);

        mockMvc.perform(MockMvcRequestBuilders.post("/monitors")
                        .content(objectMapper.writeValueAsString(sampleMonitor))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.serialNumber").value("ABC123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.manufacturer").value("Dell"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(500.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.quantity").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.diagonal").value(24.0));

        verify(monitorRepository, times(1)).save(any(Monitor.class));
    }

    @Test
    void testUpdateMonitor() throws Exception {
        when(monitorRepository.findById(1L)).thenReturn(Optional.of(sampleMonitor));
        when(monitorRepository.save(any(Monitor.class))).thenReturn(sampleMonitor);

        Monitor updatedMonitor = new Monitor("XYZ789", "Lenovo", 600.0, 4, 27.0);

        mockMvc.perform(MockMvcRequestBuilders.put("/monitors/1")
                        .content(objectMapper.writeValueAsString(updatedMonitor))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.serialNumber").value("XYZ789"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.manufacturer").value("Lenovo"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(600.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.quantity").value(4))
                .andExpect(MockMvcResultMatchers.jsonPath("$.diagonal").value(27.0));

        verify(monitorRepository, times(1)).findById(1L);
        verify(monitorRepository, times(1)).save(any(Monitor.class));
    }

    @Test
    void testGetAllMonitors() throws Exception {
        List<Monitor> monitors = Arrays.asList(
                new Monitor("ABC123", "Dell", 500.0, 3, 24.0),
                new Monitor("XYZ789", "Lenovo", 600.0, 4, 27.0)
        );

        when(monitorRepository.findAll()).thenReturn(monitors);

        mockMvc.perform(MockMvcRequestBuilders.get("/monitors"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].serialNumber").value("ABC123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].serialNumber").value("XYZ789"));

        verify(monitorRepository, times(1)).findAll();
    }

    @Test
    void testGetMonitorById() throws Exception {
        when(monitorRepository.findById(1L)).thenReturn(Optional.of(sampleMonitor));

        mockMvc.perform(MockMvcRequestBuilders.get("/monitors/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.serialNumber").value("ABC123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.manufacturer").value("Dell"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(500.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.quantity").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.diagonal").value(24.0));

        verify(monitorRepository, times(1)).findById(1L);
    }

}
