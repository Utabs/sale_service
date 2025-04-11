package co.shop.model.dto;

import co.shop.model.entity.shop.Payment;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Data
@RequiredArgsConstructor
@EqualsAndHashCode
public class OrderDTO extends AbstractDTO<Long> {

    private Long id;
    private String code;
    private Integer orderDate;
    private Integer requireDate;
    private Integer status;
    private String comment;
    private List<OrderItemDto> orderItems;
    private List<Payment> payments;
    private long userBranchId;
    private CustomerDTO customer;



}
