package BankProject.service.mapping;

import BankProject.domain.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMappingService {


    public BankProject.domain.entity.dto.ClientDTO mapToDTO(Client client);

    @Mapping(target = "Client.id", constant = "0")
    @Mapping(target = "Client.userId", constant = "0")
    public Client mapToEntity(BankProject.domain.entity.dto.ClientDTO clientDTO);
}
