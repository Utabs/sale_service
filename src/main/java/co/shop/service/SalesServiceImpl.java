package co.shop.service;


import co.shop.model.entity.shop.Order;
import co.shop.repository.SalesHdrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesServiceImpl implements SalesService {

    @Autowired
    private SalesHdrRepository salesHdrRepository;


    @Override
    public Order registerSales(Order order) {
        return salesHdrRepository.save(order);
    }

    @Override
    public List<Order> getAllSalesByRegDate(int regDate) {
        return salesHdrRepository.findAllByRegDate(regDate);
    }

    @Override
    public Order getSaleHdrBillById(long headerBillId) {
        return salesHdrRepository.getById(headerBillId);
    }
}
