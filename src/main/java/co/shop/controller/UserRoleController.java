package co.shop.controller;

import co.shop.model.dto.UserRoleDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "UserRole API")
public interface UserRoleController {
    @ApiOperation("Add new data")
    public UserRoleDTO save(@RequestBody UserRoleDTO userRole);

    @ApiOperation("Find by Id")
    public UserRoleDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<UserRoleDTO> list();

    @ApiOperation("Pagination request")
    public Page<UserRoleDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public UserRoleDTO update(@RequestBody UserRoleDTO dto, @PathVariable("id") Long id);
}
