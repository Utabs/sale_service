package co.shop.repository;

import co.shop.model.entity.shop.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesHdrRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByRegDate(int regDate);
}
