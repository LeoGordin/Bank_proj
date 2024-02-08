package BankProject.controller;

import BankProject.domain.entity.Role;
import BankProject.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping("/all")
    public List<Role> getAll() {
        return roleService.findAll();
    }

    @PostMapping("/save")
    public Role saveRole(Role role) {
        return roleService.saveRole(role);
    }

    @DeleteMapping("/delete")
    public void deleteRole(Role role) {
        roleService.deleteRole(role);
    }
}
