package BankProject.service.jpa;

import BankProject.domain.entity.interfaces.Manager;
import BankProject.domain.entity.jpa.JpaManager;
import BankProject.repository.ManagerRepository;
import BankProject.service.interfaces.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaManagerService implements ManagerService {

    @Autowired
    ManagerRepository managerRepository;
    @Override
    public List<JpaManager> findAll() {
        return managerRepository.findAll();
    }

    @Override
    public JpaManager getById(int id) {
        return managerRepository.findById(id).orElse(null);
    }

    @Override
    public void addManager(JpaManager manager) {
        managerRepository.save(manager);
    }

    @Override
    public void updateManager(JpaManager manager) {
        managerRepository.saveAndFlush(manager);
    }

    @Override
    public void deleteManager(JpaManager manager) {
        managerRepository.delete(manager);
    }
}
