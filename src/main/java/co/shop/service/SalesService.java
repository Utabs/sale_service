package co.shop.service;


import co.shop.model.entity.shop.Order;

import java.util.List;

public interface SalesService {
    Order registerSales(Order order);

    List<Order> getAllSalesByRegDate(int regDate);

    Order getSaleHdrBillById(long headerBillId);
}
