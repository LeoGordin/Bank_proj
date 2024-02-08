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

    @PostMapping("/add")
    public void addProduct(@RequestBody ProductDTO product){
        ProductService.addProduct(product);
    }

    @DeleteMapping("/delete")
    public void deleteProduct(@RequestBody ProductDTO product){
        ProductService.deleteProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProductById(@PathVariable int id){
        ProductService.deleteProductById(id);
    }



}
