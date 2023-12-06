package com.testes.controllers;

import com.testes.entity.Monitor;
import com.testes.repository.MonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monitors")
public class MonitorController {
    private final MonitorRepository monitorRepository;

    @Autowired
    public MonitorController(MonitorRepository monitorRepository) {
        this.monitorRepository = monitorRepository;
    }

    @PostMapping
    public Monitor addMonitor(@RequestBody Monitor monitor) {
        return monitorRepository.save(monitor);
    }

    @PutMapping("/{monitorId}")
    public Monitor updateMonitor(@PathVariable Long monitorId, @RequestBody Monitor updatedMonitor) {
        Monitor monitor = monitorRepository.findById(monitorId)
                .orElseThrow(() -> new RuntimeException("Monitor not found with id: " + monitorId));

        // Обновление полей настольного компьютера
        monitor.setSerialNumber(updatedMonitor.getSerialNumber());
        monitor.setManufacturer(updatedMonitor.getManufacturer());
        monitor.setPrice(updatedMonitor.getPrice());
        monitor.setQuantity(updatedMonitor.getQuantity());
        monitor.setDiagonal(updatedMonitor.getDiagonal());

        return monitorRepository.save(monitor);
    }

    @GetMapping
    public List<Monitor> getAllMonitors() {
        return monitorRepository.findAll();
    }

    @GetMapping("/{monitorId}")
    public Monitor getMonitorById(@PathVariable Long monitorId) {
        return monitorRepository.findById(monitorId)
                .orElseThrow(() -> new RuntimeException("Monitor not found with id: " + monitorId));
    }
}
