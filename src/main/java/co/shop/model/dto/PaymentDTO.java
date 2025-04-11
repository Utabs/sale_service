package co.shop.model.dto;

import co.shop.model.entity.shop.Order;
import co.shop.model.entity.user.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaymentDTO extends AbstractDTO<Long> {
    private Long id;
    private String code;
    private Integer paymentDate;
    private Integer paymentType;
    private String orderComment;
    private Order order;
    private Customer customer;
}
