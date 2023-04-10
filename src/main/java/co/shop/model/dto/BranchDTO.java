package co.shop.model.dto;

import co.shop.model.entity.user.UserBranch;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchDTO extends AbstractDTO<Integer> {

    private Integer id;
    private Integer activeDate;
    private Integer branchCode;
    private String branchName;
    private Integer degree;
    private Integer supBranch;
    private boolean isActive;
//    private Set<UserBranch> userBranches;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BranchDTO)) return false;
        BranchDTO branchDTO = (BranchDTO) o;
        return Objects.equals(id, branchDTO.id)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id );
    }
}
