package co.shop.controller.impl;

import co.shop.controller.MenuController;
import co.shop.model.dto.MenuDTO;
import co.shop.model.mapper.MenuMapper;
import co.shop.model.entity.menu.Menu;
import co.shop.service.MenuService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/menu")
@RestController
public class MenuControllerImpl implements MenuController {
    private final MenuService menuService;
    private final MenuMapper menuMapper;

    public MenuControllerImpl(MenuService menuService, MenuMapper menuMapper) {
        this.menuService = menuService;
        this.menuMapper = menuMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MenuDTO save(@RequestBody MenuDTO menuDTO) {
        Menu menu = menuMapper.asEntity(menuDTO);
        return menuMapper.asDTO(menuService.save(menu));
    }

    @Override
    @GetMapping("/{id}")
    public MenuDTO findById(@PathVariable("id") Integer id) {
        Menu menu = menuService.findById(id).orElse(null);
        return menuMapper.asDTO(menu);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        menuService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<MenuDTO> list() {
        return menuMapper.asDTOList(menuService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<MenuDTO> pageQuery(Pageable pageable) {
        Page<Menu> menuPage = menuService.findAll(pageable);
        List<MenuDTO> dtoList = menuPage
                .stream()
                .map(menuMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, menuPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public MenuDTO update(@RequestBody MenuDTO menuDTO, @PathVariable("id") Integer id) {
        Menu menu = menuMapper.asEntity(menuDTO);
        return menuMapper.asDTO(menuService.update(menu, id));
    }
}
