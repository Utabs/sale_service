package co.shop.model.dto;


import co.shop.model.entity.menu.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuCategoryDTO extends AbstractDTO<Integer> {
    private Integer id;
    private String title;
    private boolean enabled;
    private Instant createDate;
    private List<Menu> menus;
}
