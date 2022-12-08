package co.shop.controller;

import co.shop.model.dto.PaymentDTO;
import co.shop.model.mapper.PaymentMapper;
import co.shop.service.PaymentService;
import co.shop.model.entity.shop.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/payment")
@RestController
public class PaymentControllerImpl implements PaymentController {
    private final PaymentService paymentService;
    private final PaymentMapper paymentMapper;

    public PaymentControllerImpl(PaymentService paymentService, PaymentMapper paymentMapper) {
        this.paymentService = paymentService;
        this.paymentMapper = paymentMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentDTO save(@RequestBody PaymentDTO paymentDTO) {
        Payment payment = paymentMapper.asEntity(paymentDTO);
        return paymentMapper.asDTO(paymentService.save(payment));
    }

    @Override
    @GetMapping("/{id}")
    public PaymentDTO findById(@PathVariable("id") Long id) {
        Payment payment = paymentService.findById(id).orElse(null);
        return paymentMapper.asDTO(payment);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        paymentService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<PaymentDTO> list() {
        return paymentMapper.asDTOList(paymentService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<PaymentDTO> pageQuery(Pageable pageable) {
        Page<Payment> paymentPage = paymentService.findAll(pageable);
        List<PaymentDTO> dtoList = paymentPage
                .stream()
                .map(paymentMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, paymentPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public PaymentDTO update(@RequestBody PaymentDTO paymentDTO, @PathVariable("id") Long id) {
        Payment payment = paymentMapper.asEntity(paymentDTO);
        return paymentMapper.asDTO(paymentService.update(payment, id));
    }
}
