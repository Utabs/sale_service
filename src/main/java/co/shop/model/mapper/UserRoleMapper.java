package co.shop.model.mapper;

import co.shop.model.dto.UserRoleDTO;
import co.shop.model.entity.user.UserRole;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface UserRoleMapper extends GenericMapper<UserRole, UserRoleDTO> {
    @Override
    UserRole asEntity(UserRoleDTO dto);
}
