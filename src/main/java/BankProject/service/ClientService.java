package BankProject.service;

import BankProject.domain.entity.Client;
import BankProject.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements BankProject.service.interfaces.ClientService {

    @Autowired
    ClientRepository clientRepository;
    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client getById(int id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public void addClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }

    @Override
    public void updateClient(Client client) {
        clientRepository.saveAndFlush(client);
    }
}
