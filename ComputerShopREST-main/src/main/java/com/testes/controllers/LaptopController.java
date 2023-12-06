package com.testes.controllers;


import com.testes.entity.Laptop;
import com.testes.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laptops")
public class LaptopController {
    private final LaptopRepository laptopRepository;

    @Autowired

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @PostMapping
    public Laptop addLaptop(@RequestBody Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    @PutMapping("/{laptopId}")
    public Laptop updateLaptop(@PathVariable Long laptopId, @RequestBody Laptop updatedLaptop) {
        Laptop laptop = laptopRepository.findById(laptopId)
                .orElseThrow(() -> new RuntimeException("Laptop not found with id: " + laptopId));

        // Обновление полей настольного компьютера
        laptop.setSerialNumber(updatedLaptop.getSerialNumber());
        laptop.setManufacturer(updatedLaptop.getManufacturer());
        laptop.setPrice(updatedLaptop.getPrice());
        laptop.setQuantity(updatedLaptop.getQuantity());
        laptop.setScreenSize(updatedLaptop.getScreenSize());

        return laptopRepository.save(laptop);
    }

    @GetMapping
    public List<Laptop> getAllLaptopss() {
        return laptopRepository.findAll();
    }

    @GetMapping("/{laptopId}")
    public Laptop getDesktopComputerById(@PathVariable Long laptopId) {
        return laptopRepository.findById(laptopId)
                .orElseThrow(() -> new RuntimeException("Laptop not found with id: " + laptopId));
    }
}
