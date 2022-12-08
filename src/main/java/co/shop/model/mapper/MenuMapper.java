package co.shop.model.mapper;

import co.shop.model.dto.MenuDTO;
import co.shop.model.entity.menu.Menu;
import co.shop.model.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface MenuMapper extends GenericMapper<Menu, MenuDTO> {
    @Override
    Menu asEntity(MenuDTO dto);
}
