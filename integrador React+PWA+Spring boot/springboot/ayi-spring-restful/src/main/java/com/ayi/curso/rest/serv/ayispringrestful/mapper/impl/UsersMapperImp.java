package com.ayi.curso.rest.serv.ayispringrestful.mapper.impl;

import com.ayi.curso.rest.serv.ayispringrestful.dto.response.UserDTOResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Users;
import com.ayi.curso.rest.serv.ayispringrestful.mapper.IUsersMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UsersMapperImp implements IUsersMapper {
    private final ModelMapper modelMapper;

    @Override
    public Users convertDtoToEntityAll(UserDTOResponse request) {

        return modelMapper.map(request, Users.class);
    }

    @Override
    public UserDTOResponse convertEntityToDtoAll(Users entity) {

        return modelMapper.map(entity, UserDTOResponse.class);
    }
}
