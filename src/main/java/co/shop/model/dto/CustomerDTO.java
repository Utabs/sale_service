package co.shop.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO extends AbstractDTO<Long> {
    @JsonIgnore
    private Long id;
    private String name;
    private String family;
    private String nationalCode;
    private String phone;
    private Instant createDate;
    private Instant updateDate;
    private Boolean enabled;

}
