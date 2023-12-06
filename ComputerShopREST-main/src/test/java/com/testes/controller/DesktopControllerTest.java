package com.testes.controller;


import com.testes.controllers.DesktopController;
import com.testes.entity.Desktop;
import com.testes.repository.DesktopRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(DesktopController.class)
public class DesktopControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DesktopRepository desktopRepository;

    @Test
    public void testAddDesktopComputer() throws Exception {
        Desktop desktopComputer = new Desktop();
        desktopComputer.setSerialNumber("123456");
        desktopComputer.setManufacturer("Example Manufacturer");
        desktopComputer.setPrice(999.99);
        desktopComputer.setQuantity(10);
        desktopComputer.setFormFactor("Desktop");

        when(desktopRepository.save(any(Desktop.class))).thenReturn(desktopComputer);

        mockMvc.perform(MockMvcRequestBuilders.post("/desktops")
                        .contentType("application/json")
                        .content("{\"serialNumber\":\"123456\",\"manufacturer\":\"Example Manufacturer\",\"price\":999.99,\"quantity\":10,\"formFactor\":\"Desktop\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.serialNumber").value("123456"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.manufacturer").value("Example Manufacturer"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(999.99))
                .andExpect(MockMvcResultMatchers.jsonPath("$.quantity").value(10))
                .andExpect(MockMvcResultMatchers.jsonPath("$.formFactor").value("Desktop"));
    }

    @Test
    public void testUpdateDesktopComputer() throws Exception {
        Desktop desktopComputer = new Desktop();
        desktopComputer.setId(1L);
        desktopComputer.setSerialNumber("123456");
        desktopComputer.setManufacturer("Example Manufacturer");
        desktopComputer.setPrice(999.99);
        desktopComputer.setQuantity(10);
        desktopComputer.setFormFactor("Desktop");

        when(desktopRepository.findById(1L)).thenReturn(java.util.Optional.of(desktopComputer));
        when(desktopRepository.save(any(Desktop.class))).thenReturn(desktopComputer);

        mockMvc.perform(MockMvcRequestBuilders.put("/desktops/1")
                        .contentType("application/json")
                        .content("{\"serialNumber\":\"123456\",\"manufacturer\":\"Example Manufacturer\",\"price\":999.99,\"quantity\":10,\"formFactor\":\"Desktop\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.serialNumber").value("123456"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.manufacturer").value("Example Manufacturer"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(999.99))
                .andExpect(MockMvcResultMatchers.jsonPath("$.quantity").value(10))
                .andExpect(MockMvcResultMatchers.jsonPath("$.formFactor").value("Desktop"));
    }

    @Test
    public void testGetAllDesktopComputers() throws Exception {
        List<Desktop> desktopComputers = new ArrayList<>();

        Desktop desktop1 = new Desktop();
        desktop1.setId(1L);
        desktop1.setSerialNumber("123456");
        desktop1.setManufacturer("Example Manufacturer");
        desktop1.setPrice(999.99);
        desktop1.setQuantity(10);
        desktop1.setFormFactor("Desktop");
        desktopComputers.add(desktop1);

        Desktop desktop2 = new Desktop();
        desktop2.setId(2L);
        desktop2.setSerialNumber("789012");
        desktop2.setManufacturer("Another Manufacturer");
        desktop2.setPrice(1299.99);
        desktop2.setQuantity(5);
        desktop2.setFormFactor("Monoblock");
        desktopComputers.add(desktop2);

        when(desktopRepository.findAll()).thenReturn(desktopComputers);

        mockMvc.perform(MockMvcRequestBuilders.get("/desktops"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].serialNumber").value("123456"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].manufacturer").value("Example Manufacturer"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].price").value(999.99))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].quantity").value(10))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].formFactor").value("Desktop"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].serialNumber").value("789012"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].manufacturer").value("Another Manufacturer"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].price").value(1299.99))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].quantity").value(5))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].formFactor").value("Monoblock"));
    }

    @Test
    public void testGetDesktopComputerById() throws Exception {
        Desktop desktop = new Desktop();
        desktop.setId(1L);
        desktop.setSerialNumber("123456");
        desktop.setManufacturer("Example Manufacturer");
        desktop.setPrice(999.99);
        desktop.setQuantity(10);
        desktop.setFormFactor("Desktop");

        when(desktopRepository.findById(1L)).thenReturn(java.util.Optional.of(desktop));

        mockMvc.perform(MockMvcRequestBuilders.get("/desktops/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.serialNumber").value("123456"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.manufacturer").value("Example Manufacturer"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(999.99))
                .andExpect(MockMvcResultMatchers.jsonPath("$.quantity").value(10))
                .andExpect(MockMvcResultMatchers.jsonPath("$.formFactor").value("Desktop"));
    }
}
