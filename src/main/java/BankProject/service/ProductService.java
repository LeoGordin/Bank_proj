package BankProject.service;

import BankProject.domain.entity.Product;
import BankProject.domain.entity.dto.ProductDTO;
import BankProject.repository.ProductRepository;
import BankProject.service.mapping.ProductMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements BankProject.service.interfaces.ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMappingService productMappingService;


    @Override
    public List<ProductDTO> findAll() {
        return productRepository.findAll()
                .stream()
                .map(productMappingService::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getById(int id) {
        return productRepository.findById(id)
                .isPresent()
                ? productMappingService.mapToDTO(productRepository.findById(id).get())
                : null;
    }

    @Override
    public void addProduct(ProductDTO product) {
        productRepository.save(productMappingService.mapToEntity(product));
    }


    @Override
    public void deleteProduct(ProductDTO product) {

        productRepository.delete(productMappingService.mapToEntity(product));
    }
}
