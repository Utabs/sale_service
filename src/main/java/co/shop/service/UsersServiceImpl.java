package co.shop.service;

import co.shop.repository.UsersRepository;
import co.shop.service.UsersService;
import co.shop.model.entity.user.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {
    private final UsersRepository repository;

    public UsersServiceImpl(UsersRepository repository) {
        this.repository = repository;
    }


    public Users findByUserName(String loginId) {
        return repository.findByUserName(loginId);
    }


    public Users save(Users entity) {
        return repository.save(entity);
    }


    public List<Users> save(List<Users> entities) {
        return (List<Users>) repository.saveAll(entities);
    }


    public void deleteById(Long id) {
        repository.deleteById(id);
    }


    public Optional<Users> findById(Long id) {
        return repository.findById(id);
    }


    public List<Users> findAll() {
        return (List<Users>) repository.findAll();
    }


    public Page<Users> findAll(Pageable pageable) {
        Page<Users> entityPage = repository.findAll(pageable);
        List<Users> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }


    public Users update(Users entity, Long id) {
        Optional<Users> optional = findById(id) ;
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}
