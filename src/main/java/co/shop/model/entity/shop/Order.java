package co.shop.model.entity.shop;


import co.shop.model.entity.Customer;
import co.shop.model.entity.user.UserBranch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "Orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CODE_NUM")//, columnDefinition = "nvarchar(20)")
    private String codeNum;

    @Column(name = "ORDER_DATE")
    private Integer orderDate;

    @Column(name = "REQUIRE_DATE")
    private Integer requireDate;

    @Column(name = "STATUS")
    private Integer orderStatus;

    @Column(name = "COMMENT")//, columnDefinition = "nvarchar(1000)")
    private String orderComment;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToMany(mappedBy = "order")
    private List<Payment> payments = new ArrayList<>();

//    // toDo: ManytoOne
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "UserBranch_ID")
    private UserBranch userBranch;

    @ManyToOne()
    @JoinColumn(name = "Customer_ID")
    private Customer customer;

//    public void addDetail(OrderItem orderItem) {
//        orderItems.add(orderItem);
//        orderItem.setOrder(this);
//    }
//
//    public void removeDetail(OrderItem orderItem) {
//        orderItems.remove(orderItem);
//        orderItem.setOrder(null);
//    }


}

