package co.shop.service;

import co.shop.model.dto.OrderDTO;
import co.shop.model.entity.shop.Order;
import co.shop.model.entity.shop.OrderItem;

import java.util.List;
import java.util.Optional;

public interface OrderService extends GenericService<Order, Long> {
    Order save(OrderDTO orderDTO);
    Order update(Order entity, Long id);
    Order findOrder(long customerId, int status);
    Order addOrderItem(Long orderId, OrderItem item);

    Optional<List<Order>> getAllOrders(String username);
}
