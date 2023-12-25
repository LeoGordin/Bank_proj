package BankProject.serviceTest;

import BankProject.domain.entity.jpa.JpaManager;
import BankProject.repository.ManagerRepository;
import BankProject.service.jpa.JpaManagerService;
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
public class JpaManagerServiceTest {

    @Mock
    private ManagerRepository managerRepository;

    @InjectMocks
    private JpaManagerService jpaManagerService;

    @Test
    public void testFindAll() {
        // Arrange
        List<JpaManager> expectedManagers = Arrays.asList(new JpaManager(), new JpaManager());
        when(managerRepository.findAll()).thenReturn(expectedManagers);

        // Act
        List<JpaManager> actualManagers = jpaManagerService.findAll();

        // Assert
        assertEquals(expectedManagers, actualManagers);
        verify(managerRepository, times(1)).findAll();
    }

    @Test
    public void testGetById() {
        // Arrange
        int managerId = 1;
        JpaManager expectedManager = new JpaManager();
        when(managerRepository.findById(managerId)).thenReturn(Optional.of(expectedManager));

        // Act
        JpaManager actualManager = jpaManagerService.getById(managerId);

        // Assert
        assertEquals(expectedManager, actualManager);
        verify(managerRepository, times(1)).findById(managerId);
    }

    @Test
    public void testAddManager() {
        // Arrange
        JpaManager manager = new JpaManager();

        // Act
        jpaManagerService.addManager(manager);

        // Assert
        verify(managerRepository, times(1)).save(manager);
    }

    @Test
    public void testUpdateManager() {
        // Arrange
        JpaManager manager = new JpaManager();

        // Act
        jpaManagerService.updateManager(manager);

        // Assert
        verify(managerRepository, times(1)).saveAndFlush(manager);
    }

    @Test
    public void testDeleteManager() {
        // Arrange
        JpaManager manager = new JpaManager();

        // Act
        jpaManagerService.deleteManager(manager);

        // Assert
        verify(managerRepository, times(1)).delete(manager);
    }
}