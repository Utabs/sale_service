package co.shop.model.mapper;

import co.shop.model.dto.RolePrivilegesDTO;
import co.shop.model.entity.user.RolePrivileges;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface RolePrivilegesMapper extends GenericMapper<RolePrivileges, RolePrivilegesDTO> {
    @Override
    RolePrivileges asEntity(RolePrivilegesDTO dto);
}
