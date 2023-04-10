package co.shop.model.mapper;

import co.shop.model.dto.RoleDTO;
import co.shop.model.entity.user.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface RoleMapper extends GenericMapper<Role, RoleDTO> {
    @Override
    Role asEntity(RoleDTO dto);
}
