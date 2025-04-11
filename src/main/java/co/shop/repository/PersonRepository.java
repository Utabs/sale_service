package co.shop.repository;

import co.shop.model.entity.user.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Customer, Long> {

//    @Query("select a from Person a where a.userName = :username")
    Optional<Customer> findByUserName(String userName);
}
