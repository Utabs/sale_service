package co.shop.service;

import co.shop.model.entity.shop.Order;

public interface OrderService extends GenericService<Order, Long> {
    Order update(Order entity, Long id);
}
