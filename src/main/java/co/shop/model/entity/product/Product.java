package co.shop.model.entity.product;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Table
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

    @Column(name = "PRICE",columnDefinition = "decimal(15)")
    private BigDecimal price;

    @Column(name = "QTY")
    private Integer quantity;

    @Column(name = "DESCRIPTION",columnDefinition = "NVARCHAR(1500)")
    private String description;

}
