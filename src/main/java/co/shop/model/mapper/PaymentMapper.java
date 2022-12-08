package co.shop.model.mapper;

import co.shop.model.dto.PaymentDTO;
import co.shop.model.entity.shop.Payment;
import co.shop.model.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface PaymentMapper extends GenericMapper<Payment, PaymentDTO> {
    @Override
//    @Mapping(target = "id", ignore = false)
    Payment asEntity(PaymentDTO dto);
}
