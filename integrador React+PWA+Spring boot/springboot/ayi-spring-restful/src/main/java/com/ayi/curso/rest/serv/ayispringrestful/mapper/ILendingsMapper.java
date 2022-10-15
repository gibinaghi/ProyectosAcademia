package com.ayi.curso.rest.serv.ayispringrestful.mapper;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.LendingCreateDTORequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.LendingDTOResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Lendings;

public interface ILendingsMapper {
    Lendings convertDtoToEntity(LendingCreateDTORequest request);

    LendingDTOResponse convertEntityToDto(Lendings entity);
}
