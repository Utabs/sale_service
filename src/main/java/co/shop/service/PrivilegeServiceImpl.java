package co.shop.service;

import co.shop.repository.PrivilegeRepository;
import co.shop.service.PrivilegeService;
import co.shop.model.entity.user.Privilege;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PrivilegeServiceImpl implements PrivilegeService {
    private final PrivilegeRepository repository;

    public PrivilegeServiceImpl(PrivilegeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Privilege save(Privilege entity) {
        return repository.save(entity);
    }

    @Override
    public List<Privilege> save(List<Privilege> entities) {
        return (List<Privilege>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Privilege> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Privilege> findAll() {
        return (List<Privilege>) repository.findAll();
    }

    @Override
    public Page<Privilege> findAll(Pageable pageable) {
        Page<Privilege> entityPage = repository.findAll(pageable);
        List<Privilege> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Privilege update(Privilege entity, Long id) {
        Optional<Privilege> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}
