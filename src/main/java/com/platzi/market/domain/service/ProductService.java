package com.platzi.market.domain.service;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Esta clase es un intermediario entre el controlador y la capa del repositorio

//Service= Intermediario entre el controlador de la API y el repositorio
@Service  //Servicio de nuestra lógica de negocios
public class ProductService {
    @Autowired
    private ProductRepository productRepository; //dirige a la interfaz

    //escribir métodos

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    /*
    //FORMA 1 PARA EL DELETE
    public boolean delete(int productId){
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }
     */

    //FORMA 2 PARA EL DELETE
    public boolean delete(int productId){
        if(getProduct(productId).isPresent()){
            productRepository.delete(productId);
            return true;
        }else{
            return false;
        }
    }

}
