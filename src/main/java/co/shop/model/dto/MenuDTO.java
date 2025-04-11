package co.shop.model.dto;

import co.shop.model.entity.menu.MenuCategory;
import lombok.*;

import java.time.Instant;

@Data
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class MenuDTO extends AbstractDTO<Integer> {
    private Integer id;
    private String title;
    private String serviceAddress;
    private boolean enabled;
    private Instant createDate;
    private MenuCategory menuCategory;
}
