package BankProject.service.interfaces;

import BankProject.domain.entity.Client;

import java.util.List;

public interface ClientService {

    List<Client> findAll();

    Client getById(int id);

    void addClient(Client client);

    void deleteClient(Client client);

    void updateClient(Client client);


}
