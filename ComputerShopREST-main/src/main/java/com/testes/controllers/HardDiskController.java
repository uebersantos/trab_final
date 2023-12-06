package com.testes.controllers;

import com.testes.entity.HardDisk;
import com.testes.repository.HardDiskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hard-disks")
public class HardDiskController {
    private final HardDiskRepository hardDiskRepository;

    @Autowired
    public HardDiskController(HardDiskRepository hardDiskRepository) {
        this.hardDiskRepository = hardDiskRepository;
    }

    @PostMapping
    public HardDisk addHardDisk(@RequestBody HardDisk hardDisk) {
        return hardDiskRepository.save(hardDisk);
    }

    @PutMapping("/{hardDiskId}")
    public HardDisk updateHardDisk(@PathVariable Long hardDiskId, @RequestBody HardDisk updatedHardDisk) {
        HardDisk hardDisk = hardDiskRepository.findById(hardDiskId)
                .orElseThrow(() -> new RuntimeException("Hard disk not found with id: " + hardDiskId));

        // Обновление полей настольного компьютера
        hardDisk.setSerialNumber(updatedHardDisk.getSerialNumber());
        hardDisk.setManufacturer(updatedHardDisk.getManufacturer());
        hardDisk.setPrice(updatedHardDisk.getPrice());
        hardDisk.setQuantity(updatedHardDisk.getQuantity());
        hardDisk.setCapacity(updatedHardDisk.getCapacity());
        System.out.printf(hardDisk.toString());
        return hardDiskRepository.save(hardDisk);
    }

    @GetMapping
    public List<HardDisk> getAllHardDisks() {
        return hardDiskRepository.findAll();
    }

    @GetMapping("/{hardDiskId}")
    public HardDisk getHardDiskById(@PathVariable Long hardDiskId) {
        return hardDiskRepository.findById(hardDiskId)
                .orElseThrow(() -> new RuntimeException("Hard disk not found with id: " + hardDiskId));
    }
}
