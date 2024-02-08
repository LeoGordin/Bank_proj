package BankProject.service.interfaces;

import BankProject.domain.entity.dto.ProductDTO;

import java.util.List;

public interface ProductServiceInterface {

    List<ProductDTO> findAll();

    ProductDTO getById(int id);

    void addProduct(ProductDTO product);

    void deleteProduct(ProductDTO product);

    void deleteProductById(int id);

//    void updateProduct(
//            int id,
//            Manager manager,
//            Account account,
//            String name,
//            ProductStatus status,
//            Currency currency,
//            BigDecimal interestRate,
//            BigDecimal limit,
//            Timestamp createdAt,
//            Timestamp updatedAt
//    );
}
