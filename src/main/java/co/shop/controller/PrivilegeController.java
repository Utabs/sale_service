package co.shop.controller;

import co.shop.model.dto.PrivilegeDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Privilege API")
public interface PrivilegeController {
    @ApiOperation("Add new data")
    public PrivilegeDTO save(@RequestBody PrivilegeDTO privilege);

    @ApiOperation("Find by Id")
    public PrivilegeDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<PrivilegeDTO> list();

    @ApiOperation("Pagination request")
    public Page<PrivilegeDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public PrivilegeDTO update(@RequestBody PrivilegeDTO dto, @PathVariable("id") Long id);
}
