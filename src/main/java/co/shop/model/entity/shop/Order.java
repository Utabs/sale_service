package co.shop.model.entity.shop;


import co.shop.model.entity.Customer;
import co.shop.model.entity.user.UserBranch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CODE_NUM", columnDefinition = "nvarchar(20)")
    private String codeNum;

    @Column(name = "REG_DATE")
    private Integer regDate;


    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "OrderItem_ID", updatable = false, insertable = false)
    private List<OrderItem> orderItems;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "UserBranch_ID")
    private UserBranch userBranch;

    @ManyToOne()
    @JoinColumn(name = "Customer_ID")
    private Customer customer;

    public void addDetail(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void removeDetail(OrderItem orderItem) {
        orderItems.remove(orderItem);
        orderItem.setOrder(null);
    }


}

