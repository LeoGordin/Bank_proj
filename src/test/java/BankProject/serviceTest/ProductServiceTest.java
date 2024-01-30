package BankProject.serviceTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import BankProject.domain.entity.Product;
import BankProject.repository.ProductRepository;
import BankProject.service.ProductService;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    public void testFindAll() {
        // Arrange
        List<Product> expectedProducts = Arrays.asList(new Product(), new Product());
        when(productRepository.findAll()).thenReturn(expectedProducts);

        // Act
        List<Product> actualProducts = productService.findAll();

        // Assert
        assertEquals(expectedProducts, actualProducts);
        verify(productRepository, times(1)).findAll();
    }

    @Test
    public void testGetById() {
        // Arrange
        Product expectedProduct = new Product();
        int productId = 1;
        expectedProduct.setId(productId);
        when(productRepository.findById(productId)).thenReturn(Optional.of(expectedProduct));

        // Act
        Product actualProduct = productService.getById(productId);

        // Assert
        assertEquals(expectedProduct, actualProduct);
        verify(productRepository, times(1)).findById(productId);
    }

    @Test
    public void testAddProduct() {
        // Arrange
        Product product = new Product();

        // Act
        productService.addProduct(product);

        // Assert
        verify(productRepository, times(1)).save(product);
    }

    @Test
    public void testUpdateProduct() {
        // Arrange
        Product product = new Product();

        // Act
        productService.updateProduct(product);

        // Assert
        verify(productRepository, times(1)).saveAndFlush(product);
    }

    @Test
    public void testDeleteProduct() {
        // Arrange
        Product product = new Product();

        // Act
        productService.deleteProduct(product);

        // Assert
        verify(productRepository, times(1)).delete(product);
    }
}
