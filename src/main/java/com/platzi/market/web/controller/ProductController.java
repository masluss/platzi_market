package com.platzi.market.web.controller;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController  //Clase controlador de una API Rest
@RequestMapping("/products") //en products va a recibir las peticiones
public class ProductController {
    //Vamos a inyectar el servicio porque en ProductService esta @Service que pertenece a Spring
    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{productId}")
    public Optional<Product> getProduct(@PathVariable("productId") int productId){
        return productService.getProduct(productId);
    }

    @GetMapping("/category/{categoryId}")
    public Optional<List<Product>> getByCategory(@PathVariable("categoryId")int categoryId){
        return productService.getByCategory(categoryId);
    }

    @PostMapping()
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable ("id") int productId){
        return productService.delete(productId);
    }
}
