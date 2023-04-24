package co.shop.model.dto;

import co.shop.model.entity.user.Person;
import co.shop.model.entity.user.UserRole;
import lombok.*;

import java.time.Instant;
import java.util.Set;



@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class UsersDTO extends AbstractDTO<Long> {
    private Long id;
//    private Person person;
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

//    private Set<UserRole> userRoles;


}
