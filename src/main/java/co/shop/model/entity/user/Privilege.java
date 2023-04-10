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
@Table(name = "Privilege")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Privilege {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "EN_NAME")
    private String enName;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "MODULE_KEY")
    private String moduleKey;
    @Column(name = "MODULE_COMPONENT")
    private String moduleComponent;
    @Column(name = "ICON")
    private String icon;
    @Column(name = "ENABLED")
    private boolean enabled;
    @Column(name = "ACCESS_TYPE")
    private Integer accessType;

    @OneToMany(mappedBy = "privilege")
    @JsonIgnore
     private Set<RolePrivileges> rolePrivileges;


}
