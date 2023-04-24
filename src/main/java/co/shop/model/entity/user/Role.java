package co.shop.model.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Data
@Table(name = "Role")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")//,columnDefinition = "nvarchar(20)")
    private String name;

    @Column(name = "DESCRIPTION")//,columnDefinition = "nvarchar(500)")
    private String description;

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    private Set<RolePrivileges> rolePrivileges;

    @OneToMany(mappedBy = "role",fetch = FetchType.EAGER)
    @ToString.Exclude
    private Set<UserRole> userRoles;

}
