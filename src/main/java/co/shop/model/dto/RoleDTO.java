package co.shop.model.dto;

import co.shop.model.entity.user.RolePrivileges;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class RoleDTO extends AbstractDTO<Long> {
    private Long id;
    private String name;
    private String description;
    @JsonIgnore
    private Set<RolePrivileges> rolePrivileges;

}
