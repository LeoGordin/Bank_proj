package BankProject.service.interfaces;

import BankProject.domain.entity.Manager;
import BankProject.domain.entity.Role;
import BankProject.domain.entity.dto.ManagerDTO;
import BankProject.domain.entity.enums.ManagerStatus;

import java.sql.Timestamp;
import java.util.List;

public interface ManagerService {

    List<ManagerDTO> findAll();

    ManagerDTO getById(int id);

    void addManager(ManagerDTO manager);

    void deleteManager(ManagerDTO manager);

//    void updateManager(
//            int id,
//            int userId,
//            String firstName,
//            String lastName,
//            ManagerStatus status,
//            String description,
//            Timestamp createdAt,
//            Timestamp updatedAt,
//            Role role
//    );
}
