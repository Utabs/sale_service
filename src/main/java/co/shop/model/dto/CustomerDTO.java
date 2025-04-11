package co.shop.model.dto;

import lombok.*;

import java.time.Instant;
import java.util.Objects;


@Data
@RequiredArgsConstructor
public class CustomerDTO extends AbstractDTO<Long> {

    private Long id;
    private String userName;
    private String uuid;
    private Boolean enabled;
    private String name;
    private String family;
    private String nationalCode;
    private String phone;
    private Long createBy;
    private Instant createDate;
    private Long updateBy;
    private Instant updateDate;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerDTO)) return false;
        CustomerDTO customerDTO = (CustomerDTO) o;
        return Objects.equals(id, customerDTO.id)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id );
    }

}
