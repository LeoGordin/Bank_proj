package BankProject.controller;

import BankProject.domain.entity.dto.ManagerDTO;
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
    public List<ManagerDTO> getAll() {
        return managerService.findAll();
    }

    @GetMapping("/{id}")
    public ManagerDTO getById(@PathVariable int id) {
        return managerService.getById(id);
    }

    @PostMapping("/new")
    public void addManager(@RequestBody ManagerDTO manager) {
        managerService.saveManager(manager);
    }

    @DeleteMapping("/delete")
    public void deleteManager(@RequestBody ManagerDTO manager) {
        managerService.deleteManager(manager);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteManagerById(@PathVariable int id) {
        managerService.deleteManagerById(id);
    }
}
