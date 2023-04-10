package co.shop.service;

import co.shop.repository.UserRoleRepository;
import co.shop.service.UserRoleService;
import co.shop.model.entity.user.UserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository repository;

    public UserRoleServiceImpl(UserRoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserRole save(UserRole entity) {
        return repository.save(entity);
    }

    @Override
    public List<UserRole> save(List<UserRole> entities) {
        return (List<UserRole>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<UserRole> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<UserRole> findAll() {
        return (List<UserRole>) repository.findAll();
    }

    @Override
    public Page<UserRole> findAll(Pageable pageable) {
        Page<UserRole> entityPage = repository.findAll(pageable);
        List<UserRole> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public UserRole update(UserRole entity, Long id) {
        Optional<UserRole> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}
