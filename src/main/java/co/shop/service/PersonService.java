package co.shop.service;

import co.shop.model.entity.user.Customer;

import java.util.Optional;

public interface PersonService extends GenericService<Customer, Long> {
    Optional<Customer> findByUserName(String userName);
}
