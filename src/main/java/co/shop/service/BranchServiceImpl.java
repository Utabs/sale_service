package co.shop.service;

import co.shop.repository.BranchRepository;
import co.shop.model.entity.Branch;
import co.shop.service.BranchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BranchServiceImpl implements BranchService {
    private final BranchRepository repository;

    public BranchServiceImpl(BranchRepository repository) {
        this.repository = repository;
    }

    @Override
    public Branch save(Branch entity) {
        return repository.save(entity);
    }

    @Override
    public List<Branch> save(List<Branch> entities) {
        return (List<Branch>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Branch> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Branch> findAll() {
        return (List<Branch>) repository.findAll();
    }

    @Override
    public Page<Branch> findAll(Pageable pageable) {
        Page<Branch> entityPage = repository.findAll(pageable);
        List<Branch> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Branch update(Branch entity, Integer id) {
        Optional<Branch> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}
