package co.shop.controller;

import co.shop.model.dto.PaymentDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Payment API")
public interface PaymentController {
    @ApiOperation("Add new data")
    PaymentDTO save(@RequestBody PaymentDTO payment);

    @ApiOperation("Find by Id")
    PaymentDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    List<PaymentDTO> list();

    @ApiOperation("Pagination request")
    Page<PaymentDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    PaymentDTO update(@RequestBody PaymentDTO dto, @PathVariable("id") Long id);
}
