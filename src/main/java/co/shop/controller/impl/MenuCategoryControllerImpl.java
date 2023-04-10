package co.shop.controller.impl;

import co.shop.controller.MenuCategoryController;
import co.shop.model.dto.MenuCategoryDTO;
import co.shop.model.mapper.MenuCategoryMapper;
import co.shop.model.entity.menu.MenuCategory;
import co.shop.service.MenuCategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/menu-category")
@RestController
public class MenuCategoryControllerImpl implements MenuCategoryController {
    private final MenuCategoryService menuCategoryService;
    private final MenuCategoryMapper menuCategoryMapper;

    public MenuCategoryControllerImpl(MenuCategoryService menuCategoryService, MenuCategoryMapper menuCategoryMapper) {
        this.menuCategoryService = menuCategoryService;
        this.menuCategoryMapper = menuCategoryMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MenuCategoryDTO save(@RequestBody MenuCategoryDTO menuCategoryDTO) {
        MenuCategory menuCategory = menuCategoryMapper.asEntity(menuCategoryDTO);
        return menuCategoryMapper.asDTO(menuCategoryService.save(menuCategory));
    }

    @Override
    @GetMapping("/{id}")
    public MenuCategoryDTO findById(@PathVariable("id") Integer id) {
        MenuCategory menuCategory = menuCategoryService.findById(id).orElse(null);
        return menuCategoryMapper.asDTO(menuCategory);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        menuCategoryService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<MenuCategoryDTO> list() {
        return menuCategoryMapper.asDTOList(menuCategoryService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<MenuCategoryDTO> pageQuery(Pageable pageable) {
        Page<MenuCategory> menuCategoryPage = menuCategoryService.findAll(pageable);
        List<MenuCategoryDTO> dtoList = menuCategoryPage
                .stream()
                .map(menuCategoryMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, menuCategoryPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public MenuCategoryDTO update(@RequestBody MenuCategoryDTO menuCategoryDTO, @PathVariable("id") Integer id) {
        MenuCategory menuCategory = menuCategoryMapper.asEntity(menuCategoryDTO);
        return menuCategoryMapper.asDTO(menuCategoryService.update(menuCategory, id));
    }
}
