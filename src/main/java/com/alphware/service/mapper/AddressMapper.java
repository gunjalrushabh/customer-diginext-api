package com.alphware.service.mapper;

import com.alphware.domain.Address;
import com.alphware.domain.Customer;
import com.alphware.service.dto.AddressDTO;
import com.alphware.service.dto.CustomerDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Address} and its DTO {@link AddressDTO}.
 */
@Mapper(componentModel = "spring")
public interface AddressMapper extends EntityMapper<AddressDTO, Address> {
    @Mapping(target = "customer", source = "customer", qualifiedByName = "customerCustomerId")
    AddressDTO toDto(Address s);

    @Named("customerCustomerId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "customerId", source = "customerId")
    CustomerDTO toDtoCustomerCustomerId(Customer customer);
}
