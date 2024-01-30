package BankProject.controller;

import BankProject.domain.entity.Client;
import BankProject.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/all")
    public List<Client> getAll() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public Client getById(@PathVariable int id) {
        return clientService.getById(id);
    }

    @PostMapping("/new")
    public void addClient(@RequestBody Client client) {
        clientService.addClient(client);
    }

    @DeleteMapping("/delete")
    public void deleteClient(@RequestBody Client client) {
        clientService.deleteClient(client);
    }

    @PutMapping("/update")
    public void updateClient(@RequestBody Client client) {
        clientService.updateClient(client);
    }
}
