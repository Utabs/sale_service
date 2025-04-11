package co.shop.service;

import co.shop.model.dto.OrderDTO;
import co.shop.model.dto.OrderItemDto;
import co.shop.model.entity.shop.Order;
import co.shop.model.entity.shop.OrderItem;
import co.shop.model.entity.user.Customer;
import co.shop.model.mapper.CustomerMapper;
import co.shop.model.mapper.OrderItemMapper;
import co.shop.model.mapper.OrderMapper;
import co.shop.repository.CustomerRepository;
import co.shop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final OrderItemMapper orderItemMapper;
    private final OrderMapper orderMapper;
    private final CustomerMapper  customerMapper;

    public OrderServiceImpl(OrderRepository orderRepository, CustomerRepository customerRepository, OrderItemMapper orderItemMapper, OrderMapper orderMapper, CustomerMapper customerMapper, ProductService productService, CustomerService customerService) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.orderItemMapper = orderItemMapper;
        this.orderMapper = orderMapper;
        this.customerMapper = customerMapper;
        this.productService = productService;
        this.customerService = customerService;
    }

    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;

    @Override
    public Order save(Order entity) {
        return null;
    }

    @Override
    public Order save(OrderDTO orderDto) {
        Order order = orderMapper.asEntity(orderDto);
//        Customer customer = customerService.findById(orderDto.getCustomerId()).orElse(null);
        Customer customer = customerMapper.asEntity(orderDto.getCustomer());
        if (Objects.nonNull(customer))
            order.setCustomer(customer);
        for (OrderItemDto orderItemsDto : orderDto.getOrderItems()) {
            OrderItem orderItem = orderItemMapper.asEntity(orderItemsDto);
            orderItem.setProduct(productService.findById(orderItemsDto.getProduct().getId()).orElse(null));
            order.addOrderItem(orderItem);
        }

        return orderRepository.save(order);
    }

    @Override
    public List<Order> save(List<Order> entities) {
        return (List<Order>) orderRepository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order deleteByIdData(Long id) {
        return null;
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> findAll() {
        return (List<Order>) orderRepository.findAll();
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
        Page<Order> entityPage = orderRepository.findAll(pageable);
        List<Order> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }


    @Override
    public Order update(Order entity, Long id) {
        Optional<Order> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }

    public Order findOrder(long customerId, int status) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        Optional<Order> order = orderRepository.findByCustomerAndStatus(customer.isPresent() ? customer.get() : null, status);
        return order.isPresent() ? order.get() : null;
    }

    // ذخیره کردن OrderItem جدید
    public Order addOrderItem(Long orderId, OrderItem item) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.addOrderItem(item);
        return orderRepository.save(order);
    }


    @Override
    public Optional<List<Order>> getAllOrders(String userName) {
        Optional<List<Order>> allOrdersByCustomerId = Optional.empty();
        Optional<Customer> byUserName = customerService.findByUserName(userName);
        if (byUserName.isPresent()) {
            allOrdersByCustomerId = orderRepository.findAllByCustomerId(byUserName.get().getId());
        }
        return  allOrdersByCustomerId;
    }
}
