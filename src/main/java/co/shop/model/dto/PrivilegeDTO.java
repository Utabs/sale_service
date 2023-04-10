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
public class PrivilegeDTO extends AbstractDTO<Long> {
    private Long id;
    private String enName;
    private String title;
    private String moduleKey;
    private String moduleComponent;
    private String icon;
    private boolean enabled;
    private Integer accessType;
    @JsonIgnore
    private Set<RolePrivileges> rolePrivileges;

 }
