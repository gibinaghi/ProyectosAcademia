package com.ayi.curso.rest.serv.ayispringrestful.mapper.impl;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.ClientRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.ClientResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Client;
import com.ayi.curso.rest.serv.ayispringrestful.mapper.IClientMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ClientMapperImpl implements IClientMapper {

    private final ModelMapper modelMapper;

    @Override
    public Client convertDtoToEntity(ClientRequest request) {
        return modelMapper.map(request, Client.class);
    }

    @Override
    public ClientResponse convertEntityToDto(Client entity) {
        return modelMapper.map(entity, ClientResponse.class);
    }
}