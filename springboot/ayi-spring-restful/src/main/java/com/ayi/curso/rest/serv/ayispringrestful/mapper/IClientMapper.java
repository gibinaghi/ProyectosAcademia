package com.ayi.curso.rest.serv.ayispringrestful.mapper;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.ClientRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.ClientResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Client;

public interface IClientMapper {

    Client convertDtoToEntity(ClientRequest request);

    ClientResponse convertEntityToDto(Client entity);
}
