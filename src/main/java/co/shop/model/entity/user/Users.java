package co.shop.model.entity.user;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@Entity
@Table(name = "Users",uniqueConstraints = {@UniqueConstraint(name = "UC_NAME",columnNames = {"USER_NAME"})})
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "USER_NAME", length = 64,columnDefinition = "NVARCHAR(64)")
    private String userName;

    @ToString.Exclude
    @Column(name = "PASSWORD", length = 200)
    private String password;

    @Column(name = "OTP_PASSWORD", length = 100)
    private String oneTimePassword;

    @Column(name = "OTP_REQ_TIME")
    private Instant otpRequestedTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_FK")
    private Customer customer;

    @Column(name = "CREATE_DATE")
    private Instant createDate;

    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "FAMILY", length = 20,columnDefinition = "NVARCHAR(20)")
    private String family;

    @Column(name = "NAME", length = 10,columnDefinition = "NVARCHAR(10)")
    private String name;

    @Column(name = "NATIONAL_CODE", length = 10)
    private String nationalCode;


    @Column(name = "PHONE", length = 11)
    private String phone;

    @Column(name = "TOKEN_EXP")
    private Boolean tokenExp;

    @Column(name = "UPDATE_DATE")
    private Instant updateDate;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
//    private Set<Role> roles=new HashSet<>();

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLE",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users users = (Users) o;
        return Objects.equals(id, users.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    //    public void addRole(Role role) {
//        roles.add(role);
//        role.getUsers().add(this);
//    }
//
//    public void removeRole(Role role) {
//        roles.remove(role);
//        role.getUsers().remove(this);
//    }
}
