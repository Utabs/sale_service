package co.shop.model.dto;

import co.shop.model.entity.user.Privilege;
import co.shop.model.entity.user.Role;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class RolePrivilegesDTO extends AbstractDTO<Long> {
    private Long id;
    private Role role;
    private Privilege privilege;
    private Boolean enabled;


}
