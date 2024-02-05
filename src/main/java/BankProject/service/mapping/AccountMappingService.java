package BankProject.service.mapping;

import BankProject.domain.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMappingService {

    public BankProject.domain.entity.dto.AccountDTO mapToDTO(Account account);

    @Mapping(target = "Account.id", constant = "null")
    public Account mapToEntity(BankProject.domain.entity.dto.AccountDTO accountDTO);
}
