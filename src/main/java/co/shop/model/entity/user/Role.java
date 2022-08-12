package co.shop.model.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Table(name = "Role")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME",columnDefinition = "nvarchar(20)")
    private String name;

    @Column(name = "DESCRIPTION",columnDefinition = "nvarchar(500)")
    private String description;

    @ToString.Exclude
    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(
            name = "RolePrivilege",
            joinColumns = @JoinColumn(
                    name = "ROLE_ID", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "PRIVILEGE_ID", referencedColumnName = "id"))
    private Collection<Privilege> privileges;


}
