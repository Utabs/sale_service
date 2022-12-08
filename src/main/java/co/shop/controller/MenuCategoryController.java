package co.shop.controller;

import co.shop.model.dto.MenuCategoryDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "MenuCategory API")
public interface MenuCategoryController {
    @ApiOperation("Add new data")
    MenuCategoryDTO save(@RequestBody MenuCategoryDTO menuCategory);

    @ApiOperation("Find by Id")
    MenuCategoryDTO findById(@PathVariable("id") Integer id);

    @ApiOperation("Delete based on primary key")
    void delete(@PathVariable("id") Integer id);

    @ApiOperation("Find all data")
    List<MenuCategoryDTO> list();

    @ApiOperation("Pagination request")
    Page<MenuCategoryDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    MenuCategoryDTO update(@RequestBody MenuCategoryDTO dto, @PathVariable("id") Integer id);
}
