package BankProject.service.interfaces;

import BankProject.domain.entity.interfaces.Account;
import BankProject.domain.entity.interfaces.Agreement;
import BankProject.domain.entity.interfaces.Client;
import BankProject.domain.entity.interfaces.Product;
import BankProject.domain.entity.jpa.JpaClient;

import java.util.List;
import java.util.UUID;

public interface ClientService {

    List<JpaClient> findAll();

    JpaClient getById(int id);

    void addClient(JpaClient client);

    void deleteClient(JpaClient client);

    void updateClient(JpaClient client);


}
