package BankProject.controller;

import BankProject.domain.entity.Product;
import BankProject.domain.entity.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    BankProject.service.ProductService ProductService;

    @GetMapping("/all")
    public List<ProductDTO> getAll(){
        return ProductService.findAll();
    }

    @GetMapping("/{id}")
    public ProductDTO getById(int id){
        return ProductService.getById(id);
    }

    @PostMapping
    public void addProduct(@RequestBody ProductDTO product){
        ProductService.addProduct(product);
    }

    @DeleteMapping
    public void deleteProduct(@RequestBody ProductDTO product){
        ProductService.deleteProduct(product);
    }

}
