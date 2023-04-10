package co.shop.model.mapper;

import co.shop.model.dto.ProductDTO;
import co.shop.model.entity.product.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface ProductMapper extends GenericMapper<Product, ProductDTO> {
    @Override
    @Mapping(target = "id", source = "id")
    @Mapping(target = "code", source = "code")
    Product asEntity(ProductDTO dto);

//    @InheritInverseConfiguration
//    ProductDTO asDto(Product product);
//
//    List<Product> asEntityList(List<ProductDTO> list);
//    List<ProductDTO> asDTOList(List<Product> list);

}
