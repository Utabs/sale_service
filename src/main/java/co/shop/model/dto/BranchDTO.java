package co.shop.model.dto;

import co.shop.model.entity.user.UserBranch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchDTO extends AbstractDTO<Integer> {
    private Integer id;
    private Integer activeDate;
    private Integer branchCode;
    private Integer degree;
    private Integer supBranch;
//    private Set<UserBranch> userBranches;

}
