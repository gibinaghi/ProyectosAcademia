package com.ayi.curso.rest.serv.ayispringrestful.mapper;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.UserCreateDTORequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.UserDTOResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Users;

public interface IUsersMapper {
    Users convertDtoToEntity(UserDTOResponse request);

    UserDTOResponse convertEntityToDto(Users entity);

    Users convertDtoToEntityCreate(UserCreateDTORequest request);

}
