package co.shop.model.entity;

import co.shop.model.entity.user.UserBranch;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@Table(name = "Branch",uniqueConstraints = {
        @UniqueConstraint(name = "UC_BranchCode",columnNames = {"BRANCH_CODE"})
})
@AllArgsConstructor
@NoArgsConstructor
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "ACTIVE_DATE")
    private Integer activeDate;

    @Column(name = "BRANCH_Name",columnDefinition = "NVARCHAR(50)")
    private String branchName;

    @Column(name = "BRANCH_CODE")
    private Integer branchCode;

    @Column(name = "DEGREE")
    private Integer degree;

    @Column(name = "SUP_BRANCH")
    private Integer supBranch;

    @Column(name = "ENABLED")
    private boolean isActive;

    @OneToMany(mappedBy = "branch")
    private Set<UserBranch> userBranches = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Branch)) return false;
        Branch branch = (Branch) o;
        return id.equals(branch.id) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, branchCode);
    }
}
