package co.shop.model.dto;

import co.shop.model.entity.product.Product;
import co.shop.model.entity.shop.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDTO extends AbstractDTO<Long> {

    @JsonIgnore
    private Long id;
    private BigDecimal price;
    private Integer qtyOriginal;
    private Integer qtySupplement;
    private Order order;
    private Product product;

}
