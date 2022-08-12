package co.shop.model.entity;


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
@Table(name = "Customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME", length = 10,columnDefinition = "VARCHAR(10)")
    private String name;

    @Column(name = "FAMILY", length = 20,columnDefinition = "VARCHAR(20)")
    private String family;

    @Column(name = "NATIONAL_CODE", length = 10,columnDefinition = "VARCHAR(10)")
    private String nationalCode;

    @Column(name = "PHONE", length = 11)
    private String phone;

    @Column(name = "CREATE_DATE")
    private Timestamp createDate;

    @Column(name = "UPDATE_DATE")
    private Instant updateDate;

    @Column(name = "ENABLED")
    private Boolean enabled;


}
