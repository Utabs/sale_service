package co.shop.controller;

import co.shop.model.entity.product.Product;
import co.shop.model.entity.shop.Order;
import co.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://192.168.1.3:4200", maxAge = 3600)
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(productService.getProducts(),HttpStatus.OK);
    }


}
