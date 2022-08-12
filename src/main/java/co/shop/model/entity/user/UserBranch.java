package co.shop.model.entity.user;

import co.shop.model.entity.Branch;
import co.shop.model.entity.shop.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "UserBranch")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBranch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, precision = 19)
    private BigDecimal id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Branch_ID")
    private Branch branch;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_ID")
    private User user;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "userBranch")
    private Order order;

}
