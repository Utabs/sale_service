package co.shop.service;

import co.shop.model.entity.product.Product;
import co.shop.model.entity.shop.Order;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
}
