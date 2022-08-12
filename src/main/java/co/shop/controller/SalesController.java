package co.shop.controller;

import co.shop.model.entity.shop.OrderItem;
import co.shop.model.entity.shop.Order;
import co.shop.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @GetMapping
    ResponseEntity<Order> getAllSales() {
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping(value = "/{regDate}")
    public ResponseEntity findAllSales(@PathVariable int regDate) {
        List<Order> orders = salesService.getAllSalesByRegDate(regDate);
        return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity registerSales(@RequestBody Order order) {
//        SalesHead salesHead1 = new SalesHead();
//        salesHead1.setCodeNum(salesHead.getCodeNum());
//        salesHead1.setRegUser(salesHead.getRegUser());
//        salesHead1.addDetail(salesHead.getSalesDetails().get(0));
        return new ResponseEntity<Order>(salesService.registerSales(order), HttpStatus.OK);
    }


    @PostMapping(value = "/{headerBillId}")
    public ResponseEntity registerSalesDetail(@PathVariable long headerBillId, @RequestBody OrderItem orderItem) {
        Order order = salesService.getSaleHdrBillById(headerBillId);
        order.addDetail(orderItem);
        return new ResponseEntity<Order>(salesService.registerSales(order), HttpStatus.OK);
    }

    @PutMapping(value = "/{detailId}")
    public ResponseEntity updateSalesDetail(@PathVariable long detailId, @RequestBody OrderItem orderItem) {
        Order order =  salesService.getSaleHdrBillById(detailId);
        order.addDetail(orderItem);
        return new ResponseEntity<Order>(salesService.registerSales(order), HttpStatus.OK);
    }



}
