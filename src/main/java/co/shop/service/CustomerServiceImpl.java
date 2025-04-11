package co.shop.service;

import co.shop.model.entity.shop.Order;
import co.shop.model.entity.user.Customer;
import co.shop.repository.CustomerRepository;
import co.shop.repository.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;
    private final OrderRepository orderRepository;

    public CustomerServiceImpl(CustomerRepository repository, OrderRepository orderRepository) {
        this.repository = repository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Customer save(Customer entity) {
        return repository.save(entity);
    }

    @Override
    public List<Customer> save(List<Customer> entities) {
        return (List<Customer>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Customer deleteByIdData(Long id) {
        return null;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Customer> findAll() {
        return (List<Customer>) repository.findAll();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        Page<Customer> entityPage = repository.findAll(pageable);
        List<Customer> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Customer update(Customer entity, Long id) {
        Optional<Customer> optional = findById(id) ;
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }

    @Override
    public Optional<Customer> findByUserName(String userName) {

        return repository.findByUserName(userName);
    }

}
