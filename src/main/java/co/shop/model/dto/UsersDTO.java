package co.shop.model.dto;

import co.shop.model.entity.user.Role;
import co.shop.model.entity.user.UserBranch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDTO extends AbstractDTO<Long> {
    private Long id;
    private Instant createDate;
    private Boolean enabled;
    private String family;
    private String name;
    private String nationalCode;
    private String password;
    private String phone;
    private Boolean tokenExp;
    private Instant updateDate;
    private String userName;
    private Set<UserBranch> userBranches;
    private Set<Role> roles;
}
