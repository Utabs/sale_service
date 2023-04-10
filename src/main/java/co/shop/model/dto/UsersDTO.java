package co.shop.model.dto;

import co.shop.model.entity.user.Person;
import co.shop.model.entity.user.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Set;



@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UsersDTO extends AbstractDTO<Long> {
    private Long id;
    private Person person;
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

    private Set<UserRole> userRoles;


}
