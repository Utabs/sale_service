package co.shop.controller;

import co.shop.model.dto.BranchDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Branch API")
public interface BranchController {
    @ApiOperation("Add new data")
    BranchDTO save(@RequestBody BranchDTO branch);

    @ApiOperation("Find by Id")
    BranchDTO findById(@PathVariable("id") Integer id);

    @ApiOperation("Find by BranchCode")
    BranchDTO findByBranchCode(@PathVariable("code") Integer code);

    @ApiOperation("Delete based on primary key")
    void delete(@PathVariable("id") Integer id);

    @ApiOperation("Delete based on Branch Code")
    void deleteByCode(@PathVariable("code") Integer code);

    @ApiOperation("Find all data")
    List<BranchDTO> list();

    @ApiOperation("Pagination request")
    Page<BranchDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    BranchDTO update(@RequestBody BranchDTO dto, @PathVariable("id") Integer id);
}
