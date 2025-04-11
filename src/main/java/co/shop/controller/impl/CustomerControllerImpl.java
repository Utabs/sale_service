package co.shop.controller.impl;

import co.shop.controller.CustomerController;
import co.shop.model.dto.CustomerDTO;
import co.shop.model.dto.OrderDTO;
import co.shop.model.entity.shop.Order;
import co.shop.model.entity.user.Customer;
import co.shop.model.mapper.CustomerMapper;
import co.shop.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins =  {"http://192.168.1.2:4200","http://localhost:4200","192.168.1.2:8080","http://192.168.137.147"})
@RequestMapping("/api/customer")
@RestController
public class CustomerControllerImpl implements CustomerController {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    public CustomerControllerImpl(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO save(@RequestBody CustomerDTO customerDTO) {
        Customer customer = customerMapper.asEntity(customerDTO);
        return customerMapper.asDTO(customerService.save(customer));
    }

    @Override
    @GetMapping("/{id}")
    public CustomerDTO findById(@PathVariable("id") Long id) {
        Customer customer = customerService.findById(id).orElse(null);
        return customerMapper.asDTO(customer) ;
    }

    @Override
    @GetMapping("/username/{username}")
    public CustomerDTO find(@PathVariable("username") String username) {
        return customerMapper.asDTO(customerService.findByUserName(username).orElse(null));
     }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        customerService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<CustomerDTO> list() {
        return customerMapper.asDTOList(customerService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<CustomerDTO> pageQuery(Pageable pageable) {
        Page<Customer> customerPage = customerService.findAll(pageable);
        return null ;
    }

    @Override
    @PutMapping("/{id}")
    public CustomerDTO update(@RequestBody CustomerDTO customerDTO, @PathVariable("id") Long id) {
        return null ;
    }


}
