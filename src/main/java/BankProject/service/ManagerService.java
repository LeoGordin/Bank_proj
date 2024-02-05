package BankProject.service;

import BankProject.domain.entity.dto.ManagerDTO;
import BankProject.repository.ManagerRepository;
import BankProject.service.interfaces.ManagerServiceInterface;
import BankProject.service.mapping.ManagerMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManagerService implements ManagerServiceInterface {

    @Autowired
    ManagerRepository managerRepository;

    @Autowired
    ManagerMappingService managerMappingService;

    @Override
    public List<ManagerDTO> findAll() {
        return managerRepository.findAll()
                .stream()
                .map(managerMappingService::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ManagerDTO getById(int id) {
        return managerMappingService
                .mapToDTO(managerRepository.findById(id)
                        .isPresent() ? managerRepository.findById(id).get() : null);
    }

    @Override
    public void addManager(ManagerDTO manager) {
        managerRepository.save(managerMappingService.mapToEntity(manager));
    }
    @Override
    public void deleteManager(ManagerDTO manager) {
        managerRepository.delete(managerMappingService.mapToEntity(manager));
    }
}
