package co.shop.repository;

import co.shop.model.entity.shop.Order;
import co.shop.model.entity.user.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository <Order, Long> {

    Optional<Order> findByCustomerAndStatus(Customer customer, Integer status);
    Optional<List<Order>> findAllByCustomerId(Long customerId);

}
