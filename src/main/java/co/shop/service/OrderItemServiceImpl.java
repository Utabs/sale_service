package co.shop.service;

import co.shop.repository.OrderItemRepository;
import co.shop.service.OrderItemService;
import co.shop.model.entity.shop.OrderItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository repository;

    public OrderItemServiceImpl(OrderItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public OrderItem save(OrderItem entity) {
        return repository.save(entity);
    }

    @Override
    public List<OrderItem> save(List<OrderItem> entities) {
        return (List<OrderItem>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<OrderItem> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<OrderItem> findAll() {
        return (List<OrderItem>) repository.findAll();
    }

    @Override
    public Page<OrderItem> findAll(Pageable pageable) {
        Page<OrderItem> entityPage = repository.findAll(pageable);
        List<OrderItem> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public OrderItem update(OrderItem entity, Long id) {
        Optional<OrderItem> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}
