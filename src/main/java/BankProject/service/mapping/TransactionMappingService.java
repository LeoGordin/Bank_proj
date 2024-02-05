package BankProject.service.mapping;

import BankProject.domain.entity.Transaction;
import BankProject.domain.entity.dto.TransactionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransactionMappingService {

    public TransactionDTO mapToDTO(Transaction transaction);

    @Mapping(target = "Transaction.id", constant = "null")
    public Transaction mapToEntity(TransactionDTO transactionDTO);
}
