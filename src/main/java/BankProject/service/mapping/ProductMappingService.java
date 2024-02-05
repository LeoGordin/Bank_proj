package BankProject.service.mapping;

import BankProject.domain.entity.Product;
import BankProject.domain.entity.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMappingService {

    public ProductDTO mapToDTO(Product product);

    @Mapping(target = "Product.id", constant = "0")
    public Product mapToEntity(ProductDTO productDTO);
}
