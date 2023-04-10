package co.shop.model.mapper;

import co.shop.model.dto.PersonDTO;
import co.shop.model.entity.user.Person;
import co.shop.model.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface PersonMapper extends GenericMapper<Person, PersonDTO> {
    @Override
    Person asEntity(PersonDTO dto);
}
