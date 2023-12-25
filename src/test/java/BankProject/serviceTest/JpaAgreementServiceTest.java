package BankProject.serviceTest;

import BankProject.domain.entity.jpa.JpaAgreement;
import BankProject.domain.entity.jpa.JpaClient;
import BankProject.repository.AgreementRepository;
import BankProject.repository.ClientRepository;
import BankProject.service.jpa.JpaAgreementService;
import BankProject.service.jpa.JpaClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class JpaAgreementServiceTest {
    @Mock
    private AgreementRepository agreementRepository;

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private JpaAgreementService agreementService;

    @InjectMocks
    private JpaClientService clientService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {
        // Arrange
        List<JpaAgreement> expectedAgreements = new ArrayList<>();
        when(agreementRepository.findAll()).thenReturn(expectedAgreements);

        // Act
        List<JpaAgreement> actualAgreements = agreementService.findAll();

        // Assert
        assertEquals(expectedAgreements, actualAgreements);
        verify(agreementRepository, times(1)).findAll();
    }

    @Test
    public void testGetByClientId() {
        // Arrange
        JpaClient client = new JpaClient();
        List<JpaAgreement> expectedAgreements = new ArrayList<>();
        JpaAgreement agreement = new JpaAgreement();
        agreement.setClient(client);
        int clientId = client.getId();
        expectedAgreements.add(agreement);
        when(agreementRepository.findAll()).thenReturn(expectedAgreements);

        // Act
        List<JpaAgreement> actualAgreements = agreementService.getByClientId(clientId);

        // Assert
        assertEquals(expectedAgreements, actualAgreements);
        verify(agreementRepository, times(1)).findAll();
    }

    @Test
    public void testGetById() {
        // Arrange
        JpaAgreement expectedAgreement = new JpaAgreement();
        UUID agreementId = UUID.randomUUID();
        expectedAgreement.setId(agreementId);
        List<JpaAgreement> agreements = new ArrayList<>();
        agreements.add(expectedAgreement);
        when(agreementRepository.findAll()).thenReturn(agreements);

        // Act
        JpaAgreement actualAgreement = agreementService.getById(agreementId);

        // Assert
        assertEquals(expectedAgreement, actualAgreement);
        verify(agreementRepository, times(1)).findAll();
    }

    @Test
    public void testRemoveById() {
        // Arrange
        JpaAgreement agreement = new JpaAgreement();
        UUID agreementId = UUID.randomUUID();
        agreement.setId(agreementId);
        List<JpaAgreement> agreements = new ArrayList<>();
        agreements.add(agreement);
        when(agreementRepository.findAll()).thenReturn(agreements);

        // Act
        agreementService.removeById(agreementId);

        // Assert
        verify(agreementRepository, times(1)).delete(agreement);
    }

    @Test
    public void testCreateAgreement() {

        // Arrange
        JpaAgreement agreement = new JpaAgreement();

        // Act
        agreementService.createAgreement(agreement);

        // Assert
        verify(agreementRepository, times(1)).save(agreement);
    }

    @Test
    public void testRemoveAgreement() {

        // Arrange
        JpaAgreement agreement = new JpaAgreement();

        // Act
        agreementService.removeAgreement(agreement);

        // Assert
        verify(agreementRepository, times(1)).delete(agreement);

    }

    @Test
    public void testUpdateAgreement() {

        // Arrange
        JpaAgreement agreement = new JpaAgreement();

        // Act
        agreementService.updateAgreement(agreement);

        // Assert
        verify(agreementRepository, times(1)).saveAndFlush(agreement);
    }

    // Add tests for other methods (removeById, createAgreement, removeAgreement, updateAgreement)
}