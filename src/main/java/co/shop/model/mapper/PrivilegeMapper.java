package co.shop.model.mapper;

import co.shop.model.dto.PrivilegeDTO;
import co.shop.model.entity.user.Privilege;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface PrivilegeMapper extends GenericMapper<Privilege, PrivilegeDTO> {
    @Override
     Privilege asEntity(PrivilegeDTO dto);
}
