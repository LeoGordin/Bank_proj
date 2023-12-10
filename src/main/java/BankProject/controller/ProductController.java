package BankProject.controller;

import BankProject.domain.entity.jpa.JpaProduct;
import BankProject.service.jpa.JpaProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    JpaProductService ProductService;

    @GetMapping
    public List<JpaProduct> getAll(){
        return ProductService.findAll();
    }

    @GetMapping("/{id}")
    public JpaProduct getById(int id){
        return ProductService.getById(id);
    }

    @PostMapping
    public void addProduct(@RequestBody JpaProduct product){
        ProductService.addProduct(product);
    }

    @PutMapping
    public void updateProduct(@RequestBody JpaProduct product){
        ProductService.updateProduct(product);
    }

    @DeleteMapping
    public void deleteProduct(@RequestBody JpaProduct product){
        ProductService.deleteProduct(product);
    }

}
