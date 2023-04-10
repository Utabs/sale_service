package co.shop.service;

import co.shop.repository.RolePrivilegesRepository;
import co.shop.service.RolePrivilegesService;
import co.shop.model.entity.user.RolePrivileges;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RolePrivilegesServiceImpl implements RolePrivilegesService {
    private final RolePrivilegesRepository repository;

    public RolePrivilegesServiceImpl(RolePrivilegesRepository repository) {
        this.repository = repository;
    }

    @Override
    public RolePrivileges save(RolePrivileges entity) {
        return repository.save(entity);
    }

    @Override
    public List<RolePrivileges> save(List<RolePrivileges> entities) {
        return (List<RolePrivileges>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<RolePrivileges> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<RolePrivileges> findAll() {
        return (List<RolePrivileges>) repository.findAll();
    }

    @Override
    public Page<RolePrivileges> findAll(Pageable pageable) {
        Page<RolePrivileges> entityPage = repository.findAll(pageable);
        List<RolePrivileges> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public RolePrivileges update(RolePrivileges entity, Long id) {
        Optional<RolePrivileges> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}
