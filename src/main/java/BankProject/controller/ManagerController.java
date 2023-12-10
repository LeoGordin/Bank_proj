package BankProject.controller;

import BankProject.domain.entity.jpa.JpaManager;
import BankProject.service.jpa.JpaManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    JpaManagerService managerService;

    @GetMapping
    public List<JpaManager> getAll() {
        return managerService.findAll();
    }

    @GetMapping("/{id}")
    public JpaManager getById(@PathVariable int id) {
        return managerService.getById(id);
    }

    @PostMapping
    public void addManager(@RequestBody JpaManager manager) {
        managerService.addManager(manager);
    }

    @PutMapping
    public void updateManager(@RequestBody JpaManager manager) {
        managerService.updateManager(manager);
    }

    @DeleteMapping
    public void deleteManager(@RequestBody JpaManager manager) {
        managerService.deleteManager(manager);
    }
}
