package co.shop.model.entity.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "User",uniqueConstraints = {@UniqueConstraint(name = "UC_UNAME",columnNames = {"USER_NAME"})})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "CREATE_DATE")
    private Timestamp createDate;

    @Column(name = "ENABLED")
    private Boolean enabled;

    @Column(name = "FAMILY", length = 20)
    private String family;

    @Column(name = "NAME", length = 10)
    private String name;

    @Column(name = "NATIONAL_CODE", length = 10)
    private String nationalCode;

    @Column(name = "PASSWORD", length = 200)
    private String password;

    @Column(name = "PHONE", length = 11)
    private String phone;

    @Column(name = "TOKEN_EXP")
    private Boolean tokenExp;

    @Column(name = "UPDATE_DATE")
    private Instant updateDate;

    @Column(name = "USER_NAME", length = 20)
    private String userName;

    @OneToMany(mappedBy = "user")
    private Set<UserBranch> userBranches = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "UserRole",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private Set<Role> roles = new LinkedHashSet<>();

}
