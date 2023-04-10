package co.shop.controller;

import co.shop.model.dto.PersonDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Person API")
public interface PersonController {
    @ApiOperation("Add new data")
    public PersonDTO save(@RequestBody PersonDTO person);

    @ApiOperation("Find by Id")
    public PersonDTO findById(@PathVariable("id") Long id);

//    @RequestMapping(method = RequestMethod.GET)
@GetMapping
    PersonDTO findByUserName(@RequestParam(value = "userName") String userName);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<PersonDTO> list();

    @ApiOperation("Pagination request")
    public Page<PersonDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public PersonDTO update(@RequestBody PersonDTO dto, @PathVariable("id") Long id);
}
