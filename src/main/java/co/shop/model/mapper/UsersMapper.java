package co.shop.model.mapper;

import co.shop.model.dto.UsersDTO;
import co.shop.model.entity.user.Users;
import co.shop.model.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface UsersMapper extends GenericMapper<Users, UsersDTO> {
    @Override
    Users asEntity(UsersDTO dto);
}
