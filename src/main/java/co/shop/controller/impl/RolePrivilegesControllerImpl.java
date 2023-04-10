package co.shop.controller.impl;

import co.shop.controller.RolePrivilegesController;
import co.shop.model.dto.RolePrivilegesDTO;
import co.shop.model.entity.user.RolePrivileges;
import co.shop.model.mapper.RolePrivilegesMapper;
import co.shop.service.RolePrivilegesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/role-privileges")
@RestController
public class RolePrivilegesControllerImpl implements RolePrivilegesController {
    private final RolePrivilegesService rolePrivilegesService;
    private final RolePrivilegesMapper rolePrivilegesMapper;

    public RolePrivilegesControllerImpl(RolePrivilegesService rolePrivilegesService, RolePrivilegesMapper rolePrivilegesMapper) {
        this.rolePrivilegesService = rolePrivilegesService;
        this.rolePrivilegesMapper = rolePrivilegesMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RolePrivilegesDTO save(@RequestBody RolePrivilegesDTO rolePrivilegesDTO) {
        RolePrivileges rolePrivileges = rolePrivilegesMapper.asEntity(rolePrivilegesDTO);
        return rolePrivilegesMapper.asDTO(rolePrivilegesService.save(rolePrivileges));
    }

    @Override
    @GetMapping("/{id}")
    public RolePrivilegesDTO findById(@PathVariable("id") Long id) {
        RolePrivileges rolePrivileges = rolePrivilegesService.findById(id).orElse(null);
        return rolePrivilegesMapper.asDTO(rolePrivileges);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        rolePrivilegesService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<RolePrivilegesDTO> list() {
        return rolePrivilegesMapper.asDTOList(rolePrivilegesService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<RolePrivilegesDTO> pageQuery(Pageable pageable) {
        Page<RolePrivileges> rolePrivilegesPage = rolePrivilegesService.findAll(pageable);
        List<RolePrivilegesDTO> dtoList = rolePrivilegesPage
                .stream()
                .map(rolePrivilegesMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, rolePrivilegesPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public RolePrivilegesDTO update(@RequestBody RolePrivilegesDTO rolePrivilegesDTO, @PathVariable("id") Long id) {
        RolePrivileges rolePrivileges = rolePrivilegesMapper.asEntity(rolePrivilegesDTO);
        return rolePrivilegesMapper.asDTO(rolePrivilegesService.update(rolePrivileges, id));
    }
}
