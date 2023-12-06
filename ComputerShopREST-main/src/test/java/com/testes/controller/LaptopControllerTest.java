package com.testes.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testes.controllers.LaptopController;
import com.testes.entity.Laptop;
import com.testes.repository.LaptopRepository;
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

@WebMvcTest(LaptopController.class)
public class LaptopControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private LaptopRepository laptopRepository;

    private Laptop sampleLaptop;

    @BeforeEach
    void setUp() {
        sampleLaptop = new Laptop("ABC123", "Dell", 1200.0, 3, 15);
    }

    @Test
    void testAddLaptop() throws Exception {
        when(laptopRepository.save(any(Laptop.class))).thenReturn(sampleLaptop);

        mockMvc.perform(MockMvcRequestBuilders.post("/laptops")
                        .content(objectMapper.writeValueAsString(sampleLaptop))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.serialNumber").value("ABC123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.manufacturer").value("Dell"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(1200.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.quantity").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.screenSize").value(15));

        verify(laptopRepository, times(1)).save(any(Laptop.class));
    }

    @Test
    void testUpdateLaptop() throws Exception {
        when(laptopRepository.findById(1L)).thenReturn(Optional.of(sampleLaptop));
        when(laptopRepository.save(any(Laptop.class))).thenReturn(sampleLaptop);

        Laptop updatedLaptop = new Laptop("XYZ789", "Lenovo", 1500.0, 5, 14);

        mockMvc.perform(MockMvcRequestBuilders.put("/laptops/1")
                        .content(objectMapper.writeValueAsString(updatedLaptop))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.serialNumber").value("XYZ789"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.manufacturer").value("Lenovo"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(1500.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.quantity").value(5))
                .andExpect(MockMvcResultMatchers.jsonPath("$.screenSize").value(14));

        verify(laptopRepository, times(1)).findById(1L);
        verify(laptopRepository, times(1)).save(any(Laptop.class));
    }

    @Test
    void testGetAllLaptops() throws Exception {
        List<Laptop> laptops = Arrays.asList(
                new Laptop("ABC123", "Dell", 1200.0, 3, 15),
                new Laptop("XYZ789", "Dell", 1200.0, 3, 15)
        );

        when(laptopRepository.findAll()).thenReturn(laptops);

        mockMvc.perform(MockMvcRequestBuilders.get("/laptops"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].serialNumber").value("ABC123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].serialNumber").value("XYZ789"));

        verify(laptopRepository, times(1)).findAll();
    }

    @Test
    void testGetLaptopById() throws Exception {
        when(laptopRepository.findById(1L)).thenReturn(Optional.of(sampleLaptop));

        mockMvc.perform(MockMvcRequestBuilders.get("/laptops/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.serialNumber").value("ABC123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.manufacturer").value("Dell"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(1200.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.quantity").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.screenSize").value(15));

        verify(laptopRepository, times(1)).findById(1L);
    }
}
