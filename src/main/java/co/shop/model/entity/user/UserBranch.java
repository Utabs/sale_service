package co.shop.model.entity.user;

import co.shop.model.entity.Branch;
import co.shop.model.entity.shop.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "UserBranch")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
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
    private Users users;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "userBranch")
    private Order order;

}
