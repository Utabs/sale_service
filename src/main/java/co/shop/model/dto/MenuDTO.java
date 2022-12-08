package co.shop.model.dto;

import co.shop.model.entity.menu.MenuCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MenuDTO extends AbstractDTO<Integer> {
    private Integer id;
    private String title;
    private String serviceAddress;
    private boolean enabled;
    private Instant createDate;
    private MenuCategory menuCategory;
}
