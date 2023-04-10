package co.shop.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public  class ProductDTO extends  AbstractDTO<Long> {
    private Long id;
    private String code;
    private Integer categoryId;
    private String name;
    private String vendor;
    private BigDecimal buyPrice;
    private Integer quantityInStock;
    private String description;
    private String eName;
    private Boolean enabled;
    private String imgUrl;
    private Integer ordering;
    private Integer price1;
    private Integer price2;
    private Integer price3;
    private Integer price4;
    private Integer setLevel;
    private String summary;
    private Integer createBy;
    private Instant createDateTime;
    private Integer updateBy;
    private Instant updateDateTime;



}
