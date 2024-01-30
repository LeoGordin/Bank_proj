package BankProject.service;

import BankProject.domain.entity.Manager;
import BankProject.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService implements BankProject.service.interfaces.ManagerService {

    @Autowired
    ManagerRepository managerRepository;
    @Override
    public List<Manager> findAll() {
        return managerRepository.findAll();
    }

    @Override
    public Manager getById(int id) {
        return managerRepository.findById(id).orElse(null);
    }

    @Override
    public void addManager(Manager manager) {
        managerRepository.save(manager);
    }

    @Override
    public void updateManager(Manager manager) {
        managerRepository.saveAndFlush(manager);
    }

    @Override
    public void deleteManager(Manager manager) {
        managerRepository.delete(manager);
    }
}
