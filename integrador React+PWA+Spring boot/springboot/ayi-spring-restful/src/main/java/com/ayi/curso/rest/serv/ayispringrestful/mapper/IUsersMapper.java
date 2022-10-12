package com.ayi.curso.rest.serv.ayispringrestful.mapper;

import com.ayi.curso.rest.serv.ayispringrestful.dto.response.UserDTOResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Users;

public interface IUsersMapper {
    Users convertDtoToEntityAll(UserDTOResponse request);

    UserDTOResponse convertEntityToDtoAll(Users entity);
}
