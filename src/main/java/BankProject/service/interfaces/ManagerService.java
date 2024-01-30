package BankProject.service.interfaces;

import BankProject.domain.entity.Manager;

import java.util.List;

public interface ManagerService {

    List<Manager> findAll();

    Manager getById(int id);

    void addManager(Manager manager);

    void updateManager(Manager manager);

    void deleteManager(Manager manager);
}
