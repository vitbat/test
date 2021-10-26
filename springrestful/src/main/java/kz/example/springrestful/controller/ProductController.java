package kz.example.springrestful.controller;

import kz.example.springrestful.entity.Product;
import kz.example.springrestful.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity addProduct(@RequestBody Product product){
        return new ResponseEntity(productService.addProduct(product), HttpStatus.OK);
    }

    @GetMapping("/description")
    public ResponseEntity getDescription(@RequestParam String description){
        return new ResponseEntity(productService.findByDescription(description),HttpStatus.OK);
    }

    @GetMapping("/byFilter")
    public ResponseEntity findByCategoryIdPriceDescription(@RequestParam int categoryId,
                                      @RequestParam int price,
                                      @RequestParam String description){
        return new ResponseEntity(productService.findByCategoryIdAndPriceAndDescription(
                categoryId, price, description), HttpStatus.OK);
    }

    @GetMapping("/productCurrentAction")
    public ResponseEntity getByProductsCurrentAction(@RequestParam Date checkDate){
        return new ResponseEntity(productService.findAllByProductsCurrentAction(checkDate), HttpStatus.OK);
    }
}
