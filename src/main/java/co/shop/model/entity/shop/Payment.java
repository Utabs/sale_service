package co.shop.model.entity.shop;


import co.shop.model.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Payments")
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CODE_NUM")//, columnDefinition = "nvarchar(20)")
    private String codeNum;

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

