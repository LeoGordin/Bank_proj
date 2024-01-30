package BankProject.controller;

import BankProject.domain.entity.Manager;
import BankProject.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    ManagerService managerService;

    @GetMapping("/all")
    public List<Manager> getAll() {
        return managerService.findAll();
    }

    @GetMapping("/{id}")
    public Manager getById(@PathVariable int id) {
        return managerService.getById(id);
    }

    @PostMapping("/new")
    public void addManager(@RequestBody Manager manager) {
        managerService.addManager(manager);
    }

    @PutMapping("/update")
    public void updateManager(@RequestBody Manager manager) {
        managerService.updateManager(manager);
    }

    @DeleteMapping("/delete")
    public void deleteManager(@RequestBody Manager manager) {
        managerService.deleteManager(manager);
    }
}
