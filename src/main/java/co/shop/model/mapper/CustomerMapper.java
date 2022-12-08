package co.shop.model.mapper;

import co.shop.model.dto.CustomerDTO;
import co.shop.model.dto.ProductDTO;
import co.shop.model.entity.Customer;
import co.shop.model.entity.product.Product;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface CustomerMapper extends GenericMapper<Customer, CustomerDTO> {
    @Override
    Customer asEntity(CustomerDTO dto);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Customer updateProductFromProductDto(CustomerDTO customerDTO, @MappingTarget Customer customer);
}
