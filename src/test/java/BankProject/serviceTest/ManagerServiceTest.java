package BankProject.serviceTest;

import BankProject.domain.entity.Manager;
import BankProject.repository.ManagerRepository;
import BankProject.service.ManagerService;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ManagerServiceTest {

    @Mock
    private ManagerRepository managerRepository;

    @InjectMocks
    private ManagerService managerService;

    @Test
    public void testFindAll() {
        // Arrange
        List<Manager> expectedManagers = Arrays.asList(new Manager(), new Manager());
        when(managerRepository.findAll()).thenReturn(expectedManagers);

        // Act
        List<Manager> actualManagers = managerService.findAll();

        // Assert
        assertEquals(expectedManagers, actualManagers);
        verify(managerRepository, times(1)).findAll();
    }

    @Test
    public void testGetById() {
        // Arrange
        int managerId = 1;
        Manager expectedManager = new Manager();
        when(managerRepository.findById(managerId)).thenReturn(Optional.of(expectedManager));

        // Act
        Manager actualManager = managerService.getById(managerId);

        // Assert
        assertEquals(expectedManager, actualManager);
        verify(managerRepository, times(1)).findById(managerId);
    }

    @Test
    public void testAddManager() {
        // Arrange
        Manager manager = new Manager();

        // Act
        managerService.addManager(manager);

        // Assert
        verify(managerRepository, times(1)).save(manager);
    }

    @Test
    public void testUpdateManager() {
        // Arrange
        Manager manager = new Manager();

        // Act
        managerService.updateManager(manager);

        // Assert
        verify(managerRepository, times(1)).saveAndFlush(manager);
    }

    @Test
    public void testDeleteManager() {
        // Arrange
        Manager manager = new Manager();

        // Act
        managerService.deleteManager(manager);

        // Assert
        verify(managerRepository, times(1)).delete(manager);
    }
}