package co.shop.controller;

import co.shop.model.dto.OrderItemDto;
import co.shop.model.entity.shop.OrderItem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "OrderItem API")
public interface OrderItemController {
    @ApiOperation("Add new data")
    OrderItemDto save(@RequestBody OrderItemDto orderItem);

    @ApiOperation("Find by Id")
    OrderItemDto findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    OrderItemDto delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    List<OrderItemDto> list();

    @ApiOperation("Pagination request")
    Page<OrderItemDto> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    OrderItemDto update(@RequestBody OrderItemDto dto, @PathVariable("id") Long id);

}
