package co.shop.controller;

import co.shop.model.dto.CustomerDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Customer API")
@Component
public interface CustomerController {
    @ApiOperation("Add new data")
    CustomerDTO save(@RequestBody CustomerDTO customer);

    @ApiOperation("Find by Id")
    CustomerDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    List<CustomerDTO> list();

    @ApiOperation("Pagination request")
    Page<CustomerDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    CustomerDTO update(@RequestBody CustomerDTO dto, @PathVariable("id") Long id);
}
