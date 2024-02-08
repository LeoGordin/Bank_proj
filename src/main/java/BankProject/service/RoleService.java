package BankProject.service;

import BankProject.domain.entity.Role;
import BankProject.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role saveRole(Role role) {
        roleRepository.save(role);
        return role;
    }

    public void deleteRole(Role role) {
        roleRepository.delete(role);
    }
}
