package co.shop.controller;

import co.shop.model.dto.OrderItemDTO;
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
    OrderItemDTO save(@RequestBody OrderItemDTO orderItem);

    @ApiOperation("Find by Id")
    OrderItemDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    List<OrderItemDTO> list();

    @ApiOperation("Pagination request")
    Page<OrderItemDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    OrderItemDTO update(@RequestBody OrderItemDTO dto, @PathVariable("id") Long id);
}
