package com.ayi.curso.rest.serv.ayispringrestful.mapper;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.ClientDetailRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.ClientDetailResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.ClientDetail;

public interface IClientDetailMapper {

    ClientDetail convertDtoToEntity(ClientDetailRequest request);

    ClientDetailResponse convertEntityToDto(ClientDetail entity);
}
