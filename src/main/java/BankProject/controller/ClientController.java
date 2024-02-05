package BankProject.controller;

import BankProject.domain.entity.Client;
import BankProject.domain.entity.dto.ClientDTO;
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
    public List<ClientDTO> getAll() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public ClientDTO getById(@PathVariable int id) {
        return clientService.getById(id);
    }

    @PostMapping("/new")
    public void addClient(@RequestBody ClientDTO client) {
        clientService.addClient(client);
    }

    @DeleteMapping("/delete")
    public void deleteClient(@RequestBody ClientDTO client) {
        clientService.deleteClient(client);
    }

}
