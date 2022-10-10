package com.ayi.curso.rest.serv.ayispringrestful.mapper.impl;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.ClientDetailRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.ClientDetailResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.ClientDetail;
import com.ayi.curso.rest.serv.ayispringrestful.mapper.IClientDetailMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ClientDetailMapperImpl implements IClientDetailMapper {

    private final ModelMapper modelMapper;

    @Override
    public ClientDetail convertDtoToEntity(ClientDetailRequest request) {
        return modelMapper.map(request, ClientDetail.class);
    }

    @Override
    public ClientDetailResponse convertEntityToDto(ClientDetail entity) {
        return modelMapper.map(entity, ClientDetailResponse.class);
    }
}