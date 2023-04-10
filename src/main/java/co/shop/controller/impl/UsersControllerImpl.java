package co.shop.controller.impl;

import co.shop.controller.UsersController;
import co.shop.model.dto.UsersDTO;
import co.shop.model.mapper.UsersMapper;
import co.shop.service.UsersService;
import co.shop.model.entity.user.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/users")
@RestController
public class UsersControllerImpl implements UsersController {
    private final UsersService usersService;
    private final UsersMapper usersMapper;

    public UsersControllerImpl(UsersService usersService, UsersMapper usersMapper) {
        this.usersService = usersService;
        this.usersMapper = usersMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsersDTO save(@RequestBody UsersDTO usersDTO) {
        Users users = usersMapper.asEntity(usersDTO);
        return usersMapper.asDTO(usersService.save(users));
    }

    @Override
    @GetMapping("/{id}")
    public UsersDTO findById(@PathVariable("id") Long id) {
        Users users = usersService.findById(id).orElse(null);
        return usersMapper.asDTO(users);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        usersService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<UsersDTO> list() {
        return usersMapper.asDTOList(usersService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<UsersDTO> pageQuery(Pageable pageable) {
        Page<Users> usersPage = usersService.findAll(pageable);
        List<UsersDTO> dtoList = usersPage
                .stream()
                .map(usersMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, usersPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public UsersDTO update(@RequestBody UsersDTO usersDTO, @PathVariable("id") Long id) {
        Users users = usersMapper.asEntity(usersDTO);
        return usersMapper.asDTO(usersService.update(users, id));
    }
}
