package co.shop.model.entity.menu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Menu")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "Title",columnDefinition = "NVARCHAR(20)")
    private String title;

    @Column(name = "URL",columnDefinition = "NVARCHAR(50)")
    private String serviceAddress;

    @Column(name = "Enabled" )
    private boolean enabled;

    @Column(name = "CREATE_DATE")
    private Timestamp createDate;

    @ManyToOne
    @JoinColumn(name = "MenuCategory_ID", updatable = false, insertable = false)
    private MenuCategory menuCategory;

}
