package kz.example.springrestful.service;

import kz.example.springrestful.entity.Product;
import kz.example.springrestful.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product addProduct(Product product){
        product = productRepo.save(product);
        return product;
    }

    public Product findByDescription(String description){
        Product product = productRepo.findByDescription(description);
        return product;
    }

    public Product findByCategoryIdAndPriceAndDescription(int categoryId, int price, String description){
        Product product = productRepo.findByCategoryIdAndPriceAndDescription(categoryId,price,description);
        return product;
    }

    public synchronized Product findAllByProductsCurrentAction(Date checkDate){
        return productRepo.findAllByProductsCurrentAction(checkDate);
    }
}
