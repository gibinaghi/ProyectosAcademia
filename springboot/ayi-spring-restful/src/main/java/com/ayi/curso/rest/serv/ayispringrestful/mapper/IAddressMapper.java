package com.ayi.curso.rest.serv.ayispringrestful.mapper;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.AddressCreateRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.AddressRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.AddressResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Address;

public interface IAddressMapper {
    Address convertDtoToEntityCreate(AddressCreateRequest request);

    Address convertDtoToEntity(AddressRequest request);

    AddressResponse convertEntityToDto(Address entity);
}
