package BankProject.controller;

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

    @PostMapping("/save")
    public void saveClient(@RequestBody ClientDTO client) {
        clientService.saveClient(client);
    }

    @DeleteMapping("/delete")
    public void deleteClient(@RequestBody ClientDTO client) {
        clientService.deleteClient(client);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClientById(@PathVariable int id) {
        clientService.deleteClientById(id);
    }

}
