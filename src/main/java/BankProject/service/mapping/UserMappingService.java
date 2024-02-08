package BankProject.service.mapping;

import BankProject.domain.entity.User;
import BankProject.domain.entity.dto.UserDTO;
import ch.qos.logback.core.model.ComponentModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Mapper(componentModel = "spring")
public interface UserMappingService {

    public UserDTO mapToDTO(User user);

    public User mapToEntity(UserDTO userDTO);

}
