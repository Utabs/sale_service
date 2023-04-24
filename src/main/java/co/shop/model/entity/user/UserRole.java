package co.shop.model.entity.user;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "User_Role")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "USER_FK")
    private Users users;

    @ManyToOne()
    @JoinColumn(name = "ROLE_FK")
    private Role role;

}
