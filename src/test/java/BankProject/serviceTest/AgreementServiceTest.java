package BankProject.serviceTest;

import BankProject.domain.entity.Agreement;
import BankProject.domain.entity.Client;
import BankProject.repository.AgreementRepository;
import BankProject.service.AgreementService;
import org.junit.jupiter.api.Assertions;
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

public class AgreementServiceTest {
    @Mock
    private AgreementRepository agreementRepository;

    @InjectMocks
    private AgreementService agreementService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {
        // Arrange
        List<Agreement> expectedAgreements = new ArrayList<>();
        when(agreementRepository.findAll()).thenReturn(expectedAgreements);

        // Act
        List<Agreement> actualAgreements = agreementService.findAll();

        // Assert
        assertEquals(expectedAgreements, actualAgreements);
        verify(agreementRepository, times(1)).findAll();
    }

    @Test
    public void testGetByClientId() {
        // Arrange
        Client client = new Client();
        List<Agreement> expectedAgreements = new ArrayList<>();
        Agreement agreement = new Agreement();
        agreement.setClient(client);
        int clientId = client.getId();
        expectedAgreements.add(agreement);
        when(agreementRepository.findAll()).thenReturn(expectedAgreements);

        // Act
        List<Agreement> actualAgreements = agreementService.getByClientId(clientId);

        // Assert
        assertEquals(expectedAgreements, actualAgreements);
        verify(agreementRepository, times(1)).findAll();
    }

    @Test
    public void testGetById() {
        // Arrange
        Agreement expectedAgreement = new Agreement();
        UUID agreementId = UUID.randomUUID();
        expectedAgreement.setId(agreementId);
        List<Agreement> agreements = new ArrayList<>();
        agreements.add(expectedAgreement);
        when(agreementRepository.findAll()).thenReturn(agreements);

        // Act
        Agreement actualAgreement = agreementService.getById(agreementId);

        // Assert
        assertEquals(expectedAgreement, actualAgreement);
        verify(agreementRepository, times(1)).findAll();
    }

    @Test
    public void testRemoveById() {
        // Arrange
        Agreement agreement = new Agreement();
        UUID agreementId = UUID.randomUUID();
        agreement.setId(agreementId);
        List<Agreement> agreements = new ArrayList<>();
        agreements.add(agreement);
        when(agreementRepository.findAll()).thenReturn(agreements);

        // Act
        agreementService.removeById(agreementId);

        // Assert
        verify(agreementRepository, times(1)).delete(agreement);
        Assertions.assertNull(agreementService.getById(agreementId));
    }

    @Test
    public void testCreateAgreement() {

        // Arrange
        Agreement agreement = new Agreement();

        // Act
        agreementService.createAgreement(agreement);

        // Assert
        verify(agreementRepository, times(1)).save(agreement);
    }

    @Test
    public void testRemoveAgreement() {

        // Arrange
        Agreement agreement = new Agreement();

        // Act
        agreementService.removeAgreement(agreement);

        // Assert
        verify(agreementRepository, times(1)).delete(agreement);

    }

    @Test
    public void testUpdateAgreement() {

        // Arrange
        Agreement agreement = new Agreement();

        // Act
        agreementService.updateAgreement(agreement);

        // Assert
        verify(agreementRepository, times(1)).saveAndFlush(agreement);
    }

    // Add tests for other methods (removeById, createAgreement, removeAgreement, updateAgreement)
}