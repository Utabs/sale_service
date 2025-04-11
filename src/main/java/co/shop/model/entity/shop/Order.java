package co.shop.model.entity.shop;


import co.shop.model.entity.user.Customer;
import co.shop.model.entity.user.UserBranch;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Data
@Entity
@Table(name = "Orders")
@RequiredArgsConstructor
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CODE_NUM")//, columnDefinition = "nvarchar(20)")
    private String code;

    @Column(name = "ORDER_DATE")
    private Integer orderDate;

    @Column(name = "REQUIRE_DATE")
    private Integer requireDate;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "COMMENT", columnDefinition = "nvarchar(1000)")
    private String comment;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToMany(mappedBy = "order")
    private List<Payment> payments = new ArrayList<>();

//    // toDo: ManytoOne
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "UserBranch_ID")
    private UserBranch userBranch;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Customer_ID")
    private Customer customer;

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }
//
//    public void removeDetail(OrderItem orderItem) {
//        orderItems.remove(orderItem);
//        orderItem.setOrder(null);
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(getId(), order.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}

