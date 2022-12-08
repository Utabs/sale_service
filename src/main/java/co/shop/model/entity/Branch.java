package co.shop.model.entity;

import co.shop.model.entity.user.UserBranch;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Branch")
@AllArgsConstructor
@NoArgsConstructor
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "ACTIVE_DATE")
    private Integer activeDate;

    @Column(name = "BRANCH_CODE")
    private Integer branchCode;

    @Column(name = "DEGREE")
    private Integer degree;

    @Column(name = "SUP_BRANCH")
    private Integer supBranch;

    @OneToMany(mappedBy = "branch")
    private Set<UserBranch> userBranches = new LinkedHashSet<>();

}
