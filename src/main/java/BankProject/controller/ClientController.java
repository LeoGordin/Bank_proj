package BankProject.controller;

import BankProject.domain.entity.jpa.JpaClient;
import BankProject.service.jpa.JpaClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    JpaClientService clientService;

    @GetMapping
    public List<JpaClient> getAll() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public JpaClient getById(@PathVariable int id) {
        return clientService.getById(id);
    }

    @PostMapping
    public void addClient(@RequestBody JpaClient client) {
        clientService.addClient(client);
    }

    @DeleteMapping
    public void deleteClient(@RequestBody JpaClient client) {
        clientService.deleteClient(client);
    }

    @PutMapping
    public void updateClient(@RequestBody JpaClient client) {
        clientService.updateClient(client);
    }
}
