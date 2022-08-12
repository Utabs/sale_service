package co.shop.model.entity.menu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "MenuCategory")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "Title",columnDefinition = "NVARCHAR(20)")
    private String title;

    @Column(name = "Enabled" )
    private boolean enabled;

    @Column(name = "CreateDate")
    private Timestamp createDate;

    @OneToMany(mappedBy = "menuCategory")
    private List<Menu> menus;

}
