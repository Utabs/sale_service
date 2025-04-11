package co.shop.controller.impl;

import co.shop.controller.OrderItemController;
import co.shop.model.dto.OrderItemDto;
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


@CrossOrigin(origins =  {"*.*","http://192.168.1.2:4200","http://localhost:4200","192.168.1.2:8080","http://192.168.137.147"})
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
    public OrderItemDto save(@RequestBody OrderItemDto orderItemDTO) {
        OrderItem orderItem = orderItemMapper.asEntity(orderItemDTO);
        return orderItemMapper.asDTO(orderItemService.save(orderItem));
    }

    @Override
    @GetMapping("/{id}")
    public OrderItemDto findById(@PathVariable("id") Long id) {
        OrderItem orderItem = orderItemService.findById(id).orElse(null);
        return orderItemMapper.asDTO(orderItem);
    }

    @Override
    @DeleteMapping("/{id}")
    public OrderItemDto delete(@PathVariable("id") Long id) {
        OrderItem orderItem =  orderItemService.deleteByIdData(id);
        return orderItemMapper.asDTO(orderItem);
    }

    @Override
    @GetMapping
    public List<OrderItemDto> list() {
        return orderItemMapper.asDTOList(orderItemService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<OrderItemDto> pageQuery(Pageable pageable) {
        Page<OrderItem> orderItemPage = orderItemService.findAll(pageable);
        List<OrderItemDto> dtoList = orderItemPage
                .stream()
                .map(orderItemMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, orderItemPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public OrderItemDto update(@RequestBody OrderItemDto orderItemDTO, @PathVariable("id") Long id) {
        OrderItem orderItem = orderItemMapper.asEntity(orderItemDTO);
        return orderItemMapper.asDTO(orderItemService.update(orderItem, id));
    }
}
