package BankProject.service.mapping;

import BankProject.domain.entity.Manager;
import BankProject.domain.entity.dto.ManagerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ManagerMappingService {

    public ManagerDTO mapToDTO(Manager manager);

    @Mapping(target = "Manager.id", constant = "0")
    @Mapping(target = "Manager.userId", constant = "0")
    public Manager mapToEntity(ManagerDTO managerDTO);
}
