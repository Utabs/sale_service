package co.shop.controller;

import co.shop.model.dto.UsersDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Users API")
public interface UsersController {
    @ApiOperation("Add new data")
    UsersDTO save(@RequestBody UsersDTO users);

    @ApiOperation("Find by Id")
    UsersDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    List<UsersDTO> list();

    @ApiOperation("Pagination request")
    Page<UsersDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    UsersDTO update(@RequestBody UsersDTO dto, @PathVariable("id") Long id);
}
