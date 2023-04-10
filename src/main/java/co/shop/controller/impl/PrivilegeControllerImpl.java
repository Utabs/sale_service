package co.shop.controller.impl;

import co.shop.controller.PrivilegeController;
import co.shop.model.dto.PrivilegeDTO;
import co.shop.model.entity.user.Privilege;
import co.shop.model.mapper.PrivilegeMapper;
import co.shop.service.PrivilegeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/privilege")
@RestController
public class PrivilegeControllerImpl implements PrivilegeController {
    private final PrivilegeService privilegeService;
    private final PrivilegeMapper privilegeMapper;

    public PrivilegeControllerImpl(PrivilegeService privilegeService, PrivilegeMapper privilegeMapper) {
        this.privilegeService = privilegeService;
        this.privilegeMapper = privilegeMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PrivilegeDTO save(@RequestBody PrivilegeDTO privilegeDTO) {
        Privilege privilege = privilegeMapper.asEntity(privilegeDTO);
        return privilegeMapper.asDTO(privilegeService.save(privilege));
    }

    @Override
    @GetMapping("/{id}")
    public PrivilegeDTO findById(@PathVariable("id") Long id) {
        Privilege privilege = privilegeService.findById(id).orElse(null);
        return privilegeMapper.asDTO(privilege);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        privilegeService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<PrivilegeDTO> list() {
        return privilegeMapper.asDTOList(privilegeService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<PrivilegeDTO> pageQuery(Pageable pageable) {
        Page<Privilege> privilegePage = privilegeService.findAll(pageable);
        List<PrivilegeDTO> dtoList = privilegePage
                .stream()
                .map(privilegeMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, privilegePage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public PrivilegeDTO update(@RequestBody PrivilegeDTO privilegeDTO, @PathVariable("id") Long id) {
        Privilege privilege = privilegeMapper.asEntity(privilegeDTO);
        return privilegeMapper.asDTO(privilegeService.update(privilege, id));
    }
}
