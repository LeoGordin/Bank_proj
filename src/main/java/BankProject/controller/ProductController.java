package BankProject.controller;

import BankProject.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    BankProject.service.ProductService ProductService;

    @GetMapping("/all")
    public List<Product> getAll(){
        return ProductService.findAll();
    }

    @GetMapping("/{id}")
    public Product getById(int id){
        return ProductService.getById(id);
    }

    @PostMapping("/new")
    public void addProduct(@RequestBody Product product){
        ProductService.addProduct(product);
    }

    @PutMapping("/update")
    public void updateProduct(@RequestBody Product product){
        ProductService.updateProduct(product);
    }

    @DeleteMapping("/delete")
    public void deleteProduct(@RequestBody Product product){
        ProductService.deleteProduct(product);
    }

}
