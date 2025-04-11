package co.shop.model.mapper;

 import co.shop.model.dto.OrderDTO;
 import co.shop.model.dto.OrderItemDto;
 import co.shop.model.entity.shop.Order;
 import co.shop.model.entity.shop.OrderItem;
 import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
 import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface OrderMapper extends GenericMapper<Order, OrderDTO> {

    @Mapping(target = "userBranch", ignore = true)
    @Mapping(target = "orderItems", ignore = true)
    Order asEntity(OrderDTO dto);

    @Mapping(target = "orderItems", source = "orderItems")
    @Mapping(target = "customer", source = "customer")
    OrderDTO asDTO(Order entity);
    @Mapping(target = "product", source = "product")
    OrderItemDto asDTO(OrderItem entity);
}
