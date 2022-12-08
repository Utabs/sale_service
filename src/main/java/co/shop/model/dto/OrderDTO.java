package co.shop.model.dto;

import co.shop.model.entity.Customer;
import co.shop.model.entity.shop.OrderItem;
import co.shop.model.entity.shop.Payment;
import co.shop.model.entity.user.UserBranch;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO extends AbstractDTO<Long> {
    @JsonIgnore
    private Long id;
    private String codeNum;
    private Integer orderDate;
    private Integer requireDate;
    private Integer orderStatus;
    private String orderComment;
    private List<OrderItem> orderItems;
    private List<Payment> payments;
    private UserBranch userBranch;
    private Customer customer;

}
