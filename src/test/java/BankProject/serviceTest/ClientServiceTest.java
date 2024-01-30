package BankProject.serviceTest;

import BankProject.domain.entity.Client;
import BankProject.repository.ClientRepository;
import BankProject.service.ClientService;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;

    @Test
    public void testFindAll() {
        // Arrange
        List<Client> expectedClients = Arrays.asList(new Client(), new Client());
        when(clientRepository.findAll()).thenReturn(expectedClients);

        // Act
        List<Client> actualClients = clientService.findAll();

        // Assert
        assertEquals(expectedClients, actualClients);
        verify(clientRepository, times(1)).findAll();
    }

    @Test
    public void testGetById() {
        // Arrange
        int id = 1;
        Client expectedClient = new Client();
        when(clientRepository.findById(id)).thenReturn(Optional.of(expectedClient));

        // Act
        Client actualClient = clientService.getById(id);

        // Assert
        assertEquals(expectedClient, actualClient);
        verify(clientRepository, times(1)).findById(id);
    }

    @Test
    public void testAddClient() {
        // Arrange
        Client client = new Client();

        // Act
        clientService.addClient(client);

        // Assert
        verify(clientRepository, times(1)).save(client);
    }

    @Test
    public void testDeleteClient() {
        // Arrange
        Client client = new Client();

        // Act
        clientService.deleteClient(client);

        // Assert
        verify(clientRepository, times(1)).delete(client);
    }

    @Test
    public void testUpdateClient() {
        // Arrange
        Client client = new Client();

        // Act
        clientService.updateClient(client);

        // Assert
        verify(clientRepository, times(1)).saveAndFlush(client);
    }
}
