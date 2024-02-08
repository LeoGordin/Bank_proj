package BankProject.service.interfaces;

import BankProject.domain.entity.dto.ClientDTO;

import java.util.List;

public interface ClientServiceInterface {

    List<ClientDTO> findAll();

    ClientDTO getById(int id);

    void saveClient(ClientDTO client);

    void deleteClient(ClientDTO client);

    void deleteClientById(int id);

//    void updateClient(
//            int clientId,
//            int userId,
//            int managerId,
//            Manager manager,
//            ClientStatus status,
//            String taxCode,
//            String firstName,
//            String lastName,
//            String email,
//            String address,
//            String phone,
//            Timestamp createdAt,
//            Timestamp updatedAt,
//            Role role
//    );


}
