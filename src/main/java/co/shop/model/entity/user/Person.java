package co.shop.model.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "Person", uniqueConstraints = {@UniqueConstraint(name = "UC_UNAME",columnNames = {"USER_NAME"}),
        @UniqueConstraint(name = "UC_UUID",columnNames = {"USER_UUID"})}

)
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USER_UUID")
    private String uuid;

    @Column(name = "USER_NAME")
    private String userName;


    @Column(name = "ENABLED",columnDefinition = "bit default 0")
    private Boolean enabled;

    @Column(name = "CREATEBY")
    private Long createBy;

    @Column(name = "CREATE_DATE",columnDefinition = "DATETIME default CURRENT_TIMESTAMP")
    private Instant createDate;

    @Column(name = "UPDATEBY")
    private Long updateBy;

    @Column(name = "UPDATE_DATE")
    private Instant updateDate;


}
