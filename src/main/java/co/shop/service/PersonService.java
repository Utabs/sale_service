package co.shop.service;

import co.shop.model.entity.user.Person;

import java.util.Optional;

public interface PersonService extends GenericService<Person, Long> {
    Optional<Person> findByUserName(String userName);
}
