package BankProject.service.interfaces;

import BankProject.domain.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product getById(int id);

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Product product);
}
