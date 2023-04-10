package co.shop.model.entity;

import javax.persistence.Column;
import java.time.Instant;

public class BaseEntity {

    @Column(name = "CREATEBY")
    private Long createBy;

    @Column(name = "CREATE_DATE", columnDefinition = "DATETIME default CURRENT_TIMESTAMP")
    private Instant createDate;

    @Column(name = "UPDATEBY")
    private Long updateBy;

    @Column(name = "UPDATE_DATE")
    private Instant updateDate;
}
