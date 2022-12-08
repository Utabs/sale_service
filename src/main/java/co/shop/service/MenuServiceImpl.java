package co.shop.service;

import co.shop.repository.MenuRepository;
import co.shop.model.entity.menu.Menu;
import co.shop.service.MenuService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {
    private final MenuRepository repository;

    public MenuServiceImpl(MenuRepository repository) {
        this.repository = repository;
    }

    @Override
    public Menu save(Menu entity) {
        return repository.save(entity);
    }

    @Override
    public List<Menu> save(List<Menu> entities) {
        return (List<Menu>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Menu> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Menu> findAll() {
        return (List<Menu>) repository.findAll();
    }

    @Override
    public Page<Menu> findAll(Pageable pageable) {
        Page<Menu> entityPage = repository.findAll(pageable);
        List<Menu> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Menu update(Menu entity, Integer id) {
        Optional<Menu> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}
