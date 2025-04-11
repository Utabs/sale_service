package co.shop.service;


import co.shop.model.entity.shop.Order;
import co.shop.model.entity.user.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService extends GenericService<Customer, Long> {
    Optional<Customer> findByUserName(String userName);
}
