package co.shop.model.dto;

import co.shop.model.entity.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
public class OrderItemDto extends AbstractDTO<Long> {

    private Long id;
    private BigDecimal price;
    private Integer qtyOriginal;
    private Integer qtySupplement;
    private long orderId;
    private Product product;

}
