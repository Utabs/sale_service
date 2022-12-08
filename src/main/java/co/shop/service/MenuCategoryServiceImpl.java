package co.shop.service;

import co.shop.repository.MenuCategoryRepository;
import co.shop.model.entity.menu.MenuCategory;
import co.shop.service.MenuCategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MenuCategoryServiceImpl implements MenuCategoryService {
    private final MenuCategoryRepository repository;

    public MenuCategoryServiceImpl(MenuCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public MenuCategory save(MenuCategory entity) {
        return repository.save(entity);
    }

    @Override
    public List<MenuCategory> save(List<MenuCategory> entities) {
        return (List<MenuCategory>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<MenuCategory> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<MenuCategory> findAll() {
        return (List<MenuCategory>) repository.findAll();
    }

    @Override
    public Page<MenuCategory> findAll(Pageable pageable) {
        Page<MenuCategory> entityPage = repository.findAll(pageable);
        List<MenuCategory> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public MenuCategory update(MenuCategory entity, Integer id) {
        Optional<MenuCategory> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}
