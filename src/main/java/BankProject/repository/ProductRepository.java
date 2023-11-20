package BankProject.repository;

import BankProject.domain.entity.jpa.JpaProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<JpaProduct, Integer> {
}
