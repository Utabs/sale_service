package co.shop.controller;

import co.shop.model.dto.BranchDTO;
import co.shop.model.entity.Branch;
import co.shop.model.mapper.BranchMapper;
import co.shop.service.BranchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/branch")
@RestController
public class BranchControllerImpl implements BranchController {
    private final BranchService branchService;
    private final BranchMapper branchMapper;

    public BranchControllerImpl(BranchService branchService, BranchMapper branchMapper) {
        this.branchService = branchService;
        this.branchMapper = branchMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BranchDTO save(@RequestBody BranchDTO branchDTO) {
        Branch branch = branchMapper.asEntity(branchDTO);
        return branchMapper.asDTO(branchService.save(branch));
    }

    @Override
    @GetMapping("/{id}")
    public BranchDTO findById(@PathVariable("id") Integer id) {
        Branch branch = branchService.findById(id).orElse(null);
        return branchMapper.asDTO(branch);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        branchService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<BranchDTO> list() {
        return branchMapper.asDTOList(branchService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<BranchDTO> pageQuery(Pageable pageable) {
        Page<Branch> branchPage = branchService.findAll(pageable);
        List<BranchDTO> dtoList = branchPage
                .stream()
                .map(branchMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, branchPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public BranchDTO update(@RequestBody BranchDTO branchDTO, @PathVariable("id") Integer id) {
        Branch branch = branchMapper.asEntity(branchDTO);
        return branchMapper.asDTO(branchService.update(branch, id));
    }
}
