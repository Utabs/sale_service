package co.shop.controller;

import co.shop.model.dto.RoleDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Role API")
public interface RoleController {
    @ApiOperation("Add new data")
    public RoleDTO save(@RequestBody RoleDTO role);

    @ApiOperation("Find by Id")
    public RoleDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<RoleDTO> list();

    @ApiOperation("Pagination request")
    public Page<RoleDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public RoleDTO update(@RequestBody RoleDTO dto, @PathVariable("id") Long id);
}
