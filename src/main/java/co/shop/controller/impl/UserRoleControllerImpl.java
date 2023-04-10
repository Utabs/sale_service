package co.shop.controller.impl;

import co.shop.controller.UserRoleController;
import co.shop.model.dto.UserRoleDTO;
import co.shop.model.entity.user.UserRole;
import co.shop.model.mapper.UserRoleMapper;
import co.shop.service.UserRoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/user-role")
@RestController
public class UserRoleControllerImpl implements UserRoleController {
    private final UserRoleService userRoleService;
    private final UserRoleMapper userRoleMapper;

    public UserRoleControllerImpl(UserRoleService userRoleService, UserRoleMapper userRoleMapper) {
        this.userRoleService = userRoleService;
        this.userRoleMapper = userRoleMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserRoleDTO save(@RequestBody UserRoleDTO userRoleDTO) {
        UserRole userRole = userRoleMapper.asEntity(userRoleDTO);
        return userRoleMapper.asDTO(userRoleService.save(userRole));
    }

    @Override
    @GetMapping("/{id}")
    public UserRoleDTO findById(@PathVariable("id") Long id) {
        UserRole userRole = userRoleService.findById(id).orElse(null);
        return userRoleMapper.asDTO(userRole);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        userRoleService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<UserRoleDTO> list() {
        return userRoleMapper.asDTOList(userRoleService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<UserRoleDTO> pageQuery(Pageable pageable) {
        Page<UserRole> userRolePage = userRoleService.findAll(pageable);
        List<UserRoleDTO> dtoList = userRolePage
                .stream()
                .map(userRoleMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, userRolePage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public UserRoleDTO update(@RequestBody UserRoleDTO userRoleDTO, @PathVariable("id") Long id) {
        UserRole userRole = userRoleMapper.asEntity(userRoleDTO);
        return userRoleMapper.asDTO(userRoleService.update(userRole, id));
    }
}
