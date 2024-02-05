package BankProject.service.mapping;

import BankProject.domain.entity.User;
import BankProject.domain.entity.dto.UserDTO;
import ch.qos.logback.core.model.ComponentModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Mapper(componentModel = "spring")
public interface UserMappingService {

    @Mapping(target = "User.password", constant = "password is hidden")
    public UserDTO mapToDTO(User user);

    @Mapping(target = "User.password", expression = "java(String.valueOf(new BCryptPasswordEncoder().encode(userDTO.getPassword())))")
    @Mapping(target = "User.id", constant = "0")
    public User mapToEntity(UserDTO userDTO);



}
