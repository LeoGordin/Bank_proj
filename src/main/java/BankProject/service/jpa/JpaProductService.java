package BankProject.service.jpa;

import BankProject.domain.entity.jpa.JpaProduct;
import BankProject.repository.ProductRepository;
import BankProject.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaProductService implements ProductService {

    @Autowired
    ProductRepository productRepository;


    @Override
    public List<JpaProduct> findAll() {
        return productRepository.findAll();
    }

    @Override
    public JpaProduct getById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void addProduct(JpaProduct product) {
        productRepository.save(product);
    }

    @Override
    public void updateProduct(JpaProduct product) {
        productRepository.saveAndFlush(product);
    }

    @Override
    public void deleteProduct(JpaProduct product) {
        productRepository.delete(product);
    }
}
