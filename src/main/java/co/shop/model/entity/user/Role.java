package co.shop.model.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.*;

@Data
@Table(name = "Role")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")//,columnDefinition = "nvarchar(20)")
    private String name;

    @Column(name = "DESCRIPTION")//,columnDefinition = "nvarchar(500)")
    private String description;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @ToString.Exclude
//    private Users user;

    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)
    private Set<Users> users = new HashSet<>();



    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ROLE_PRIVILEGES",
            joinColumns = @JoinColumn(name = "ROLE_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRIVILEGE_ID"))
    private Set<Privilege> privileges = new HashSet<>();

    // getters and setters
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void addPrivilege(Privilege privilege) {
        privileges.add(privilege);
        privilege.getRoles().add(this);
    }

    public void removePrivilege(Privilege privilege) {
        privileges.remove(privilege);
        privilege.getRoles().remove(this);
    }
}
