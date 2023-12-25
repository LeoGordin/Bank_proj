package BankProject.serviceTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import BankProject.domain.entity.jpa.JpaProduct;
import BankProject.repository.ProductRepository;
import BankProject.service.jpa.JpaProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class JpaProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private JpaProductService jpaProductService;

    @Test
    public void testFindAll() {
        // Arrange
        List<JpaProduct> expectedProducts = Arrays.asList(new JpaProduct(), new JpaProduct());
        when(productRepository.findAll()).thenReturn(expectedProducts);

        // Act
        List<JpaProduct> actualProducts = jpaProductService.findAll();

        // Assert
        assertEquals(expectedProducts, actualProducts);
        verify(productRepository, times(1)).findAll();
    }

    @Test
    public void testGetById() {
        // Arrange
        JpaProduct expectedProduct = new JpaProduct();
        int productId = 1;
        expectedProduct.setId(productId);
        when(productRepository.findById(productId)).thenReturn(Optional.of(expectedProduct));

        // Act
        JpaProduct actualProduct = jpaProductService.getById(productId);

        // Assert
        assertEquals(expectedProduct, actualProduct);
        verify(productRepository, times(1)).findById(productId);
    }

    @Test
    public void testAddProduct() {
        // Arrange
        JpaProduct product = new JpaProduct();

        // Act
        jpaProductService.addProduct(product);

        // Assert
        verify(productRepository, times(1)).save(product);
    }

    @Test
    public void testUpdateProduct() {
        // Arrange
        JpaProduct product = new JpaProduct();

        // Act
        jpaProductService.updateProduct(product);

        // Assert
        verify(productRepository, times(1)).saveAndFlush(product);
    }

    @Test
    public void testDeleteProduct() {
        // Arrange
        JpaProduct product = new JpaProduct();

        // Act
        jpaProductService.deleteProduct(product);

        // Assert
        verify(productRepository, times(1)).delete(product);
    }
}
