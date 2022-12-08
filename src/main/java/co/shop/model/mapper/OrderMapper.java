package co.shop.model.mapper;

import co.shop.model.dto.OrderDTO;
import co.shop.model.entity.shop.Order;
import co.shop.model.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface OrderMapper extends GenericMapper<Order, OrderDTO> {
    @Override
    Order asEntity(OrderDTO dto);
}
