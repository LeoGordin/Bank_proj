package BankProject.domain.entity.dto;

import BankProject.domain.entity.Manager;
import BankProject.domain.entity.Role;
import BankProject.domain.entity.enums.ClientStatus;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class ClientDTO {

    private int id;
    private int userId;
    private Manager manager;
    private ClientStatus status;
    private String taxCode;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phone;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Role role;
}
