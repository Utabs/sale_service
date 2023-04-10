package co.shop.model.entity.product;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;


@Entity
@Table(name = "Product")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CODE",columnDefinition = "NVARCHAR(30)")
    private String code;

    @Column(name = "CATEGORY_ID")
    private Integer categoryId;

    @Column(name = "NAME",columnDefinition = "NVARCHAR(30)")
    private String name;

    @Column(name = "VENDOR",columnDefinition = "NVARCHAR(60)")
    private String vendor;

    @Column(name = "BUY_PRICE",columnDefinition = "decimal(15)")
    private BigDecimal buyPrice;

    @Column(name = "QTY_STOCK")
    private Integer quantityInStock;

    @Column(name = "DESCRIPTION",columnDefinition = "NVARCHAR(1500)")
    private String description;

    @Column(name = "eName")
    private String eName;

    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "imgUrl", length = 250)
    private String imgUrl;

    @Column(name = "ordering")
    private Integer ordering;

    @Column(name = "price1")
    private Integer price1;

    @Column(name = "price2")
    private Integer price2;

    @Column(name = "price3")
    private Integer price3;

    @Column(name = "price4")
    private Integer price4;

    @Column(name = "setLevel")
    private Integer setLevel;

    @Column(name = "summary", length = 500)
    private String summary;

    @Column(name = "createBy")
    private Integer createBy;

    @Column(name = "createDateTime")
    private Instant createDateTime;

    @Column(name = "updateBy")
    private Integer updateBy;

    @Column(name = "updateDateTime")
    private Instant updateDateTime;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
