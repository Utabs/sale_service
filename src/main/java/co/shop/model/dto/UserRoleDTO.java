package co.shop.model.dto;

import co.shop.model.entity.user.Role;
import co.shop.model.entity.user.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleDTO extends AbstractDTO<Long> {
    private Long id;
    private Users users;
    private Role role;

}
