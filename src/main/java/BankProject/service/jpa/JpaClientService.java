package BankProject.service.jpa;

import BankProject.domain.entity.jpa.JpaClient;
import BankProject.repository.ClientRepository;
import BankProject.service.interfaces.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaClientService implements ClientService {

    @Autowired
    ClientRepository clientRepository;
    @Override
    public List<JpaClient> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public JpaClient getById(int id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public void addClient(JpaClient client) {
        clientRepository.save(client);
    }

    @Override
    public void deleteClient(JpaClient client) {
        clientRepository.delete(client);
    }

    @Override
    public void updateClient(JpaClient client) {
        clientRepository.saveAndFlush(client);
    }
}
