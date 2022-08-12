package co.shop.model.entity.shop;


import co.shop.model.entity.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "OrderItem")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "PRICE", columnDefinition = "decimal")
    private BigDecimal price;

    @Column(name = "QTY_PRIM", columnDefinition = "int")
    private Integer qtyOriginal;

    @Column(name = "QTY_SUP", columnDefinition = "int" )
    private Integer qtySupplement;

    @OneToOne
    @JoinColumn(name = "Product_ID" ,nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Order_ID",nullable = false)
    @JsonIgnore
    private Order order;


}
