package co.shop.controller.impl;

import co.shop.controller.OrderItemController;
import co.shop.model.dto.OrderItemDTO;
import co.shop.model.mapper.OrderItemMapper;
import co.shop.service.OrderItemService;
import co.shop.model.entity.shop.OrderItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/order-item")
@RestController
public class OrderItemControllerImpl implements OrderItemController {
    private final OrderItemService orderItemService;
    private final OrderItemMapper orderItemMapper;

    public OrderItemControllerImpl(OrderItemService orderItemService, OrderItemMapper orderItemMapper) {
        this.orderItemService = orderItemService;
        this.orderItemMapper = orderItemMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderItemDTO save(@RequestBody OrderItemDTO orderItemDTO) {
        OrderItem orderItem = orderItemMapper.asEntity(orderItemDTO);
        return orderItemMapper.asDTO(orderItemService.save(orderItem));
    }

    @Override
    @GetMapping("/{id}")
    public OrderItemDTO findById(@PathVariable("id") Long id) {
        OrderItem orderItem = orderItemService.findById(id).orElse(null);
        return orderItemMapper.asDTO(orderItem);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        orderItemService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<OrderItemDTO> list() {
        return orderItemMapper.asDTOList(orderItemService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<OrderItemDTO> pageQuery(Pageable pageable) {
        Page<OrderItem> orderItemPage = orderItemService.findAll(pageable);
        List<OrderItemDTO> dtoList = orderItemPage
                .stream()
                .map(orderItemMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, orderItemPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public OrderItemDTO update(@RequestBody OrderItemDTO orderItemDTO, @PathVariable("id") Long id) {
        OrderItem orderItem = orderItemMapper.asEntity(orderItemDTO);
        return orderItemMapper.asDTO(orderItemService.update(orderItem, id));
    }
}
