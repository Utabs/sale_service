package co.shop.model.mapper;

import co.shop.model.dto.MenuCategoryDTO;
import co.shop.model.entity.menu.MenuCategory;
import co.shop.model.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface MenuCategoryMapper extends GenericMapper<MenuCategory, MenuCategoryDTO> {
    @Override
    MenuCategory asEntity(MenuCategoryDTO dto);
}
