package co.shop.repository;

import co.shop.model.entity.shop.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesDtlRepository extends JpaRepository<OrderItem, Long> {
}
