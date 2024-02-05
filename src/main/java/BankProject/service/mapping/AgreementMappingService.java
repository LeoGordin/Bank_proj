package BankProject.service.mapping;

import BankProject.domain.entity.Agreement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AgreementMappingService {

    public BankProject.domain.entity.dto.AgreementDTO mapToDTO(Agreement agreement);

    @Mapping(target = "Agreement.id", constant = "null")
    public Agreement mapToEntity(BankProject.domain.entity.dto.AgreementDTO agreementDTO);
}
