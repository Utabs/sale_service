package co.shop.model.entity.user;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Users",uniqueConstraints = {@UniqueConstraint(name = "UC_UNAME",columnNames = {"USER_NAME"})})
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "USER_NAME", length = 64)
    private String userName;

    @Column(name = "PASSWORD", length = 200)
    private String password;

    @Column(name = "OTP_PASSWORD", length = 100)
    private String oneTimePassword;

    @Column(name = "OTP_REQ_TIME")
    private Instant otpRequestedTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_FK")
    private Person person;

    @Column(name = "CREATE_DATE")
    private Instant createDate;

    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "FAMILY", length = 20)
    private String family;

    @Column(name = "NAME", length = 10)
    private String name;

    @Column(name = "NATIONAL_CODE", length = 10)
    private String nationalCode;


    @Column(name = "PHONE", length = 11)
    private String phone;

    @Column(name = "TOKEN_EXP")
    private Boolean tokenExp;

    @Column(name = "UPDATE_DATE")
    private Instant updateDate;

    @OneToMany(mappedBy = "users")
    private Set<UserRole> userRoles;



}
