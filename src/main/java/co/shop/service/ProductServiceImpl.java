package co.shop.service;

import co.shop.model.entity.product.Product;
import co.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productsRepository;

    @Override
    public List<Product> getProducts() {
        return productsRepository.findAll();
    }
}
