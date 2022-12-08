package co.shop.controller;

import co.shop.model.dto.MenuDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Menu API")
public interface MenuController {
    @ApiOperation("Add new data")
    MenuDTO save(@RequestBody MenuDTO menu);

    @ApiOperation("Find by Id")
    MenuDTO findById(@PathVariable("id") Integer id);

    @ApiOperation("Delete based on primary key")
    void delete(@PathVariable("id") Integer id);

    @ApiOperation("Find all data")
    List<MenuDTO> list();

    @ApiOperation("Pagination request")
    Page<MenuDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    MenuDTO update(@RequestBody MenuDTO dto, @PathVariable("id") Integer id);
}
