package co.shop.model.mapper;

import co.shop.model.dto.OrderItemDto;
import co.shop.model.entity.shop.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface OrderItemMapper extends GenericMapper<OrderItem, OrderItemDto> {
    @Override
//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "order", ignore = true)
    @Mapping(target = "product", source ="product")
    @Mapping(target = "order.id", source ="orderId")
    OrderItem asEntity(OrderItemDto dto);

    @Override
    List<OrderItem> asEntityList(List<OrderItemDto> dtoList);

    @Override
    List<OrderItemDto> asDTOList(List<OrderItem> entityList);

    @Override
    @Mapping(target = "product", source ="product")
    OrderItemDto asDTO(OrderItem entity);
}
