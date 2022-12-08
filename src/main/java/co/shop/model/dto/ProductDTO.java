package co.shop.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.Instant;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public  class ProductDTO extends  AbstractDTO<Long> {
    private Long id;
    private String code;
    private Integer categoryId;
    private String name;
    private String vendor;
    private BigDecimal buyPrice;
    private Integer quantityInStock;
    private String description;
    private Integer createBy;
    private Instant createDateTime;
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
    private Integer updateBy;
    private Instant updateDateTime;
    private BigDecimal productCategoryId;


}
