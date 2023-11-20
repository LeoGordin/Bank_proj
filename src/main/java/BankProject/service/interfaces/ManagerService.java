package BankProject.service.interfaces;

import BankProject.domain.entity.interfaces.Manager;
import BankProject.domain.entity.jpa.JpaManager;

import java.util.List;

public interface ManagerService {

    List<JpaManager> getAll();

    JpaManager getById(int id);

    void addManager(JpaManager manager);

    void updateManager(JpaManager manager);

    void deleteManager(JpaManager manager);
}
