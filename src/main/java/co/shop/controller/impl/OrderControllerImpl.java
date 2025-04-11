package co.shop.controller.impl;

import co.shop.controller.OrderController;
import co.shop.model.dto.OrderDTO;
import co.shop.model.dto.OrderItemDto;
import co.shop.model.entity.shop.OrderItem;
import co.shop.model.mapper.OrderItemMapper;
import co.shop.model.mapper.OrderMapper;
import co.shop.model.mapper.ProductMapper;
import co.shop.service.OrderService;
import co.shop.model.entity.shop.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@CrossOrigin(origins =  {"*.*","http://192.168.1.2:4200","http://localhost:4200","192.168.1.2:8080","http://192.168.137.147"})
@RequestMapping("/api/order")
@RestController
public class OrderControllerImpl implements OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;
    private final ProductMapper productMapper;
    private final OrderItemMapper orderItemMapper;

    public OrderControllerImpl(OrderService orderService, OrderMapper orderMapper, ProductMapper productMapper, OrderItemMapper orderItemMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
        this.productMapper = productMapper;
        this.orderItemMapper = orderItemMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO save(@RequestBody OrderDTO orderDTO) {
        return orderMapper.asDTO(orderService.save(orderDTO));
    }

    @Override
    @GetMapping("/{id}")
    public OrderDTO findById(@PathVariable("id") Long id) {
        Order order = orderService.findById(id).orElse(null);
        return orderMapper.asDTO(order);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        orderService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<OrderDTO> list() {
        return orderMapper.asDTOList(orderService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<OrderDTO> pageQuery(Pageable pageable) {
        Page<Order> orderPage = orderService.findAll(pageable);
        List<OrderDTO> dtoList = orderPage
                .stream()
                .map(orderMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, orderPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public OrderDTO update(@RequestBody OrderDTO orderDTO, @PathVariable("id") Long id) {
        Order order = orderMapper.asEntity(orderDTO);
        return orderMapper.asDTO(orderService.update(order, id));
    }

    @Override
    @GetMapping("/{customerId}/{status}")
    public OrderDTO findByCustomer(@PathVariable Long customerId,@PathVariable int status ) {
        return orderMapper.asDTO(orderService.findOrder(customerId,status));
    }

    @PostMapping("/{orderId}/items")
    public ResponseEntity<OrderDTO> addOrderItem(
            @PathVariable Long orderId,
            @RequestBody OrderItemDto orderItem
    ) {
        Order updatedOrder = orderService.addOrderItem(orderId, orderItemMapper.asEntity(orderItem));
        return ResponseEntity.ok(orderMapper.asDTO(updatedOrder));
    }


    @Override
    @GetMapping("/{userName}/orders")
    public List<OrderDTO> getAllOrders( @PathVariable String userName) {
        Optional<List<Order>> orderList = orderService.getAllOrders(userName);
        return  orderMapper.asDTOList(orderList.get());
    }
}
