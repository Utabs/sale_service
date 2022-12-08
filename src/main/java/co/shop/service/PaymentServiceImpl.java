package co.shop.service;

import co.shop.repository.PaymentRepository;
import co.shop.service.PaymentService;
import co.shop.model.entity.shop.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository repository;

    public PaymentServiceImpl(PaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Payment save(Payment entity) {
        return repository.save(entity);
    }

    @Override
    public List<Payment> save(List<Payment> entities) {
        return (List<Payment>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Payment> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Payment> findAll() {
        return (List<Payment>) repository.findAll();
    }

    @Override
    public Page<Payment> findAll(Pageable pageable) {
        Page<Payment> entityPage = repository.findAll(pageable);
        List<Payment> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Payment update(Payment entity, Long id) {
        Optional<Payment> optional = findById(id) ;
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}
