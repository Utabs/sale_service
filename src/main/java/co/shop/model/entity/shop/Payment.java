package co.shop.model.entity.shop;


import co.shop.model.entity.user.Customer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Payments")
@RequiredArgsConstructor
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CODE_NUM")//, columnDefinition = "nvarchar(20)")
    private String code;

    @Column(name = "PAYMENT_DATE")
    private Integer paymentDate;

    @Column(name = "TYPE")
    private Integer paymentType;

    @Column(name = "COMMENT")//, columnDefinition = "nvarchar(1000)")
    private String orderComment;

    @ManyToOne()
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne()
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

}

