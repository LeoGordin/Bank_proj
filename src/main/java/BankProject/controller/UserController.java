package BankProject.controller;


import BankProject.domain.entity.User;
import BankProject.domain.entity.dto.UserDTO;
import BankProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<UserDTO> findAll() {

        return userService.findAll();
    }

    @GetMapping("/username/{username}")
    public UserDetails getByUsername(@PathVariable String username) {

        return userService.loadUserByUsername(username);
    }

    @PostMapping("/add")
    public void addUser(@RequestBody User user) {

        userService.save(user);
        System.out.printf("User %s added", user.getUsername());
    }


}
