package com.testes.controllers;


import com.testes.entity.Desktop;
import com.testes.repository.DesktopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/desktops")
public class DesktopController {
    private final DesktopRepository desktopRepository;

    @Autowired
    public DesktopController(DesktopRepository desktopRepository) {
        this.desktopRepository = desktopRepository;
    }

    @PostMapping
    public Desktop addDesktopComputer(@RequestBody Desktop desktopComputer) {
        return desktopRepository.save(desktopComputer);
    }

    @PutMapping("/{desktopId}")
    public Desktop updateDesktopComputer(@PathVariable Long desktopId, @RequestBody Desktop updatedDesktopComputer) {
        Desktop desktopComputer = desktopRepository.findById(desktopId)
                .orElseThrow(() -> new RuntimeException("Desktop not found with id: " + desktopId));

        // Обновление полей настольного компьютера
        desktopComputer.setSerialNumber(updatedDesktopComputer.getSerialNumber());
        desktopComputer.setManufacturer(updatedDesktopComputer.getManufacturer());
        desktopComputer.setPrice(updatedDesktopComputer.getPrice());
        desktopComputer.setQuantity(updatedDesktopComputer.getQuantity());
        desktopComputer.setFormFactor(updatedDesktopComputer.getFormFactor());

        return desktopRepository.save(desktopComputer);
    }

    @GetMapping
    public List<Desktop> getAllDesktopComputers() {
        return desktopRepository.findAll();
    }

    @GetMapping("/{desktopId}")
    public Desktop getDesktopComputerById(@PathVariable Long desktopId) {
        return desktopRepository.findById(desktopId)
                .orElseThrow(() -> new RuntimeException("Desktop not found with id: " + desktopId));
    }
}
