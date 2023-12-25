package BankProject.serviceTest;

import BankProject.domain.entity.jpa.JpaClient;
import BankProject.repository.ClientRepository;
import BankProject.service.jpa.JpaClientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class JpaClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private JpaClientService jpaClientService;

    @Test
    public void testFindAll() {
        // Arrange
        List<JpaClient> expectedClients = Arrays.asList(new JpaClient(), new JpaClient());
        when(clientRepository.findAll()).thenReturn(expectedClients);

        // Act
        List<JpaClient> actualClients = jpaClientService.findAll();

        // Assert
        assertEquals(expectedClients, actualClients);
        verify(clientRepository, times(1)).findAll();
    }

    @Test
    public void testGetById() {
        // Arrange
        int id = 1;
        JpaClient expectedClient = new JpaClient();
        when(clientRepository.findById(id)).thenReturn(Optional.of(expectedClient));

        // Act
        JpaClient actualClient = jpaClientService.getById(id);

        // Assert
        assertEquals(expectedClient, actualClient);
        verify(clientRepository, times(1)).findById(id);
    }

    @Test
    public void testAddClient() {
        // Arrange
        JpaClient client = new JpaClient();

        // Act
        jpaClientService.addClient(client);

        // Assert
        verify(clientRepository, times(1)).save(client);
    }

    @Test
    public void testDeleteClient() {
        // Arrange
        JpaClient client = new JpaClient();

        // Act
        jpaClientService.deleteClient(client);

        // Assert
        verify(clientRepository, times(1)).delete(client);
    }

    @Test
    public void testUpdateClient() {
        // Arrange
        JpaClient client = new JpaClient();

        // Act
        jpaClientService.updateClient(client);

        // Assert
        verify(clientRepository, times(1)).saveAndFlush(client);
    }
}
