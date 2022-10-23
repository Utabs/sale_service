package co.shop.model.entity.product;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;


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

    @Column(name = "createBy")
    private Integer createBy;

    @Column(name = "createDateTime")
    private Instant createDateTime;

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

    @Column(name = "updateBy")
    private Integer updateBy;

    @Column(name = "updateDateTime")
    private Instant updateDateTime;

    @Column(name = "productCategoryId", precision = 19)
    private BigDecimal productCategoryId;

    public BigDecimal getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(BigDecimal productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Instant getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Instant updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getSetLevel() {
        return setLevel;
    }

    public void setSetLevel(Integer setLevel) {
        this.setLevel = setLevel;
    }

    public Integer getPrice4() {
        return price4;
    }

    public void setPrice4(Integer price4) {
        this.price4 = price4;
    }

    public Integer getPrice3() {
        return price3;
    }

    public void setPrice3(Integer price3) {
        this.price3 = price3;
    }

    public Integer getPrice2() {
        return price2;
    }

    public void setPrice2(Integer price2) {
        this.price2 = price2;
    }

    public Integer getPrice1() {
        return price1;
    }

    public void setPrice1(Integer price1) {
        this.price1 = price1;
    }

    public Integer getOrdering() {
        return ordering;
    }

    public void setOrdering(Integer ordering) {
        this.ordering = ordering;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getEName() {
        return eName;
    }

    public void setEName(String eName) {
        this.eName = eName;
    }

    public Instant getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Instant createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }
}
