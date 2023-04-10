package co.shop.controller.impl;

import co.shop.controller.RoleController;
import co.shop.model.dto.RoleDTO;
import co.shop.model.entity.user.Role;
import co.shop.model.mapper.RoleMapper;
import co.shop.service.RoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/role")
@RestController
public class RoleControllerImpl implements RoleController {
    private final RoleService roleService;
    private final RoleMapper roleMapper;

    public RoleControllerImpl(RoleService roleService, RoleMapper roleMapper) {
        this.roleService = roleService;
        this.roleMapper = roleMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoleDTO save(@RequestBody RoleDTO roleDTO) {
        Role role = roleMapper.asEntity(roleDTO);
        return roleMapper.asDTO(roleService.save(role));
    }

    @Override
    @GetMapping("/{id}")
    public RoleDTO findById(@PathVariable("id") Long id) {
        Role role = roleService.findById(id).orElse(null);
        return roleMapper.asDTO(role);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        roleService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<RoleDTO> list() {
        return roleMapper.asDTOList(roleService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<RoleDTO> pageQuery(Pageable pageable) {
        Page<Role> rolePage = roleService.findAll(pageable);
        List<RoleDTO> dtoList = rolePage
                .stream()
                .map(roleMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, rolePage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public RoleDTO update(@RequestBody RoleDTO roleDTO, @PathVariable("id") Long id) {
        Role role = roleMapper.asEntity(roleDTO);
        return roleMapper.asDTO(roleService.update(role, id));
    }
}
