package BankProject.service.interfaces;

import BankProject.domain.entity.dto.ManagerDTO;

import java.util.List;

public interface ManagerServiceInterface {

    List<ManagerDTO> findAll();

    ManagerDTO getById(int id);

    void saveManager(ManagerDTO manager);

    void deleteManager(ManagerDTO manager);

    void deleteManagerById(int id);

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
