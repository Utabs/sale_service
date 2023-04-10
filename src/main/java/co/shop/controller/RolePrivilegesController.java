package co.shop.controller;

import co.shop.model.dto.RolePrivilegesDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "RolePrivileges API")
public interface RolePrivilegesController {
    @ApiOperation("Add new data")
    public RolePrivilegesDTO save(@RequestBody RolePrivilegesDTO rolePrivileges);

    @ApiOperation("Find by Id")
    public RolePrivilegesDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<RolePrivilegesDTO> list();

    @ApiOperation("Pagination request")
    public Page<RolePrivilegesDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public RolePrivilegesDTO update(@RequestBody RolePrivilegesDTO dto, @PathVariable("id") Long id);
}
