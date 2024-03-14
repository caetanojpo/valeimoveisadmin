package br.com.valeimoveisadm.vibuser.adapter.inbound.mapper;

import br.com.valeimoveisadm.vibuser.adapter.inbound.dto.request.ChangeAddress;
import br.com.valeimoveisadm.vibuser.application.core.domain.Address;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    Address toAddress(ChangeAddress changeAddress);
}
