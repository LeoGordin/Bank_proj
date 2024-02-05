package BankProject.service;

import BankProject.domain.entity.Role;
import BankProject.domain.entity.User;
import BankProject.domain.entity.dto.UserDTO;
import BankProject.repository.UserRepository;
import BankProject.service.mapping.UserMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    UserMappingService userMappingService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDetails user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    public List<UserDTO> findAll() {

        return userRepository.findAll()
                .stream()
                .map(userMappingService::mapToDTO)
                .collect(Collectors.toList());
    }

    public void save(User user) {

        UserDetails foundUser = userRepository.findByUsername(user.getUsername());

        if (foundUser != null) {
            return;
        }

        Set<Role> roles = new HashSet<>();
        roles.add(new Role(2, "ROLE_USER"));
        user.setRoles(roles);

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    }
}
