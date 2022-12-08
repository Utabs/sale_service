package co.shop.controller;

import co.shop.model.dto.OrderDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Order API")
public interface OrderController {
    @ApiOperation("Add new data")
    OrderDTO save(@RequestBody OrderDTO order);

    @ApiOperation("Find by Id")
    OrderDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    List<OrderDTO> list();

    @ApiOperation("Pagination request")
    Page<OrderDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    OrderDTO update(@RequestBody OrderDTO dto, @PathVariable("id") Long id);
}
