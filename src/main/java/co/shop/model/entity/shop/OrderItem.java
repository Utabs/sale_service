package co.shop.model.entity.shop;


import co.shop.model.entity.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "OrderItem")
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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Order_ID",nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Product_ID",nullable = false)
    @Fetch(FetchMode.SELECT)
    @JsonIgnore
    private Product product;



}
