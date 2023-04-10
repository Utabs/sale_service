package co.shop.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PersonDTO extends AbstractDTO<Long> {
    private Long id;
    private String userName;
    private String uuid;
    private Boolean enabled;
    private Long createBy;
    private Instant createDate;
    private Long updateBy;
    private Instant updateDate;


}
