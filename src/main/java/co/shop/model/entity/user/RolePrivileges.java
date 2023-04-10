package co.shop.model.entity.user;


import co.shop.model.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;



@Entity
@Table(name = "Role_Privilages")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RolePrivileges {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_FK")
    @ToString.Exclude
    private Role role;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRIVILEGE_FK")
    private Privilege privilege;

    @Column
    private Boolean enabled;




}
