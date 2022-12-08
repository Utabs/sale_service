package co.shop.model.mapper;

import co.shop.model.dto.ProductDTO;
import co.shop.model.entity.product.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface ProductMapper extends GenericMapper<Product, ProductDTO> {
    @Override
    Product asEntity(ProductDTO dto);
}
