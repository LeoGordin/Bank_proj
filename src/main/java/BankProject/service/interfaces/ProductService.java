package BankProject.service.interfaces;

import BankProject.domain.entity.interfaces.Product;
import BankProject.domain.entity.jpa.JpaProduct;

import java.util.List;

public interface ProductService {

    List<JpaProduct> getAll();

    JpaProduct getById(int id);

    void addProduct(JpaProduct product);

    void updateProduct(JpaProduct product);

    void deleteProduct(JpaProduct product);
}
