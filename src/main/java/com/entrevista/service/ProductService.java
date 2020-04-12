package com.entrevista.service;

import com.entrevista.model.Product;
import com.entrevista.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private LogService logService;

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    public Product saveProduct(Product product) {
        Product productCreated = null;
        try {
            productCreated = productRepository.save(product);
        } catch (Exception ex) {
            System.out.println("Erro ao salvar produto: " + ex);
            //logService.saveLog("Erro ao registrar produto [" + product.getDescription() + "] ");
            throw ex;
        }
        return productCreated;
    }
}
