package BankProject.domain.entity.dto;

import BankProject.domain.entity.enums.ManagerStatus;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class ManagerDTO {

    private int id;
    private int userId;
    private String firstName;
    private String lastName;
    private ManagerStatus status;
    private String description;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
