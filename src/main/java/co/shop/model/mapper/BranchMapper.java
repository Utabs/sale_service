package co.shop.model.mapper;

import co.shop.model.dto.BranchDTO;
import co.shop.model.entity.Branch;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface BranchMapper extends GenericMapper<Branch, BranchDTO> {

    //    To skip several properties in a particular mapping method,
    @Mapping(target = "userBranches", ignore = true)
    @Override
    Branch asEntity(BranchDTO dto);
}
