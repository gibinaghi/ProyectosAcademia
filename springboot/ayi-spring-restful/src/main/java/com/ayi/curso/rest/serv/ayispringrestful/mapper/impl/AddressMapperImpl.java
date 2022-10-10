package com.ayi.curso.rest.serv.ayispringrestful.mapper.impl;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.AddressCreateRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.AddressRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.AddressResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Address;
import com.ayi.curso.rest.serv.ayispringrestful.mapper.IAddressMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AddressMapperImpl implements IAddressMapper {
    private final ModelMapper modelMapper;

    @Override
    public Address convertDtoToEntity(AddressRequest request) {

        return modelMapper.map(request, Address.class);
    }

    @Override
    public AddressResponse convertEntityToDto(Address entity) {

        return modelMapper.map(entity, AddressResponse.class);
    }
}
