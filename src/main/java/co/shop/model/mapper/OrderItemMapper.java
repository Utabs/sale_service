package co.shop.model.mapper;

import co.shop.model.dto.OrderItemDTO;
import co.shop.model.entity.shop.OrderItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface OrderItemMapper extends GenericMapper<OrderItem, OrderItemDTO> {
    @Override
    OrderItem asEntity(OrderItemDTO dto);
}
